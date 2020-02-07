package com.anderfred.util;

import com.anderfred.model.Vacancy;
import com.anderfred.service.VacancyLocalService;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import org.osgi.service.component.annotations.Reference;

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
    private static StringBuilder requestUrl;
    @Reference
    static VacancyLocalService vacancyLocalService;

    private static VacancyLocalService getVacancyLocalService() {
        return vacancyLocalService;
    }

    public static void setUrl(String url) {
        requestUrl = new StringBuilder();
        requestUrl.append(url);
    }

    public static void addParamToUrl(String param, String value) {
        if (!param.isEmpty() && !value.isEmpty()) {
            if (requestUrl.indexOf("?") != -1) requestUrl.append("?");
            requestUrl.append(param).append("=").append(value).append("&");
        }
    }



    public static JSONArray getRequest(String keyword) throws IOException {
        JSONArray jsonArray = null;
        if (requestUrl.charAt(requestUrl.length() - 1) == '&') {
            requestUrl.deleteCharAt(requestUrl.length() - 1);
        }

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
            try {
                if (keyword.equals("spec")) response.insert(0, "{spec:").append("}");
                JSONObject object = JSONFactoryUtil.createJSONObject(response.toString());
                jsonArray = object.getJSONArray(keyword);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("GET NOT WORKED");
        }
        connection.disconnect();
        return jsonArray;
    }

    public static List<Vacancy> parseVacancy(JSONArray array) {
        List<Vacancy> list = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            Vacancy vacancy = getVacancyLocalService().createVacancy(jsonObject.getInt("id"));
            vacancy.setId(jsonObject.getInt("id"));
            vacancy.setEmployer(getEmployer(jsonObject));
            vacancy.setPublishedDate(jsonObject.getString("published_id"));
            vacancy.setSalary(getSalary(jsonObject));
            vacancy.setText(jsonObject.getString("name"));
            list.add(vacancy);
        }
        return list;
    }

    private static String getEmployer(JSONObject object) {
        String employer = null;

        try {
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(object.getString("employer"));
            employer = jsonObject.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return employer;
    }

    private static String getSalary(JSONObject object) {
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

    public static Map<Integer, String> parseJSONData(JSONArray array) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            map.put(jsonObject.getInt("id"), jsonObject.getString("name"));
        }
        return map;
    }
}
