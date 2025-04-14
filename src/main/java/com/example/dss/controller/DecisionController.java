package com.example.dss.controller;

import com.example.dss.service.DecisionService;
import org.springframework.http.ResponseEntity;
import com.example.dss.dto.generic.DecisionDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/decision/{userId}")
    public ResponseEntity<List<DecisionDTO>> getAllDecisionByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(decisionService.getDecisionByUserId(userId));
    }
}
