package com.example.dss.repository.def;

import com.example.dss.model.def.DefDecisionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DefDecisionRepository extends JpaRepository<DefDecisionModel, Long> {

    List<DefDecisionModel> findDefDecisionById(int id);
}
