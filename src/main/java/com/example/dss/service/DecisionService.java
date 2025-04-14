package com.example.dss.service;

import com.example.dss.dto.generic.DecisionDTO;
import com.example.dss.mappers.DecisionMapper;
import com.example.dss.model.DecisionModel;
import com.example.dss.repository.DecisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DecisionService {
    DecisionRepository decisionRepository;
    DecisionMapper decisionMapper;

    private DecisionService(DecisionRepository decisionRepository, DecisionMapper decisionMapper) {
        this.decisionRepository = decisionRepository;
        this.decisionMapper = decisionMapper;
    }

    public DecisionDTO getDecisionById(Long id) {
        DecisionModel decisionModel = decisionRepository.findById(id).get(); //???
        return decisionMapper.toDTO(decisionModel);
    }

    public List<DecisionDTO> getDecisionByUserId(Long userId) {
        List<Long> decisionIds = decisionRepository.findDecisionIdsByUserId(userId);
        List<DecisionModel> decisonModelList = new ArrayList<>();
        for (Long decisionId : decisionIds) {
            DecisionModel decisionModel = decisionRepository.findById(decisionId).get();
            if (decisionModel != null) {
                decisonModelList.add(decisionModel);
            }
        }
        return decisionMapper.toDTOList(decisonModelList);
    }
}
