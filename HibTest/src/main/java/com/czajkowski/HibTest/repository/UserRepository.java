package com.czajkowski.HibTest.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.czajkowski.HibTest.model.User;

@Component
public interface UserRepository extends JpaRepository <User, Long> {

	List<User> findByFirstName(String firstName);
	@Query("SELECT SUM(age) FROM User  u WHERE u.age > 25")
	Optional<Integer> age();
	@Transactional
	void deleteByUserId(int id);
	User findByUserId(int id);
}
