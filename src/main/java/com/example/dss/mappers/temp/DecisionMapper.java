package com.example.dss.mappers.temp;

import com.example.dss.dto.generic.temp.DecisionDTO;
import com.example.dss.dto.post.temp.DecisionCreateDTO;
import com.example.dss.model.temp.DecisionModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface DecisionMapper {
    DecisionDTO toDTO(DecisionModel model);

    @Mapping(target = "id", ignore = true)
    DecisionModel toModel(DecisionDTO dto);

    DecisionModel toModel(DecisionCreateDTO dto);
    List<DecisionDTO> toDTOList(List<DecisionModel> models);
}

