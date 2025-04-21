package com.example.dss.service.temp;

import com.example.dss.dto.generic.temp.DecisionDTO;
import com.example.dss.mappers.temp.DecisionMapper;
import com.example.dss.model.temp.DecisionModel;
import com.example.dss.repository.temp.DecisionRepository;
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

//    public List<DecisionDTO> getDecisionByUserId(Long userId) {
//        List<Long> decisionIds = decisionRepository.findDecisionIdsByUserId(userId);
//        List<DecisionModel> decisonModelList = new ArrayList<>();
//        for (Long decisionId : decisionIds) {
//            DecisionModel decisionModel = decisionRepository.findById(decisionId).get();
//            if (decisionModel != null) {
//                decisonModelList.add(decisionModel);
//            }
//        }
//        return decisionMapper.toDTOList(decisonModelList);
//    }
}
