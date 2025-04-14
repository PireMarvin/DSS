package com.example.dss.service;

import com.example.dss.dto.generic.DefDecisionDTO;
import com.example.dss.mappers.DefDecisionMapper;
import com.example.dss.model.DefDecisionModel;
import com.example.dss.repository.DefDecisionRepository;
import org.springframework.stereotype.Service;

@Service
public class DefDecisionService {
    private final DefDecisionRepository defDecisionRepository;
    DefDecisionRepository decisionRepository;
    DefDecisionMapper defDecisionMapper;

    private DefDecisionService(DefDecisionRepository decisionRepository, DefDecisionMapper defDecisionMapper, DefDecisionRepository defDecisionRepository) {
        this.defDecisionRepository = defDecisionRepository;
        this.defDecisionMapper = defDecisionMapper;
    }

    public DefDecisionDTO getDefDecisionById(Long id){
        DefDecisionModel defDecisionModel = defDecisionRepository.findById(id).get();
        return defDecisionMapper.toDTO(defDecisionModel);
    }
}

