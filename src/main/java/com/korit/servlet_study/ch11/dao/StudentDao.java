package com.korit.servlet_study.ch11.dao;

import com.korit.servlet_study.ch11.entity.Student;
import com.korit.servlet_study.ch11.util.DBConnectionMgr;
import lombok.RequiredArgsConstructor;

import java.sql.*;

@RequiredArgsConstructor
public class StudentDao {
    private final DBConnectionMgr mgr;

    public void insert(Student student) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = mgr.getConnection();
            String sql = """
                    insert into student_tb
                    values (default, ?, ?, ?, ?, ?, ?, ?)
                    """;
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, student.getStudentName());
            ps.setString(2, student.getPhone());
            ps.setString(3, student.getEmail());
            ps.setInt(4, student.getDepartmentId());
            ps.setInt(5, student.getGrade());
            ps.setString(6, student.getMajorType());
            ps.setString(7, student.getAdmissionYear());

            // MySql에서의 컨트롤 엔터키와 같은 기능을 함
            if(!ps.execute()) { // 입력을 성공하는지 안하는지에 대한 if문
                throw new SQLException();
            }

            rs = ps.getGeneratedKeys();
            while (rs.next()) {
                int studentId = rs.getInt(1);
                student.setStudentId(studentId);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mgr.freeConnection(con, ps, rs);
        }
    }
}
