package com.arias.questionnaire.dtos;

import com.arias.questionnaire.model.Question;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class QuestionnaireDto {
    private List<Question> questions;
}
