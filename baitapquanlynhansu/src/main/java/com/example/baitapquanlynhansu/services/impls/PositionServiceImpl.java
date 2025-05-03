package com.example.baitapquanlynhansu.services.impls;

import com.example.baitapquanlynhansu.dtos.requests.position.PositionCreationRequest;
import com.example.baitapquanlynhansu.dtos.requests.position.PositionUpdationRequest;
import com.example.baitapquanlynhansu.dtos.responses.PositionResponse;
import com.example.baitapquanlynhansu.entities.Position;
import com.example.baitapquanlynhansu.repositories.PositionRepository;
import com.example.baitapquanlynhansu.services.PositionService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class PositionServiceImpl implements PositionService {
    ModelMapper modelMapper;
    PositionRepository positionRepository;

    @Override
    public PositionResponse createPosition(PositionCreationRequest request) {
        return null;
    }

    @Override
    public List<PositionResponse> listPosition() {
        List<Position> positions = positionRepository.findAll();
        List<PositionResponse> positionResponses = new ArrayList<>();
        for (Position p : positions) {
            positionResponses.add(modelMapper.map(p, PositionResponse.class));
        }
        return positionResponses;
    }

    @Override
    public PositionResponse updatePosition(PositionUpdationRequest request) {
        return null;
    }

    @Override
    public boolean deletePosition(Long id) {
        return false;
    }
}
