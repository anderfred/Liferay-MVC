package com.anderfred.util;

public enum RequestUrl {
    VACANCY("https://api.hh.ru/vacancies"),
    SPECIALIZATION("https://api.hh.ru/specializations/"),
    AREA("https://api.hh.ru/areas/113"); //113 = RUSSIA

    private String url;

    RequestUrl(String reqUrl) {
        this.url = reqUrl;
    }

    public String getUrl() {
        return url;
    }
}
