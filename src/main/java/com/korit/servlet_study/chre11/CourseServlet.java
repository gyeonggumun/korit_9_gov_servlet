package com.korit.servlet_study.chre11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korit.servlet_study.ch11.util.DBConnectionMgr;
import com.korit.servlet_study.chre11.dao.CourseDao;
import com.korit.servlet_study.chre11.dto.CourseDto;
import com.korit.servlet_study.chre11.entity.Course;
import com.korit.servlet_study.chre11.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/courses")
public class CourseServlet extends HttpServlet {




//    private CourseService courseService;
//    private ObjectMapper objectMapper;
//
//    @Override
//    public void init() throws ServletException {
//        courseService = new CourseService(new CourseDao(DBConnectionMgr.getInstance()));
//        objectMapper = new ObjectMapper();
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        CourseDto courseDto = objectMapper.readValue(req.getReader(), CourseDto.class);
//        Course saveCourse = courseService.save(courseDto);
//        objectMapper.writeValue(resp.getWriter(), saveCourse);
//    }

}
