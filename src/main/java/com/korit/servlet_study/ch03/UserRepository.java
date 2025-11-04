package com.korit.servlet_study.ch03;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserRepository {
    private static UserRepository instance;
    private List<User> users;
    private Long autoId = 0l;  //초기값이 null로 들어가기 때문에 초기값 설정

    private UserRepository() { // UserRepository를 생성할 때 리스트가 하나 생성
        users = new ArrayList<>();
    }

    public static UserRepository getInstance() {  // 싱글톤
        if (Objects.isNull(instance)) {
            instance = new UserRepository();
        }
        return  instance;
    }

    public void insert(User user) {
        user.setId(++autoId);
        users.add(user);
    }

    public User findByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseGet(() -> null);  // null인지를 확인

    }

    public User findByUsernameNonOptional(String username) {
        List<User> foundUsers = users.stream()
                .filter(user -> user.getUsername().equals(username))
                .toList();
        if (foundUsers.isEmpty()) {
            return null;
        }
        return foundUsers.get(0);
    }

    public List<User> findAll() {
        return users;
    }


}
