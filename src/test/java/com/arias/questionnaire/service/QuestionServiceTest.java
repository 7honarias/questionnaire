package com.arias.questionnaire.service;


import com.arias.questionnaire.dtos.QuestionDto;
import com.arias.questionnaire.dtos.QuestionnaireDto;
import com.arias.questionnaire.model.Question;
import com.arias.questionnaire.repository.IQuestionRepository;
import com.arias.questionnaire.service.impl.QuestionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {


    @Mock
    IQuestionRepository questionRepository;

    @InjectMocks
    QuestionServiceImpl questionService;

    @Test
    public void guardaCorrectamenteELQuestionario() {

        List<QuestionDto> questionDtoList = new ArrayList<>();

        QuestionDto questionDto = new QuestionDto();
        questionDto.setText("cedula");
        questionDto.setType("SINGLE");
        questionDtoList.add(questionDto);

        QuestionDto questionDto1 = new QuestionDto();
        questionDto1.setText("Nombre");
        questionDto1.setType("SINGLE");
        questionDtoList.add(questionDto1);

        List<Question> questionList = new ArrayList<>();
        Question question = new Question();
        Question question1 = new Question();
        questionList.add(question);
        questionList.add(question1);


        when(questionRepository.findAll()).thenReturn(questionList);

        int questionsTotal = questionService.newQuestionnaire(questionDtoList);
        assertEquals(2, questionsTotal);

    }

    @Test
    public void GetCorrectamenteELQuestionario() {

        List<Question> questionList = new ArrayList<>();
        Question question = new Question();
        Question question1 = new Question();
        questionList.add(question);
        questionList.add(question1);
        
        when(questionRepository.findAll()).thenReturn(questionList);

        QuestionnaireDto questionnaire = questionService.getQuestionnaire();
        assertEquals(2, questionnaire.getQuestions().size());

    }
}
