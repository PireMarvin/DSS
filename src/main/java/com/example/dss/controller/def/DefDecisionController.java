package com.example.dss.controller.def;

import com.example.dss.dto.generic.def.DefDecisionDTO;
import com.example.dss.dto.generic.temp.DecisionDTO;
import com.example.dss.dto.post.def.DefDecisionCreateDTO;
import com.example.dss.dto.post.temp.DecisionCreateDTO;
import com.example.dss.service.def.DefDecisionService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

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

    @Operation(summary = "Take an def decision")
    @ApiResponse(responseCode = "201", description = "decision successfully created")
    @ApiResponse(responseCode = "400", description = "Argument Not Valid", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    @PostMapping("/defdecision")
    public ResponseEntity<DefDecisionDTO> createDecision(@Valid @RequestBody DefDecisionCreateDTO defDecisionCreateDTO) {
        DefDecisionDTO createdDecision = defDecisionService.createDecision(defDecisionCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDecision);
    }
}
