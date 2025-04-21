package com.example.dss.service.def;

import com.example.dss.dto.generic.def.DefDecisionDTO;
import com.example.dss.mappers.def.DefDecisionMapper;
import com.example.dss.model.def.DefDecisionModel;
import com.example.dss.repository.def.DefDecisionRepository;
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

