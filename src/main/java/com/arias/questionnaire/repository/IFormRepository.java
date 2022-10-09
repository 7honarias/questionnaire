package com.arias.questionnaire.repository;

import com.arias.questionnaire.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormRepository extends JpaRepository<Form, Integer> {
}
