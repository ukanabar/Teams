package com.uk.teams.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uk.teams.model.Role;
import com.uk.teams.repository.RoleRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RoleService {
	
	@Autowired
    RoleRepository roleRepository; 
	
	// CREATE 
	public Role createRole(Role role) {
	    return roleRepository.save(role);
	}

	// READ
	public List<Role> getRoles() {
	    return roleRepository.findAll();
	}
	
	// READ One
	public Role getRoleById(UUID roleId) {
	    return roleRepository.findById(roleId).orElseThrow(() -> new EntityNotFoundException("Role not found with ID: " + roleId));
	}
	
	public Role getRoleByName(String name) {
	    return roleRepository.findByName(name);
	}
	
	// UPDATE
	public Role updateRole(UUID roleId, Role roleDetails) {
	        Role role = roleRepository.findById(roleId).get();
	        role.setName(roleDetails.getName());       
	        return roleRepository.save(role);                                
	}

	// DELETE
	public void deleteRole(UUID roleId) {
	    roleRepository.deleteById(roleId);
	}

}
