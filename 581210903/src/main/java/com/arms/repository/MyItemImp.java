package com.arms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arms.domain.entity.Item;

public interface MyItemImp extends JpaRepository<Item, Integer> {

}
