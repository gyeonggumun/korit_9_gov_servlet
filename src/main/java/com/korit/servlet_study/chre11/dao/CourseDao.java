package com.korit.servlet_study.chre11.dao;

import com.korit.servlet_study.ch11.util.DBConnectionMgr;
import com.korit.servlet_study.chre11.entity.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDao {
   DBConnectionMgr mgr = new DBConnectionMgr();


    public void insert (Course course) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = mgr.getConnection();
            String sql = """
                    insert into 
                    course_tb
                    values(default, ?, ?, ?, ?, ?, ?, ?)
                    """;
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, course.getCourseCode());
            ps.setString(2, course.getCourseName());
            ps.setInt(3, course.getProfessorId());
            ps.setInt(4, course.getCredit());
            ps.setInt(5, course.getEnrollmentCapacity());
            ps.setString(6, course.getClassroom());

            if (ps.executeUpdate() < 1) {
                throw new SQLException();
            }

            rs = ps.getGeneratedKeys();
            while (rs.next()) {
                int courseId = rs.getInt(1);
                course.setCourseId(courseId);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mgr.freeConnection(con, ps, rs);
        }
    }
}
