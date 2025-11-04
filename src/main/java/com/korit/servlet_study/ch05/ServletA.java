package com.korit.servlet_study.ch05;

import java.nio.charset.StandardCharsets;

public class ServletA extends Servlet{
    @Override
    public void doGet(Request req, Response resp) {
        System.out.println("서블릿 A에서 GET 호출");
        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setData("응답 데이터");
    }

    @Override
    public void doPost(Request req, Response resp) {
        System.out.println("서블릿 A에서 POST 호출");
    }
}
