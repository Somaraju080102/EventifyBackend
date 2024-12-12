package com.recipe.security.eventify.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.security.eventify.entity.UserPublicInfo;

@Repository
public interface UserSignupRepo extends JpaRepository<UserPublicInfo, Integer>{
	

}
