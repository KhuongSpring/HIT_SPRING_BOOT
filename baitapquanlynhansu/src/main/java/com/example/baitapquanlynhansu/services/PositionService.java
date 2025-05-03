package com.example.baitapquanlynhansu.services;

import com.example.baitapquanlynhansu.dtos.requests.position.PositionCreationRequest;
import com.example.baitapquanlynhansu.dtos.requests.position.PositionUpdationRequest;
import com.example.baitapquanlynhansu.dtos.responses.PositionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PositionService {
    PositionResponse createPosition(PositionCreationRequest request);

    List<PositionResponse> listPosition();

    PositionResponse updatePosition(PositionUpdationRequest request);

    boolean deletePosition(Long id);
}
