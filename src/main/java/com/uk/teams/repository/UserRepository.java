package com.uk.teams.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uk.teams.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{

}
