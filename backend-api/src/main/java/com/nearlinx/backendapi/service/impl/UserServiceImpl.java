package com.nearlinx.backendapi.service.impl;

import com.nearlinx.backendapi.model.User;
import com.nearlinx.backendapi.repository.UserRepository;
import com.nearlinx.backendapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public List<User> users() {
        return userRepository.findAll();
    }
}
