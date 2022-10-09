package com.arias.questionnaire.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String cedula;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Answer> answers;
}
