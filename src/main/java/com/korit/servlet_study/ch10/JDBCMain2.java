package com.korit.servlet_study.ch10;


import java.sql.*;

public class JDBCMain2 {
    public static void main(String[] args) {
        final String URL = "jdbc:mysql://localhost:3309/student_db";
        final String USERNAME = "root";
        final String PASSWORD = "1q2w3e4r";

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = """
                    select 
                        * 
                    from course_tb 
                        join professor_tb 
                            on professor_tb.professor_id = course_tb.professor_id
                    where 
                        course_name = '프로그래밍언어론'
                    """;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            System.out.println("과목ID: " + rs.getInt("course_id"));
            System.out.println("과목코드: "+ rs.getString("course_code"));
            System.out.println("과목명: " + rs.getString("course_name"));
            System.out.println("교수명: " + rs.getString("professor_name"));
            System.out.println("학점: " + rs.getInt("credit"));
            System.out.println("수강인원: " + rs.getInt("enrollment_capacity"));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("데이터 베이스 연결 실패");
        }
    }
}
