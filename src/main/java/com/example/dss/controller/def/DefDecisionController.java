package com.example.dss.controller.def;

import com.example.dss.dto.generic.def.DefDecisionDTO;
import com.example.dss.service.def.DefDecisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@Tag(name = "Decisions management")
@RequestMapping("/v1")
public class DefDecisionController {
    DefDecisionService defDecisionService;

    private DefDecisionController(DefDecisionService defDecisionService) {
        this.defDecisionService = defDecisionService;
    }

    @Operation(summary = "Get decision by id")
    @ApiResponse(responseCode = "200", description = "DefDecision retrieved successfully")
    @ApiResponse(responseCode = "404", description = "Resource not found")
    @GetMapping("/defdecision/{defDecisionId}")
    public ResponseEntity<DefDecisionDTO> getAllDecision(@PathVariable Long defDecisionId){
        return ResponseEntity.ok(defDecisionService.getDefDecisionById(defDecisionId));
    }
}
