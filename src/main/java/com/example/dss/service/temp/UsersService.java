package com.example.dss.service.temp;

import com.example.dss.dto.generic.temp.UsersDTO;
import com.example.dss.mappers.temp.UsersMapper;
import com.example.dss.model.temp.UsersModel;
import com.example.dss.repository.temp.UsersRepository;
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
