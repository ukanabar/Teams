package com.uk.teams.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uk.teams.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID>{
	Role findByName(String name);
}
