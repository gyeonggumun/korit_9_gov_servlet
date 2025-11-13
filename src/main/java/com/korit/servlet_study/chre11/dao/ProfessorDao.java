package com.korit.servlet_study.chre11.dao;

import com.korit.servlet_study.ch11.util.DBConnectionMgr;
import com.korit.servlet_study.chre11.entity.Professor;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ProfessorDao {
    private final DBConnectionMgr mgr;

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Professor> findAll () {
        List<Professor> professors = new ArrayList<>();
        try {
            con = mgr.getConnection();
            String sql = """
                    select
                        professor_id,
                        professor_name
                    from
                        professor_tb
                    """;
            ps = con.prepareStatement(sql);
            ps.getGeneratedKeys();
            rs = ps.executeQuery();


            while (rs.next()) {
                Professor professor = Professor.builder()
                        .professorID(rs.getInt("professor_id"))
                        .professorName(rs.getString("professor_name"))
                        .build();
                professors.add(professor);
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mgr.freeConnection(con, ps, rs);
        }
        return professors;
    }
}
