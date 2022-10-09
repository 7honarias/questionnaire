package com.arias.questionnaire.service.impl;

import com.arias.questionnaire.dtos.AnswerDto;
import com.arias.questionnaire.model.Answer;
import com.arias.questionnaire.model.Form;
import com.arias.questionnaire.repository.IFormRepository;
import com.arias.questionnaire.service.IFormService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class FormService implements IFormService {

    private final String CEDULA = "cedula";
    private final IFormRepository iFormRepository;


    @Override
    public int submitQuestionnaire(List<AnswerDto> answerDtoList) {
        Form form = new Form();
        Set<Answer> answers = new HashSet<>();
        for(AnswerDto answerDto: answerDtoList){
            if(answerDto.getQuestion().equals(CEDULA)){
                form.setCedula(answerDto.getAnswer());
            }
            Answer answer = new Answer();
            answer.setQuestion(answerDto.getQuestion());
            answer.setAnswer(answerDto.getAnswer());
            answers.add(answer);
        }
        form.setAnswers(answers);
        Form formSaved = iFormRepository.save(form);

        return formSaved.getId();

    }
}
