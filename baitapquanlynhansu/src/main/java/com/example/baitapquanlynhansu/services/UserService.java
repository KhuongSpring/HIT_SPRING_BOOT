package com.example.baitapquanlynhansu.services;

import com.example.baitapquanlynhansu.dtos.requests.user.UserCreationRequest;
import com.example.baitapquanlynhansu.dtos.requests.user.UserUpdationRequest;
import com.example.baitapquanlynhansu.dtos.responses.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserCreationRequest request);

    List<UserResponse> listUser();

    UserResponse updateUser(UserUpdationRequest request);

    boolean deleteUser(Long id);
}
