package com.korit.servlet_study.ch01;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstServlet extends HttpServlet {
    // 주소에는 소문자만 사용

    public FirstServlet() {  // 생성자 호출이 가장 먼저 발생
        System.out.println("FirstServlet 생성자 호출");
    }

    @Override
    public void init(ServletConfig config) {  // 생성자 다음 호출됨
        System.out.println("초기화");
        config.getServletContext().setAttribute("age", 32);
    }

    @Override
    public void destroy() {    // 서버가 종료되면 호출
        System.out.println("소멸");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) { // init메서드 후 호출
        System.out.println("서비스 메서드 요청 들어옴");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("요청들어옴");
    }


}
