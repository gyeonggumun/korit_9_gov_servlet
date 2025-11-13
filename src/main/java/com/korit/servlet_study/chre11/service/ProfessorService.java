package com.korit.servlet_study.chre11.service;


import com.korit.servlet_study.chre11.dao.ProfessorDao;
import com.korit.servlet_study.chre11.entity.Professor;

import java.util.List;

public class ProfessorService {
    private ProfessorDao professorDao;

    public List<Professor> getProfessors () {
        return professorDao.findAll();
    }


}
