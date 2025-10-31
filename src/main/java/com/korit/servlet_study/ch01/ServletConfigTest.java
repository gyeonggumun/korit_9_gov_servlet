package com.korit.servlet_study.ch01;

import com.korit.servlet_study.HelloServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletConfigTest extends HelloServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp){
       Object age =  req.getServletContext().getAttribute("age");
        System.out.println(age);
    }
}
