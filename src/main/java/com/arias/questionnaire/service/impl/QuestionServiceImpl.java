package com.arias.questionnaire.service.impl;

import com.arias.questionnaire.common.TypeQuestion;
import com.arias.questionnaire.dtos.OptionDto;
import com.arias.questionnaire.dtos.QuestionDto;
import com.arias.questionnaire.dtos.QuestionnaireDto;
import com.arias.questionnaire.model.Option;
import com.arias.questionnaire.model.Question;
import com.arias.questionnaire.repository.IQuestionRepository;
import com.arias.questionnaire.service.IQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements IQuestionService {

    private final IQuestionRepository iQuestionRepository;


    @Override
    public QuestionnaireDto getQuestionnaire() {
        List<Question> questions = iQuestionRepository.findAll();

        return new QuestionnaireDto(questions);
    }

    @Override
    public int
    newQuestionnaire(List<QuestionDto> newQuestionnaireDto) {
        for(QuestionDto questionDto : newQuestionnaireDto){
            Question question = new Question();
            question.setType(questionDto.getType());
            question.setQuestion(questionDto.getText());
            if (questionDto.getType().equals(TypeQuestion.MULTIPLE.name())){
                Set<Option> options = new HashSet<>();
                for(OptionDto answerDto : questionDto.getOptionDtoList()){
                    Option option = new Option();
                    option.setText(answerDto.getText());
                    options.add(option);
                }
                question.setOptions(options);
            }
            iQuestionRepository.save(question);
        }
        return iQuestionRepository.findAll().size();
    }
}
