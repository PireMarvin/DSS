package com.example.dss.controller.temp;

import com.example.dss.dto.generic.temp.UsersDTO;
import com.example.dss.dto.post.temp.DecisionCreateDTO;
import com.example.dss.dto.post.temp.UsersCreateDTO;
import com.example.dss.service.temp.DecisionService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.dss.dto.generic.temp.DecisionDTO;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

@RestController
@Tag(name = "Decisions management")
@RequestMapping("/v1")
public class DecisionController {
    DecisionService decisionService;

    private DecisionController(DecisionService decisionService) {
        this.decisionService = decisionService;
    }

    @Operation(summary = "Get decision by id")
    @ApiResponse(responseCode = "200", description = "Decision retrieved successfully")
    @ApiResponse(responseCode = "404", description = "Resource not found")
    @GetMapping("/decision/{decisionId}")
    public ResponseEntity<DecisionDTO> getAllDecision(@PathVariable Long decisionId){
        return ResponseEntity.ok(decisionService.getDecisionById(decisionId));
    }

    @Operation(summary = "Get all the decision ids for a specific user")
    @ApiResponse(responseCode = "200", description = "Decision retrieved successfully")
    @GetMapping("/decision/user/{userId}")
    public ResponseEntity<List<DecisionDTO>> getAllDecisionByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(decisionService.getDecisionByUserId(userId));
    }

    @Operation(summary = "Create a new decision")
    @ApiResponse(responseCode = "201", description = "decision successfully created")
    @ApiResponse(responseCode = "400", description = "Argument Not Valid", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @PostMapping("/decision")
    public ResponseEntity<DecisionDTO> createDecision(@Valid @RequestBody DecisionCreateDTO decisionCreateDTO) {
        DecisionDTO createdDecision = decisionService.createDecision(decisionCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDecision);
    }
}
