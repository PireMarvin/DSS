package com.example.dss.mappers;

import com.example.dss.dto.generic.UsersDTO;
import com.example.dss.dto.post.UsersCreateDTO;
import com.example.dss.model.UsersModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    UsersDTO toDTO(UsersModel dto);
    UsersModel toModel(UsersDTO dto);

    UsersModel toModel(UsersCreateDTO dto);
    List<UsersDTO> toDTOList(List<UsersModel> models);
}
