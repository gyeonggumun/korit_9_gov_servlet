package com.korit.servlet_study.ch08;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korit.servlet_study.HelloServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ch08/boards")
public class BoardServlet extends HelloServlet {
    List<Board> boardList = new ArrayList<>();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();
//        StringBuilder stringBuilder = new StringBuilder();
//        BufferedReader bufferedReader = req.getReader();
        // bufferedReader의 문제점
        // 데이터가 많아지면 전송 속도가 느려진다
//        String json = "";
//        while (true) {
//            json = bufferedReader.readLine();
//            if (json == null) {
//                break;
//            }
//            stringBuilder.append(json);
//        }
//        System.out.println(stringBuilder);
        // req.getReader
         boardList.add
                 (objectMapper.readValue(req.getReader(), Board.class));
        System.out.println(boardList);

        Response response = new Response();
        response.setMessage("게시글 작성 완료");
        objectMapper.writeValue(resp.getWriter() , response);



    }
}
