package com.example.dss.mappers.def;

import com.example.dss.dto.generic.def.DefDecisionDTO;
import com.example.dss.dto.post.temp.DecisionCreateDTO;
import com.example.dss.dto.post.def.DefDecisionCreateDTO;
import com.example.dss.model.def.DefDecisionModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DefDecisionMapper {
    DefDecisionDTO toDTO(DefDecisionModel dto);
    DefDecisionModel toModel(DecisionCreateDTO dto);

    DefDecisionModel toModel(DefDecisionCreateDTO dto);
    List<DefDecisionDTO> toDTOList(List<DefDecisionModel> models);
}
