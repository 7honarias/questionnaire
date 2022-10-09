package com.arias.questionnaire.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    private String text;
    private String type;
    private List<OptionDto> optionDtoList;
}
