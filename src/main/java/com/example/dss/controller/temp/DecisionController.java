package com.example.dss.controller.temp;

import com.example.dss.dto.generic.temp.UsersDTO;
import com.example.dss.dto.post.temp.DecisionCreateDTO;
import com.example.dss.dto.post.temp.UsersCreateDTO;
import com.example.dss.service.temp.DecisionService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.example.dss.dto.generic.temp.DecisionDTO;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping(value = "/decision", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Create a new decision",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE)
            ))
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Decision successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    public ResponseEntity<DecisionDTO> createDecision(
            @Parameter(description = "Image file") @RequestPart("image") MultipartFile imageFile,
            @Parameter(description = "Description text") @RequestParam("description") String description,
            @Parameter(description = "User ID") @RequestParam("userId") Long userId
    ) {
        try {
            // Construction du DTO
            DecisionCreateDTO decisionCreateDTO = new DecisionCreateDTO();
            decisionCreateDTO.setImage(imageFile.getBytes());
            decisionCreateDTO.setDescription(description);
            decisionCreateDTO.setUserId(userId);

            // Appel du service
            DecisionDTO createdDecision = decisionService.createDecision(decisionCreateDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdDecision);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


}
