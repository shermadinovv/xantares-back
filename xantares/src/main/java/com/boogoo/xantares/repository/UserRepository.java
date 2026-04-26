package com.boogoo.xantares.repository;

import com.boogoo.xantares.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { }
