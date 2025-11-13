package com.korit.servlet_study.chre11.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Professor {
    private int professorID;
    private String professorName;


}
