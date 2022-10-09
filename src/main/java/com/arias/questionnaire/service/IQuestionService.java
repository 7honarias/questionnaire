package com.arias.questionnaire.service;

import com.arias.questionnaire.dtos.QuestionDto;
import com.arias.questionnaire.dtos.QuestionnaireDto;

import java.util.List;

public interface IQuestionService {
    QuestionnaireDto getQuestionnaire();
    int newQuestionnaire(List<QuestionDto> newQuestionnaireDto);
}
