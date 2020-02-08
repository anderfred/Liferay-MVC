package com.anderfred.util;

import com.anderfred.model.Vacancy;
import com.anderfred.service.VacancyLocalService;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobHHApiGet {
    private String specParam = "spec";
    private String areaParam = "areas";
    private StringBuilder requestUrl;
    private VacancyLocalService vacancyLocalService;

    public void setUrl(String url) {
        requestUrl = new StringBuilder();
        requestUrl.append(url);
    }

    public JobHHApiGet(VacancyLocalService vacancyLocalService) {
        this.vacancyLocalService = vacancyLocalService;
    }

    public void addParamToUrl(String param, String value) {
        if (!param.isEmpty() && !value.isEmpty()) {
            if (requestUrl.indexOf("?") == -1) requestUrl.append("?");
            requestUrl.append(param).append("=").append(value).append("&");
        }
    }


    public StringBuilder getRequest() throws IOException {
        if (requestUrl.charAt(requestUrl.length() - 1) == '&') {
            requestUrl.deleteCharAt(requestUrl.length() - 1);

        }
        System.out.println("GET URL:" + requestUrl.toString());
        URL urlForGetRequest = new URL(requestUrl.toString());
        String readLine;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();
            connection.disconnect();
            return response;
        } else {
            System.out.println("GET NOT WORKED");
            connection.disconnect();
        }
        return null;
    }

    public Map<Integer, String> getAreas() {
        setUrl(RequestUrl.AREA.getUrl());
        StringBuilder response = null;
        try {
            response = getRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject object = null;
        try {
            object = JSONFactoryUtil.createJSONObject(response.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = object.getJSONArray(areaParam);
        return getIntegerStringMap(jsonArray);
    }

    private Map<Integer, String> getIntegerStringMap(Iterable<JSONObject> jsonArray) {
        Map<Integer, String> map = new HashMap<>();
        for (JSONObject object : jsonArray) {
            map.put(object.getInt("id"), object.getString("name"));
        }
        return map;
    }

    public Map<Integer, String> getSpecs() {
        JSONObject jsonObject = null;
        setUrl(RequestUrl.SPECIALIZATION.getUrl());
        StringBuilder response = null;
        try {
            response = getRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.insert(0, "{spec:").append("}");
        try {
            jsonObject = JSONFactoryUtil.createJSONObject(response.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = jsonObject.getJSONArray(specParam);
        return getIntegerStringMap(jsonArray);
    }

    public List<Vacancy> exampleGetRequest() {
        List<Vacancy> list = new ArrayList<>();
        setUrl(RequestUrl.VACANCY.getUrl());
        addParamToUrl("specialization", "1");
        addParamToUrl("area", "4");

        try {
            for (Vacancy v : parseVacancy((getRequest()))) {
                list.add(v);
                System.out.println(v.toString());
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Vacancy> parseVacancy(StringBuilder response) throws JSONException {
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject(response.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("items");
        List<Vacancy> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject o = jsonArray.getJSONObject(i);
            System.out.println(o.getInt("id"));
            Vacancy vacancy = vacancyLocalService.createVacancy(o.getInt("id"));
            vacancy.setText(o.getString("name"));
            vacancy.setSalary(getSalary(o));
            vacancy.setPublishedDate(o.getString("published_at"));
            vacancy.setEmployer(getEmployer(o));
            list.add(vacancy);
        }
        return list;
    }

    private String getEmployer(JSONObject object) {
        String employer = null;

        try {
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(object.getString("employer"));
            employer = jsonObject.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return employer;
    }

    private String getSalary(JSONObject object) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(object.getString("salary"));
            if (jsonObject.getString("from").equals("")) {
                stringBuilder.append("NULL");
                return stringBuilder.toString();
            } else {
                stringBuilder.append(jsonObject.getString("from"));
                if (jsonObject.getString("to").equals("")) {
                    stringBuilder.append(jsonObject.getString("currency"));
                } else {
                    stringBuilder.append("-").append(jsonObject.getString("to")).append(jsonObject.getString("currency"));
                }
                return stringBuilder.toString();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
