package com.example.dss.controller.temp;

import com.example.dss.dto.post.temp.UsersCreateDTO;
import com.example.dss.service.temp.UsersService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.dss.dto.generic.temp.UsersDTO;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

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

    @Operation(summary = "Create a new user")
    @ApiResponse(responseCode = "201", description = "User successfully created")
    @ApiResponse(responseCode = "400", description = "Argument Not Valid", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @PostMapping("/user")
    public ResponseEntity<UsersDTO> createUser(@Valid @RequestBody UsersCreateDTO userCreateDTO) {
        UsersDTO createdUser = usersService.createUser(userCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}
