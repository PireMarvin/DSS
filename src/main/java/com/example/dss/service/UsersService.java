package com.example.dss.service;

import com.example.dss.dto.generic.UsersDTO;
import com.example.dss.mappers.UsersMapper;
import com.example.dss.model.UsersModel;
import com.example.dss.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    UsersRepository usersRepository;
    UsersMapper usersMapper;

    private UsersService(UsersRepository usersRepository, UsersMapper usersMapper) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
    }

    public UsersDTO getUserById(Long userId) {
        UsersModel usersModel = usersRepository.findById(userId).get();
        return usersMapper.toDTO(usersModel);
    }
}
