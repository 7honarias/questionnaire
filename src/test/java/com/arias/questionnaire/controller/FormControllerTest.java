package com.arias.questionnaire.controller;

import com.arias.questionnaire.dtos.AnswerDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class FormControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void SubmitANewQuestionnaireReturnOK() throws Exception {
        List<AnswerDto> answerDtoList = new ArrayList<>();
        AnswerDto answerDto = new AnswerDto();
        answerDto.setQuestion("cedula");
        answerDto.setAnswer("12334");
        answerDtoList.add(answerDto);

        mvc.perform(
                        MockMvcRequestBuilders.post("/form")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(answerDtoList)))
                .andExpect(status().isOk())
                .andReturn();

    }

}
