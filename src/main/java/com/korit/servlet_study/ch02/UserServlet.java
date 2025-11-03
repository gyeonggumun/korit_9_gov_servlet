package com.korit.servlet_study.ch02;

import lombok.AllArgsConstructor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@WebServlet("/ch2/users")
public class UserServlet extends HttpServlet {

    private List<User> users;

    @Override
    public void init()  {
        users = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // username == "test"
        // 찾으면 User 객체 응답(200), 못찾으면 해당 username은 존재하지 않습니다.(404)
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        List<User> foundUsers = users.stream()
                .filter(user -> user
                        .getUsername().equals(req.getParameter("username")))
                .toList();
        User foundUser = foundUsers.isEmpty() ? null : foundUsers.get(0);
        if (Objects.isNull(foundUser)) {
            resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().println("해당 username은 존재하지 않습니다.");
            return;
        }
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.getWriter().println(foundUser);

        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);

//        User user = User.builder()
//                .username(username)
//                .password(password)
//                .name(name)
//                .email(email)
//                .build();

//        User user = new User(username, password, name, email);

        users.add(user);
        System.out.println(users);
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("사용자 등록 완료");

    }
}
