package com.example.dss.repository;

import com.example.dss.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersModel, Long> {

}
