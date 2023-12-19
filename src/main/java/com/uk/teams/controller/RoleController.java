package com.uk.teams.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.uk.teams.model.Role;
import com.uk.teams.service.RoleService;

@RestController
@RequestMapping("/api")
public class RoleController {
	@Autowired
    RoleService roleService;
	
	@PostMapping("/roles")
	public Role createRole(@RequestBody Role role) {
	    return roleService.createRole(role);
	}
	
	@GetMapping("/roles")
	public List<Role> GetRoles() {
	    return roleService.getRoles();
	}

	@PutMapping("/roles/{roleId}")
	public Role getRoles(@PathVariable(value = "roleId") UUID id, @RequestBody Role roleDetails) {
	    return roleService.updateRole(id, roleDetails);
	}

	@DeleteMapping("/roles/{roleId}")
	public void deleteEmployees(@PathVariable(value = "roleId") UUID id) {
	    roleService.deleteRole(id);
	}
}
