package com.example.baitapquanlynhansu.services.impls;

import com.example.baitapquanlynhansu.dtos.requests.position.PositionCreationRequest;
import com.example.baitapquanlynhansu.dtos.requests.position.PositionUpdationRequest;
import com.example.baitapquanlynhansu.dtos.responses.PositionResponse;
import com.example.baitapquanlynhansu.entities.Position;
import com.example.baitapquanlynhansu.exceptions.CustomException;
import com.example.baitapquanlynhansu.repositories.PositionRepository;
import com.example.baitapquanlynhansu.services.PositionService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
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
        if (positionRepository.existsByTitle(request.getTitle()))
            throw new CustomException("Title existed", HttpStatus.CONFLICT);
        Position position = modelMapper.map(request, Position.class);
        positionRepository.save(position);
        return modelMapper.map(position, PositionResponse.class);
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
        Position oldPosition = positionRepository.findById(request.getId())
                .orElseThrow(() -> new CustomException("Position not found", HttpStatus.BAD_REQUEST));
        if (positionRepository.existsByTitle(request.getTitle()) && !oldPosition.getTitle().equals(request.getTitle()))
            throw new CustomException("Title existed", HttpStatus.CONFLICT);

        oldPosition.setTitle(request.getTitle());
        oldPosition.setDescription(request.getDescription());
        positionRepository.save(oldPosition);
        return modelMapper.map(oldPosition, PositionResponse.class);
    }

    @Override
    public boolean deletePosition(Long id) {
        if (positionRepository.existsById(id)){
            positionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
