package com.example.dss.controller.temp;

import com.example.dss.service.temp.UsersService;
import org.springframework.http.ResponseEntity;
import com.example.dss.dto.generic.temp.UsersDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PathVariable;

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
