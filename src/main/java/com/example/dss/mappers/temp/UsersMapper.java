package com.example.dss.mappers.temp;

import com.example.dss.dto.generic.temp.UsersDTO;
import com.example.dss.dto.post.temp.UsersCreateDTO;
import com.example.dss.model.temp.UsersModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    UsersDTO toDTO(UsersModel usersModel);
    UsersModel toModel(UsersDTO dto);

    UsersModel toModel(UsersCreateDTO dto);
    List<UsersDTO> toDTOList(List<UsersModel> models);
}
