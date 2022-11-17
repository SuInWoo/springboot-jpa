package com.example.springbootjpa.service;

import com.example.springbootjpa.domain.dto.UserRequest;
import com.example.springbootjpa.domain.dto.UserResponse;
import com.example.springbootjpa.domain.entity.User;
import com.example.springbootjpa.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse getUser(Long id) {

        Optional<User> optUser = userRepository.findById(id);
        if (optUser.isEmpty()){
            return new UserResponse(id, "", "해당 id의 유저가 없습니다.");
        } else {
            User user = optUser.get();
            return new UserResponse(user.getId(), user.getUsername(), "");
        }
    }

    public UserResponse add(UserRequest dto){
        User user = dto.toEntity(); // Entity로 변환
        User savedUser = userRepository.save(user);
        return new UserResponse(savedUser.getId(), savedUser.getUsername(), savedUser.getPassword());
    }
}