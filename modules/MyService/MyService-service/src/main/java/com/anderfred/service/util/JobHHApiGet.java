package com.anderfred.service.util;

import com.anderfred.model.Vacancy;
import com.anderfred.service.persistence.VacancyUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobHHApiGet {
    private String specParam = "spec";
    private String areaParam = "areas";
    private StringBuilder requestUrl;
    private static final Log _log = LogFactoryUtil.getLog(
            JobHHApiGet.class);

    public void setUrl(String url) {
        requestUrl = new StringBuilder();
        requestUrl.append(url);
        _log.info("setting URL:" + requestUrl.toString());
    }

    public void addParamToUrl(String param, String value) {
        if (!param.isEmpty() && !value.isEmpty()) {
            if (requestUrl.indexOf("?") == -1) requestUrl.append("?");
            requestUrl.append(param).append("=").append(value).append("&");
            _log.info("adding param " + param + " value:" + value);
        }
    }


    public StringBuilder getRequest() throws IOException {
        if (requestUrl.charAt(requestUrl.length() - 1) == '&') {
            requestUrl.deleteCharAt(requestUrl.length() - 1);

        }
        URL urlForGetRequest = new URL(requestUrl.toString());
        String readLine;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            _log.info("response code:" + responseCode);
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
            _log.error("Error to make get request URL:" + requestUrl.toString());
            connection.disconnect();
        }
        return null;
    }

    public Map<Integer, String> getAreasRequest() {
        setUrl(RequestUrl.AREA.getUrl());
        addParamToUrl("per_page", "25");
        _log.info("getting areas");
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

    public Map<Integer, String> getSpecRequest() {
        JSONObject jsonObject = null;
        setUrl(RequestUrl.SPECIALIZATION.getUrl());
        addParamToUrl("per_page", "25");
        _log.info("get spec request");
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
        int area = 4;
        int spec = 1;
        List<Vacancy> list = new ArrayList<>();
        setUrl(RequestUrl.VACANCY.getUrl());
        addParamToUrl("specialization", "1");
        addParamToUrl("area", "4");
        addParamToUrl("per_page", "25");
        addParamToUrl("vacancy_search_order", "publication_time");
        _log.info("make example request. URL:" + requestUrl.toString());
        try {
            for (Vacancy v : parseVacancy((getRequest()), area, spec)) {
                list.add(v);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        _log.info("exampleGetRequest added :" + list.size() + " to return");
        return list;
    }

    public List<Vacancy> parseVacancy(StringBuilder response, int area, int spec) throws JSONException {
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject(response.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("items");
        List<Vacancy> list = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject o = jsonArray.getJSONObject(i);
            Vacancy vacancy = VacancyUtil.create(o.getInt("id"));
            vacancy.setText(o.getString("name"));
            vacancy.setSalary(getSalary(o));
            //Date date = new Date(o.getString("published_at"));
            try {
                vacancy.setPublishedDate(simpleDateFormat.parse(o.getString("published_at")));
            } catch (ParseException e) {
                _log.error("Date parse error ", e);
                e.printStackTrace();
            }
            vacancy.setEmployer(getEmployer(o));
            vacancy.setArea(area);
            vacancy.setSpec(spec);
            list.add(vacancy);
        }
        _log.info("parseVacancy added " + list.size() + " to return");
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
                stringBuilder.append("Не указано");
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
