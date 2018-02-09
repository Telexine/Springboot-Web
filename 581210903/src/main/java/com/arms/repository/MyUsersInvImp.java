package com.arms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arms.domain.entity.UsersInv;

public interface MyUsersInvImp extends JpaRepository<UsersInv, Integer> {

}
