package com.uk.teams.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uk.teams.dao.RoleDao;
import com.uk.teams.model.Team;
import com.uk.teams.service.RoleService;
import com.uk.teams.service.TeamService;

@RestController
@RequestMapping("/api")
public class TeamController {
	@Autowired
    TeamService teamService;
	
	@Autowired
	RoleService roleService;
	
	@PostMapping("/teams")
	public Team createTeam(@RequestBody Team team) {
	    return teamService.createTeam(team);
	}
	
	@GetMapping("/teams")
	public List<Team> GetTeams() {
	    return teamService.getTeams();
	}

	@PutMapping("/teams/{teamId}")
	public Team getTeams(@PathVariable(value = "teamId") UUID id, @RequestBody Team teamDetails) {
	    return teamService.updateTeam(id, teamDetails);
	}

	@DeleteMapping("/teams/{teamId}")
	public void deleteEmployees(@PathVariable(value = "teamId") UUID id) {
	    teamService.deleteTeam(id);
	}
	
	@PutMapping("/teams/{teamId}/users/{userId}/role")
	public boolean addRoleToTeammember(@PathVariable(value = "teamId") UUID teamId, @PathVariable(value = "userId") UUID userId, @RequestBody (required=false) RoleDao role) {
		return teamService.addRoleToTeamUser(teamId, userId, role);
	}
}

