package com.example.baitapquanlynhansu.services.impls;

import com.example.baitapquanlynhansu.dtos.requests.user.UserCreationRequest;
import com.example.baitapquanlynhansu.dtos.requests.user.UserUpdationRequest;
import com.example.baitapquanlynhansu.dtos.responses.UserResponse;
import com.example.baitapquanlynhansu.entities.User;
import com.example.baitapquanlynhansu.exceptions.CustomException;
import com.example.baitapquanlynhansu.repositories.UserRepository;
import com.example.baitapquanlynhansu.services.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    ModelMapper modelMapper;
    UserRepository userRepository;

    @Override
    public UserResponse createUser(UserCreationRequest request) {
        if (userRepository.existsByUsername(request.getUsername()))
            throw new CustomException("Username existed!", HttpStatus.CONFLICT);
        if (userRepository.existsByEmail(request.getEmail()))
            throw new CustomException("Email existed!", HttpStatus.CONFLICT);

        User user = modelMapper.map(request, User.class);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setCreateAt(LocalDateTime.now());

        userRepository.save(user);
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public List<UserResponse> listUser() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();
        for (User u : users) {
            userResponses.add(modelMapper.map(u, UserResponse.class));
        }
        return userResponses;
    }

    @Override
    public UserResponse updateUser(UserUpdationRequest request) {
        User oldUser = userRepository.findById(request.getId())
                .orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));
        if (userRepository.existsByUsername(request.getUsername()) && !oldUser.getUsername().equals(request.getUsername()))
            throw new CustomException("Username existed!", HttpStatus.CONFLICT);
        if (userRepository.existsByEmail(request.getEmail()) && !oldUser.getEmail().equals(request.getEmail()))
            throw new CustomException("Email existed!", HttpStatus.CONFLICT);
        oldUser.setUsername(request.getUsername());
        oldUser.setPassword(request.getPassword());
        oldUser.setEmail(request.getEmail());
        userRepository.save(oldUser);
        return modelMapper.map(oldUser, UserResponse.class);
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
