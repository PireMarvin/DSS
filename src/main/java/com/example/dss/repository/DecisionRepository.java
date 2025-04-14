package com.example.dss.repository;


import com.example.dss.model.DecisionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DecisionRepository extends JpaRepository<DecisionModel, Long> {

    List<DecisionModel> findAllDecisionById(int id);

    @Query("SELECT decision")
    List<int> findDecisionIdsByUserId(@Param("userId") int userId);
}
