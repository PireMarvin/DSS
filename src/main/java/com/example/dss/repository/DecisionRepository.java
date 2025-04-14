package com.example.dss.repository;


import com.example.dss.model.DecisionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DecisionRepository extends JpaRepository<DecisionModel, Long> {

    List<DecisionModel> findAllDecisionById(int id);

    @Query("SELECT decision")
    List<Long> findDecisionIdsByUserId(@Param("userId") Long userId);
}
