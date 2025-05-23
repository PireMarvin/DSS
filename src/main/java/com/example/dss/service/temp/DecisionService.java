package com.example.dss.service.temp;

import com.example.dss.dto.generic.temp.DecisionDTO;
import com.example.dss.dto.post.temp.DecisionCreateDTO;
import com.example.dss.mappers.temp.DecisionMapper;
import com.example.dss.model.temp.DecisionModel;
import com.example.dss.repository.temp.DecisionRepository;
import org.antlr.v4.runtime.atn.DecisionInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DecisionService {
    DecisionRepository decisionRepository;
    DecisionMapper decisionMapper;

    private DecisionService(DecisionRepository decisionRepository, DecisionMapper decisionMapper) {
        this.decisionRepository = decisionRepository;
        this.decisionMapper = decisionMapper;
    }

    public DecisionDTO getDecisionById(Long id) {
        return decisionRepository.findById(id)
                .map(decisionMapper::toDTO)
                .orElse(null);  // ou une valeur par défaut
    }



    public List<DecisionDTO> getDecisionByUserId(Long userId) {
        List<Long> decisionIds = decisionRepository.findDecisionIdsByUserId(userId);

        List<DecisionModel> decisionModels = decisionIds.stream()
                .map(decisionRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        return decisionMapper.toDTOList(decisionModels);
    }


    public DecisionDTO createDecision(DecisionCreateDTO decisionCreateDTO) {
        DecisionModel decisionModel = DecisionModel.builder()
                .image(decisionCreateDTO.getImage())
                .description(decisionCreateDTO.getDescription())
                .userId(decisionCreateDTO.getUserId())
                .build();

        decisionModel = decisionRepository.save(decisionModel);  // Sauvegarde en base
        return decisionMapper.toDTO(decisionModel);              // Conversion en DTO et retour
    }

}
