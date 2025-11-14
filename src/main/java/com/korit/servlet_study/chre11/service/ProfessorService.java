package com.korit.servlet_study.chre11.service;


import com.korit.servlet_study.chre11.dao.ProfessorDao;
import com.korit.servlet_study.chre11.entity.Professor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProfessorService {

    // 받아온 파라미터를 Dao의 함수에 적용시켜 실행시키는 행위
    public List<Professor> getProfessors(String query) {
        ProfessorDao professorDao = new ProfessorDao();
        return professorDao.findAllLikeName(query);
    }


//    private final ProfessorDao professorDao;
//
//    public List<Professor> getProfessors () {
//        return professorDao.findAll();
//    }


}
