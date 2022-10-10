package com.arias.questionnaire.controller;

import com.arias.questionnaire.dtos.OptionDto;
import com.arias.questionnaire.dtos.QuestionDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class questionnaireControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createANewQuestionnaire() throws Exception {

        List<QuestionDto> questionDtoList = new ArrayList<>();
        QuestionDto questionDto = new QuestionDto();
        questionDto.setType("SINGLE");
        questionDto.setText("cedula");
        questionDtoList.add(questionDto);
        QuestionDto questionDto1 = new QuestionDto();
        questionDto1.setText("como calificaria el servicio");
        questionDto1.setType("MULTIPLE");

        List<OptionDto> optionDtoList = new ArrayList<>();
        OptionDto optionDto = new OptionDto();
        optionDto.setText("Malo");
        optionDto.setText("Regular");
        optionDto.setText("Aceptable");
        optionDto.setText("Bueno");
        optionDto.setText("Excelente");
        optionDtoList.add(optionDto);
        questionDto1.setOptions(optionDtoList);



        MvcResult resultGetQuestionnaire = mvc.perform(
                        MockMvcRequestBuilders.post("/questionnaire")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(questionDtoList)))
                .andExpect(status().isOk())
                .andReturn();


        String resultado = resultGetQuestionnaire.getResponse().getContentAsString();
        Assertions.assertEquals("1 preguntas creadas con exito", resultado);

        mvc.perform(MockMvcRequestBuilders
                        .get("/questionnaire/")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.questions").exists());


    }

}
