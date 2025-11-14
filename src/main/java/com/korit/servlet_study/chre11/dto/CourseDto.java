package com.korit.servlet_study.chre11.dto;

import com.korit.servlet_study.chre11.entity.Course;

public class CourseDto {
    private String Code;
    private String Name;
    private int professor;
    private int credit;
    private int enrollment;
    private String classroom;

    public Course isEmpty () {
        return Course.builder()
                .courseCode(Code)
                .courseName(Name)
                .professorId(professor)
                .credit(credit)
                .enrollmentCapacity(enrollment)
                .classroom(classroom)
                .build();
    }
}
