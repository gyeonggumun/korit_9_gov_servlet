package com.korit.servlet_study.ch10;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class JDBCMain2 {
    public static void main(String[] args) {
        final String URL = "jdbc:mysql://localhost:3309/student_db";
        final String USERNAME = "root";
        final String PASSWORD = "1q2w3e4r";

        String searchData = "";

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = """
                    select 
                        course_id,
                        course_code,
                        course_name,
                        professor_tb.professor_id,
                        professor_name,
                        credit,
                        enrollment_capacity,
                        classroom
                    from 
                        course_tb 
                        join professor_tb 
                        on professor_tb.professor_id = course_tb.professor_id
                    where 
                        course_name like concat('%', ? , '%')
                    """;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // ' ? ' 와일드카드 위치에 값 맵핑(1 = 몇 번째 물음표인지)
            preparedStatement.setString(1, searchData);
            // 결과를 ResultSet 객체로 가져오기
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
//                Map<String, Object> resultMap = Map.of(
//                        "course_id", rs.getInt("course_id"),
//                        "course_code", rs.getString("course_code"),
//                        "course_name", rs.getString("course_name"),
//                        "professor_name", rs.getString("professor_name"),
//                        "credit", rs.getInt("credit"),
//                        "enrollment_capacity", rs.getInt("enrollment_capacity"),
//                        "classroom", rs.getString("classroom")
//                );

                Map<String, Object> resultMap = new LinkedHashMap<>();
                resultMap.put( "course_id", rs.getInt("course_id"));
                resultMap.put( "course_code", rs.getString("course_code"));
                resultMap.put( "course_name", rs.getString("course_name"));
                resultMap.put("professor_name", rs.getString("professor_name"));
                resultMap.put( "credit", rs.getInt("credit"));
                resultMap.put( "enrollment_capacity", rs.getInt("enrollment_capacity"));
                resultMap.put( "classroom", rs.getString("classroom"));
                System.out.println(resultMap);

                // 객체 정의 사용 방법
                @Data
                @AllArgsConstructor
                class Professor {
                    private int professorId;
                    private String professorName;
                }

                @Data
                @AllArgsConstructor
                class Course {
                    private int courseId;
                    private String courseCode;
                    private String courseName;
                    private Professor professor;
                    private int credit;
                    private int enrollmentCapacity;
                    private String classroom;
                }

                Course course = new Course(
                        rs.getInt("course_id"),
                        rs.getString("course_code"),
                        rs.getString("course_name"),
                        new Professor(rs.getInt("professor_id"), rs.getString("professor_name")),
                        rs.getInt("credit"),
                        rs.getInt("enrollment_capacity"),
                        rs.getString("classroom")
                );
                System.out.println(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("데이터 베이스 연결 실패");
        }

//        System.out.println("과목ID: " + rs.getInt("course_id"));
//        System.out.println("과목코드: " + rs.getString("course_code"));
//        System.out.println("과목명: " + rs.getString("course_name"));
//        System.out.println("교수명: " + rs.getString("professor_name"));
//        System.out.println("학점: " + rs.getInt("credit"));
//        System.out.println("수강인원: " + rs.getInt("enrollment_capacity"));
//        System.out.println("강의실: " + rs.getString("classroom"));
    }
}
