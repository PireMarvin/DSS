package com.example.dss.controller;

import com.example.dss.service.DefDecisionService;
import org.springframework.http.ResponseEntity;
import com.example.dss.dto.generic.DefDecisionDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Decisions management")
@RequestMapping("/v1")
public class DefDecisionController {
    DefDecisionService defdecisionService;

    private DefDecisionController(DefDecisionService defDecisionService) {
        this.defdecisionService = defDecisionService;
    }

    @Operation(summary = "Get decision by id")
    @ApiResponse(responseCode = "200", description = "DefDecision retrieved successfully")
    @ApiResponse(responseCode = "404", description = "Resource not found")
    @GetMapping("/defdecision/{defDecisionId}")
    public ResponseEntity<DefDecisionDTO> getAllDecision(@PathVariable Long defDecisionId){
        return ResponseEntity.ok(defDecisionService.getDefDecisionById(defDecisionId));
    }
}
