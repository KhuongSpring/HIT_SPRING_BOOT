package com.example.baitapquanlynhansu.controllers;

import com.example.baitapquanlynhansu.dtos.responses.ApiResponse;
import com.example.baitapquanlynhansu.dtos.responses.PositionResponse;
import com.example.baitapquanlynhansu.services.PositionService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
