package com.example.baitapquanlynhansu.controllers;

import com.example.baitapquanlynhansu.dtos.requests.department.DepartmentCreationRequest;
import com.example.baitapquanlynhansu.dtos.requests.department.DepartmentUpdationRequest;
import com.example.baitapquanlynhansu.dtos.requests.position.PositionCreationRequest;
import com.example.baitapquanlynhansu.dtos.requests.position.PositionUpdationRequest;
import com.example.baitapquanlynhansu.dtos.responses.ApiResponse;
import com.example.baitapquanlynhansu.dtos.responses.DepartmentResponse;
import com.example.baitapquanlynhansu.dtos.responses.PositionResponse;
import com.example.baitapquanlynhansu.exceptions.CustomException;
import com.example.baitapquanlynhansu.services.PositionService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/position")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class PositionController {
    PositionService positionService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<PositionResponse>>> getListPosition() {
        return ResponseEntity.ok(ApiResponse.<List<PositionResponse>>builder()
                .status(HttpStatus.OK)
                .result(positionService.listPosition())
                .build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PositionResponse>> createPosition(@Valid @RequestBody PositionCreationRequest request) {
        return ResponseEntity.ok(ApiResponse.<PositionResponse>builder()
                .status(HttpStatus.CREATED)
                .result(positionService.createPosition(request))
                .message("Create success")
                .build());
    }

    @PutMapping
    public ResponseEntity<ApiResponse<PositionResponse>> updatePosition(@Valid @RequestBody PositionUpdationRequest request){
        return ResponseEntity.ok(ApiResponse.<PositionResponse>builder()
                .status(HttpStatus.OK)
                .message("Update success")
                .result(positionService.updatePosition(request))
                .build());
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<?>> deletePosition(@RequestParam(name = "id") Long id) {
        if (positionService.deletePosition(id))
            return ResponseEntity.ok(ApiResponse.builder()
                    .status(HttpStatus.OK)
                    .message("Delete success")
                    .build());
        throw new CustomException("Position not found", HttpStatus.BAD_REQUEST);
    }
}
