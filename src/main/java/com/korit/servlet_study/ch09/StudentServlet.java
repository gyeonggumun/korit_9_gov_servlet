package com.korit.servlet_study.ch09;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@WebServlet("/ch09/students")
public class StudentServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = new StudentRepository();
        config.getServletContext().setAttribute("sr", studentRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchNameValue = req.getParameter("searchName");
        objectMapper.writeValue(resp.getWriter(), studentRepository.findAllBySearchNameValue(searchNameValue));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Student student = objectMapper.readValue(req.getReader(), Student.class);
        studentRepository.insert(student);

        objectMapper.writeValue(resp.getWriter(), Map.of("message", "학생정보 추가 완료"));

    }
}
