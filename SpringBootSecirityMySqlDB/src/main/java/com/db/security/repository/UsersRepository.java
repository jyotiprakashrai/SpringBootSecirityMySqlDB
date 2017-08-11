package com.db.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.security.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByName(String username);//Java 8 feature

}
