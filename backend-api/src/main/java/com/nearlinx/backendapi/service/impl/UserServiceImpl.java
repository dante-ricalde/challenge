package com.nearlinx.backendapi.service.impl;

import com.nearlinx.backendapi.model.User;
import com.nearlinx.backendapi.repository.UserRepository;
import com.nearlinx.backendapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public List<User> findAll() {
        log.debug("Getting users");
        return userRepository.findAll();
    }
}
