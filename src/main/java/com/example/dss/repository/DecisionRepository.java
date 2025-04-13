package com.example.dss.repository;


import com.example.dss.model.DecisionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DecisionRepository extends JpaRepository<DecisionModel, Long> {

}
