package com.nearlinx.backendapi.repository;

import com.nearlinx.backendapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
