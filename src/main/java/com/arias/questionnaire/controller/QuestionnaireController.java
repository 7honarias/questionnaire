package com.arias.questionnaire.controller;

import com.arias.questionnaire.dtos.QuestionDto;
import com.arias.questionnaire.service.IQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionnaire")
@AllArgsConstructor
public class QuestionnaireController {

    private final IQuestionService iQuestionService;

    @PostMapping
    public ResponseEntity<?> createQuestionnaire(@RequestBody List<QuestionDto> newQuestionnaireDto){
        int totalQuestions = iQuestionService.newQuestionnaire(newQuestionnaireDto);
        return  new ResponseEntity<>(totalQuestions + " preguntas creadas con exito", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getQuestionnaire(){

        return new ResponseEntity<>(iQuestionService.getQuestionnaire(), HttpStatus.OK);
    }
}
