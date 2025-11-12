package com.korit.servlet_study.ch10;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

/**
 *  JDBC JavaDataBaseConnection
 *
 */
public class JDBCMain {
    public static void main(String[] args) {
        // http://ip:port  -> http 프로토콜
        // jdbc:mysql://ip:port   -> jdbc:mysql 프로토콜
        // mysql의 port: 기본(3306), 우리가 설정(3309)

        // 프로토콜://IP주소:PORT번호/데이터베이스(스키마)이름

        final String URL = "jdbc:mysql://localhost:3309/student_db";
        final String USERNAME = "root";
        final String PASSWORD = "1q2w3e4r";

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");     JDBC 4버전 이상부터는 생략 가능
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); //
            String sql = """   
                    select * from student_tb where student_name = '김준일'  
                    """;
            PreparedStatement ps = connection.prepareStatement(sql); // ps는 쿼리를 입력할 입력창
            ResultSet rs = ps.executeQuery();  // ResultSet을 이용하여 중복 값을 제거해줌
            // ResultSet을 사용할 수 있는 쿼리문은 select(조회)를 하는 경우 뿐이다

            // rs.hasNext =>  while에서 next가 없을 때 까지 반복을 돌릴 때 사용
            rs.next(); // 행으로 출력을 할 때 다음 행으로 줄 바꿈을 의미
            int studentId = rs.getInt("student_id");  // getInt인 이유 컬럼이 가지고 있는 값의 자료형이 int이기 때문
            String studentName = rs.getString("student_name"); // getString인 이유 컬럼이 가지고 있는 값의 자료형이 문자열이기 때문
            System.out.println("id: " + studentId);
            System.out.println("name: " +studentName);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("데이터 베이스 연결 실패했어요.");
        }
    }
}
