package com.example.dss.repository.temp;


import com.example.dss.model.temp.DecisionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DecisionRepository extends JpaRepository<DecisionModel, Long> {

    List<DecisionModel> findAllDecisionById(int id);

    @Query("SELECT d.id FROM DefDecisionModel d WHERE d.user.id = :userId")
    List<Long> findDecisionIdsByUserId(@Param("userId") Long userId);
}
