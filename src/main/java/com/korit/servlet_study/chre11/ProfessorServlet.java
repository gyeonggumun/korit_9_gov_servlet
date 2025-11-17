package com.korit.servlet_study.chre11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korit.servlet_study.ch11.util.DBConnectionMgr;
import com.korit.servlet_study.chre11.dao.ProfessorDao;
import com.korit.servlet_study.chre11.entity.Professor;
import com.korit.servlet_study.chre11.service.ProfessorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/professors")  // 톰켓이 찾아오도록 메핑하는 행위
public class ProfessorServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // q 파람 뽑아내기
        String q = req.getParameter("q");  // 파라미터 q 를 뽑아서 변수 p에 저장
        ProfessorService professorService = new ProfessorService();

        List<Professor> professors = professorService.getProfessors(q);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(resp.getWriter(), professors);
    }




    //    private ProfessorService professorService;
//    private ObjectMapper objectMapper;
//
//    @Override
//    public void init() throws ServletException {
//        DBConnectionMgr dbConnectionMgr = new DBConnectionMgr();
//        ProfessorDao professorDao = new ProfessorDao(dbConnectionMgr);
//        professorService = new ProfessorService(professorDao);
//        objectMapper =  new ObjectMapper();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Professor> professors = professorService.getProfessors();
//        objectMapper.writeValue(resp.getWriter(), professors);
//
//    }
//

}
