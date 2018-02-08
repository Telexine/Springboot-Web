package com.arms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arms.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findOneByEmail(String email);
}
