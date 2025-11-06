package com.korit.servlet_study.ch01;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTest extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp){
       Object age =  req.getServletContext().getAttribute("age");
        System.out.println(age);
    }
}
