package com.korit.servlet_study.ch09;

import com.fasterxml.jackson.databind.ObjectMapper;

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
    List<Student> students = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        // 이름에 필터링을 거는 로직
        String searchNameValue = req.getParameter("searchName");
        if (Objects.isNull(searchNameValue)) {
            objectMapper.writeValue(resp.getWriter(), students);
            return;
        }
        List<Student> foundStudents = students.stream()
                .filter(student -> student.getName().contains(searchNameValue))
                .toList();
            objectMapper.writeValue(resp.getWriter(), foundStudents);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("application/json");

        ObjectMapper objectMapper = new ObjectMapper();
        students.add(objectMapper.readValue(req.getReader(), Student.class));
        System.out.println(students);

        objectMapper.writeValue(resp.getWriter(), Map.of("message", "학생정보 추가 완료"));

    }
}
