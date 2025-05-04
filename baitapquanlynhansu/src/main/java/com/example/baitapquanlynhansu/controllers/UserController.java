package com.example.baitapquanlynhansu.controllers;

import com.example.baitapquanlynhansu.dtos.requests.user.UserCreationRequest;
import com.example.baitapquanlynhansu.dtos.requests.user.UserUpdationRequest;
import com.example.baitapquanlynhansu.dtos.responses.ApiResponse;
import com.example.baitapquanlynhansu.dtos.responses.UserResponse;
import com.example.baitapquanlynhansu.exceptions.CustomException;
import com.example.baitapquanlynhansu.services.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class UserController {
    UserService userService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> getListUser() {
        return ResponseEntity.ok(ApiResponse.<List<UserResponse>>builder()
                .result(userService.listUser())
                .status(HttpStatus.OK)
                .message("Get data success")
                .build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@Valid @RequestBody UserCreationRequest request) {
        return ResponseEntity.ok(ApiResponse.<UserResponse>builder()
                .status(HttpStatus.CREATED)
                .result(userService.createUser(request))
                .message("Create success")
                .build());
    }

    @PutMapping
    public ResponseEntity<ApiResponse<UserResponse>> updateUser(@Valid @RequestBody UserUpdationRequest request){
        return ResponseEntity.ok(ApiResponse.<UserResponse>builder()
                        .status(HttpStatus.OK)
                        .message("Update success")
                        .result(userService.updateUser(request))
                .build());
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<?>> deleteUser(@RequestParam(name = "id") Long id) {
        if (userService.deleteUser(id))
            return ResponseEntity.ok(ApiResponse.builder()
                    .status(HttpStatus.OK)
                    .message("Delete success")
                    .build());
        throw new CustomException("User not found", HttpStatus.BAD_REQUEST);
    }
}
