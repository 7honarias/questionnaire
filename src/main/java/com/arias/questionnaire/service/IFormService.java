package com.arias.questionnaire.service;

import com.arias.questionnaire.dtos.AnswerDto;

import java.util.List;

public interface IFormService {

    int submitQuestionnaire(List<AnswerDto> answerDtoList);

}
