package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;


@Repository
public interface AdminRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByuserName(String userName);

	boolean existsByuserName(String userName);
	boolean existsByEmail(String email);

	Optional<User> findByEmail(String email);
}
