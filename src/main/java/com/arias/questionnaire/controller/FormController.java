package com.arias.questionnaire.controller;


import com.arias.questionnaire.dtos.AnswerDto;
import com.arias.questionnaire.service.IFormService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/form")
@AllArgsConstructor
public class FormController {

    private final IFormService iFormService;

    @PostMapping
    public ResponseEntity<?> submitQuestionnaire(@RequestBody List<AnswerDto> answers){
        int idForm = iFormService.submitQuestionnaire(answers);
        return new ResponseEntity<>("tus respuestas han sido guardadas con el id" + idForm, HttpStatus.OK);

    }
}
