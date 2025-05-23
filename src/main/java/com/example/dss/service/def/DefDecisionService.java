package com.example.dss.service.def;

import com.example.dss.dto.generic.def.DefDecisionDTO;
import com.example.dss.dto.generic.temp.DecisionDTO;
import com.example.dss.dto.post.def.DefDecisionCreateDTO;
import com.example.dss.dto.post.temp.DecisionCreateDTO;
import com.example.dss.mappers.def.DefDecisionMapper;
import com.example.dss.model.def.DefDecisionModel;
import com.example.dss.model.temp.DecisionModel;
import com.example.dss.repository.def.DefDecisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefDecisionService {
    private final DefDecisionRepository defDecisionRepository;
    DefDecisionRepository decisionRepository;
    DefDecisionMapper defDecisionMapper;

    private DefDecisionService(DefDecisionRepository decisionRepository, DefDecisionMapper defDecisionMapper, DefDecisionRepository defDecisionRepository) {
        this.defDecisionRepository = defDecisionRepository;
        this.defDecisionMapper = defDecisionMapper;
    }

    public DefDecisionDTO getDefDecisionById(Long id) {
        List<DefDecisionModel> defDecisionModelList = new ArrayList<>();

        defDecisionRepository.findById(id)
                .map(defDecisionModel -> defDecisionModelList.add(defDecisionModel))
                .orElse(null);  // ou une valeur par défaut, comme une liste vide par exemple

        return defDecisionMapper.toDTOList(defDecisionModelList).isEmpty() ? null : defDecisionMapper.toDTOList(defDecisionModelList).get(0);
    }

    public DefDecisionDTO createDecision(DefDecisionCreateDTO defDecisionCreateDTO) {
        DefDecisionModel defDecisionModel = DefDecisionModel.builder()
                .description(defDecisionCreateDTO.getDescription())
                .build();

        defDecisionModel = defDecisionRepository.save(defDecisionModel);  // Sauvegarde en base
        return defDecisionMapper.toDTO(defDecisionModel);              // Conversion en DTO et retour
    }

}

