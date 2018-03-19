package com.czajkowski.HibTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.czajkowski.HibTest.model.User;

@Component
public interface UserRepository extends JpaRepository <User, Long> {

	List<User> findByFirstName(String firstName);
}
