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

    public List<Professor> findAllLikeName(String name){
        DBConnectionMgr mgr = DBConnectionMgr.getInstance();
        List<Professor> professors = new ArrayList<>();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
            try {
                con = mgr.getConnection();  //
                String sql = """
                        select
                            professor_id,
                            professor_name
                        from
                            professor_tb
                        where
                            professor_name like concat('%',?,'%')
                        """;
                ps = con.prepareStatement(sql);  //  ps에 sql문을 담음
                ps.setString(1, name);  // sql문의 와일절 ?에 값을 추가
                // 행을이동시키는 행위, get행위 두가지 행위를 하는 ResultSet사용
                rs = ps.executeQuery();  // ps안에 들어있는 sql문을 실행
                while (rs.next()) {
                    Professor professor = Professor.builder()
                            .professorID(rs.getInt("professor_id"))
                            .professorName(rs.getString("professor_name"))
                            .build();
                    professors.add(professor);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                mgr.freeConnection(con, ps, rs);

            }
            return professors;
        }
//    private final DBConnectionMgr mgr;
//
//    Connection con = null;
//    PreparedStatement ps = null;
//    ResultSet rs = null;
//
//    public List<Professor> findAll () {
//        List<Professor> professors = new ArrayList<>();
//        try {
//            con = mgr.getConnection();
//            String sql = """
//                    select
//                        professor_id,
//                        professor_name
//                    from
//                        professor_tb
//                    """;
//            ps = con.prepareStatement(sql);
//            ps.getGeneratedKeys();
//            rs = ps.executeQuery();
//
//
//            while (rs.next()) {
//                Professor professor = Professor.builder()
//                        .professorID(rs.getInt("professor_id"))
//                        .professorName(rs.getString("professor_name"))
//                        .build();
//                professors.add(professor);
//            }
//            ps.execute();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            mgr.freeConnection(con, ps, rs);
//        }
//        return professors;

}
