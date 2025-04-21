package com.example.dss.repository.temp;

import com.example.dss.model.temp.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<UsersModel, Long> {

    List<UsersModel> findUserById(int id);
}
