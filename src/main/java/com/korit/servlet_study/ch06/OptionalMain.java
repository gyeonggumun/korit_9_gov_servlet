package com.korit.servlet_study.ch06;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        // Optional 생성
        Optional<String> stringOptional1 = Optional.empty();  //비어 있는 Optional생성
        Optional<String> stringOptional2 = Optional.of("데이터");  // null을 넣을 수 없음
        // 값이 있을 때도 있고 없을 때도 있을 때 ofNullable사용
        Optional<String> stringOptional3 = Optional.ofNullable(null);  // null을 넣을 수 있음

        boolean flag = false;
        Optional<String> op = Optional.ofNullable(flag ? "데이터1" : null);
        System.out.println(op);

        // Optional 에서 값 가져오기
        // 값이 없을겨우 NoSuchElementExeption 발생
//        System.out.println(op.get());

        // 안에 값이 없을경우 null을 반환하도록 함
        System.out.println(op.orElseGet(() -> null));
        System.out.println(op.orElseGet(() -> "데이터2"));
        // 안에 값이 없으면 데이터를 대체하여 반환
        System.out.println(op.orElse("데이터3"));

        // 조건부로 값 가져오기
        System.out.println(op.isEmpty());  // 비어있으면 true
        System.out.println(op.isPresent());  // 값이 들어있으면 true

        if (op.isPresent()) {
            System.out.println(op.get());
        } else {
            System.out.println("null");
        }

        // 조건부 + Optional
        op.ifPresent(value -> System.out.println("값이 있으면 " + value));  // 만약에 값이 있다면 내용을 수행하겠다.
        // if else if와 같이 조건을 두가지 수행
        op.ifPresentOrElse(
                value -> System.out.println("값이 있으면 " + value),  //값이 있으면 발동
                () -> System.out.println("값이 없어서 이거 실행됨")     // 값이 없으면 발동
        );


        try {
            String data = op.orElseThrow();
            System.out.println("예외 안터지고 실행됨: " + data);
        } catch (NoSuchElementException e) {
            System.out.println("예외 터짐");
        }
        try {
            String data = op.orElseThrow(() -> new RuntimeException("내가 생성한 예외"));
        } catch (NoSuchElementException e) {

        } catch (RuntimeException e) {
            e.printStackTrace();
            System.out.println("이쪽으로 예외 처리함");
        }
    }
}
