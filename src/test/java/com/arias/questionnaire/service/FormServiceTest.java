package com.arias.questionnaire.service;

import com.arias.questionnaire.dtos.AnswerDto;
import com.arias.questionnaire.model.Form;
import com.arias.questionnaire.repository.IFormRepository;
import com.arias.questionnaire.service.impl.FormService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FormServiceTest {

    @Mock
    IFormRepository formRepository;

    @InjectMocks
    FormService formService;

    @Test
    public void guardaCorrectamenteRespuestasQuestionario() {

        List<AnswerDto> answerDtoList = new ArrayList<>();

        AnswerDto answerDto = new AnswerDto();
        answerDto.setQuestion("cedula");
        answerDto.setAnswer("19333");
        answerDtoList.add(answerDto);
        AnswerDto answerDto1 = new AnswerDto();
        answerDto1.setQuestion("edad");
        answerDto1.setAnswer("17");
        answerDtoList.add(answerDto1);

        Form form = new Form();
        form.setId(1);

        when(formRepository.save(any())).thenReturn(form);

        int idForm = formService.submitQuestionnaire(answerDtoList);
        assertEquals(1,idForm);

    }

}
