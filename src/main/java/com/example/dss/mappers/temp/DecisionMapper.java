package com.example.dss.mappers.temp;

import com.example.dss.dto.generic.temp.DecisionDTO;
import com.example.dss.dto.post.temp.DecisionCreateDTO;
import com.example.dss.model.temp.DecisionModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DecisionMapper {
    DecisionDTO toDTO(DecisionModel model);
    DecisionModel toModel(DecisionDTO dto);

    DecisionModel toModel(DecisionCreateDTO dto);
    List<DecisionDTO> toDTOList(List<DecisionModel> models);
}
