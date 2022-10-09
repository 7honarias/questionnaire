package com.arias.questionnaire.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class AnswerDto {
    private String question;
    private String answer;
}
