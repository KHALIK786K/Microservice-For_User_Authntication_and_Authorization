package com.xadmin.springsecurityDataBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xadmin.springsecurityDataBase.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

}
