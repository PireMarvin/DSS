package com.example.dss.controller;

import com.example.dss.service.UsersService;
import org.springframework.http.ResponseEntity;
import com.example.dss.dto.generic.UsersDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Users management")
@RequestMapping("/v1")
public class UsersController {
    UsersService usersService;

    private UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @Operation(summary = "Get user by id")
    @ApiResponse(responseCode = "200", description = "User retrieved successfully")
    @ApiResponse(responseCode = "404", description = "Resource not found")
    @GetMapping("/users/{userId}")
    public ResponseEntity<UsersDTO> getAllUsers(@PathVariable Long userId){
        return ResponseEntity.ok(usersService.getUserById(userId));
    }
}
