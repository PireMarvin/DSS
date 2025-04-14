package com.example.dss.repository;

import com.example.dss.model.DefDecisionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DefDecisionRepository extends JpaRepository<DefDecisionModel, Long> {

    List<DefDecisionModel> findDefDecisionById(int id);
}
