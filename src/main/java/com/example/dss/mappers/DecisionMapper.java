package com.example.dss.mappers;

import com.example.dss.dto.generic.DecisionDTO;
import com.example.dss.dto.post.DecisionCreateDTO;
import com.example.dss.model.DecisionModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DecisionMapper {
    DecisionDTO toDTO(DecisionModel model);
    DecisionModel toModel(DecisionDTO dto);

    DecisionModel toModel(DecisionCreateDTO dto);
    List<DecisionDTO> toDTOList(List<DecisionModel> models);
}
