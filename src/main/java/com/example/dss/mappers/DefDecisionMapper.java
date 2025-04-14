package com.example.dss.mappers;

import com.example.dss.dto.generic.DefDecisionDTO;
import com.example.dss.dto.post.DecisionCreateDTO;
import com.example.dss.dto.post.DefDecisionCreateDTO;
import com.example.dss.model.DefDecisionModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DefDecisionMapper {
    DefDecisionDTO toDTO(DefDecisionModel dto);
    DefDecisionModel toModel(DecisionCreateDTO dto);

    DefDecisionModel toModel(DefDecisionCreateDTO dto);
    List<DefDecisionDTO> toDTOList(List<DefDecisionModel> models);
}
