package com.uk.teams.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uk.teams.model.Team;
import com.uk.teams.model.User;
import com.uk.teams.model.TeamAssignment.TeamAssignmentId;
import com.uk.teams.dao.RoleDao;
import com.uk.teams.model.Role;
import com.uk.teams.model.TeamAssignment;
import com.uk.teams.repository.TeamAssignmentRepository;
import com.uk.teams.repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;



@Service
public class TeamService {
	
	@Autowired
    TeamRepository teamRepository; 
	
	@Autowired
	TeamAssignmentRepository teamAssignmentRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;	
	
	// CREATE 
	public Team createTeam(Team team) {
	    return teamRepository.save(team);
	}
	
	public boolean addRoleToTeamUser(UUID teamId, UUID userId, RoleDao roleData) {
		UUID roleId = UUID.randomUUID();
		Role role = new Role();
		if(role == null || role.getRoleId() == null) {
			// To do get default role value from application properties
			role = roleService.getRoleByName("Developer");
		} else {
			role = roleService.getRoleById(roleData.getRoleId());			
		}
		roleId = role.getRoleId();
		TeamAssignmentId assignmentId = new TeamAssignmentId();
		assignmentId.setTeamId(teamId);
		assignmentId.setUserId(userId);
		assignmentId.setRoleId(roleId);
		TeamAssignment assignment = new TeamAssignment();
		assignment.setId(assignmentId);
		Team team = this.getTeamById(teamId);
		User user = userService.getUserById(userId);		
		assignment.setTeam(team);
		assignment.setUser(user);
		assignment.setRole(role);
		teamAssignmentRepository.save(assignment);
		return true;
	}

	// READ
	public List<Team> getTeams() {
	    return teamRepository.findAll();
	}
	
	// READ One
	public Team getTeamById(UUID teamId){
	    return teamRepository.findById(teamId).orElseThrow(() -> new EntityNotFoundException("Team not found with ID: " + teamId));
	}
	
	// UPDATE
	public Team updateTeam(UUID teamId, Team teamDetails) {
	        Team team = teamRepository.findById(teamId).get();
	        team.setName(teamDetails.getName());
	        team.setTeamLead(teamDetails.getTeamLead());
	        team.setTeamMembers(teamDetails.getTeamMembers());
	        return teamRepository.save(team);                                
	}

	// DELETE
	public void deleteTeam(UUID teamId) {
	    teamRepository.deleteById(teamId);
	}

}
