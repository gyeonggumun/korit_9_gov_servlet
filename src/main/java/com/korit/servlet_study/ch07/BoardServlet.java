package com.korit.servlet_study.ch07;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korit.servlet_study.HelloServlet;
import com.korit.servlet_study.ch03.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/ch07/boards")
public class BoardServlet extends HelloServlet {
    private BoardRepository boardRepository;
    private ObjectMapper objectMapper;

    @Override
    public void init() {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType("application/json");
//        List<String> strList = boardRepository.getBoards().toString();
//        objectMapper.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("application/json");

//        Map<String, String> boardMap = new

    }
}
