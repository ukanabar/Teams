package com.uk.teams.service;

import java.util.UUID;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.junit.jupiter.api.*;

import com.uk.teams.dao.RoleDao;
import com.uk.teams.model.Role;
import com.uk.teams.model.Team;
import com.uk.teams.model.User;

import jakarta.persistence.EntityNotFoundException;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class TeamAssignmentTest {
	
	@Autowired
    private TeamService teamService;
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;

    @Test
    void assignRoleToTeamMember() {
    	
    	    Role role = new Role();
    	    role.setName("Developer");
    	    Role createdRole = roleService.createRole(role);
    	    
    	    User user = new User();
    	    user.setFirstName("Jhon");
    	    user.setLastName("simon");
    	    user.setDisplayName("jhonsimon");
    	    user.setAvatarUrl("https://cdn.fakercloud.com/avatars/rude_128.jpg");
    	    user.setLocation("ottawa");
    	    User createdUser = userService.createUser(user);
    	    
    	    User user1 = new User();
    	    user1.setFirstName("Dana");
    	    user1.setLastName("Jason");
    	    user1.setDisplayName("danajason");
    	    user1.setAvatarUrl("https://cdn.fakercloud.com/avatars/smile.jpg");
    	    user1.setLocation("kingston");
    	    User createdUser1 = userService.createUser(user1);
    	    
    	    User user2 = new User();
    	    user2.setFirstName("Rob");
    	    user2.setLastName("Bruce");
    	    user2.setDisplayName("robbruce");
    	    user2.setAvatarUrl("https://cdn.fakercloud.com/avatars/angry.jpg");
    	    user2.setLocation("winnipeg");
    	    User createdUser2 = userService.createUser(user2);
    	    
    	    
    	    Team team = new Team();
    	    team.setName("alpha team");
    	    team.setTeamLead(createdUser);
    	    team.setTeamMembers(Lists.newArrayList(createdUser1, createdUser2));
    	    Team createdTeam = teamService.createTeam(team);
    	    
    	    RoleDao requestBody = new RoleDao();
    	    requestBody.setRoleId(createdRole.getRoleId());
    	    Assertions.assertEquals(teamService.addRoleToTeamUser(createdTeam.getTeamId(), createdUser.getUserId(), requestBody), true);
         }	    
    
    @Test
    void assignDefaultRoleToTeamMember() {
    	
    	    Role role = new Role();
    	    role.setName("Developer");
    	    Role createdRole = roleService.createRole(role);
    	    
    	    User user = new User();
    	    user.setFirstName("Jhon");
    	    user.setLastName("simon");
    	    user.setDisplayName("jhonsimon");
    	    user.setAvatarUrl("https://cdn.fakercloud.com/avatars/rude_128.jpg");
    	    user.setLocation("ottawa");
    	    User createdUser = userService.createUser(user);
    	    
    	    User user1 = new User();
    	    user1.setFirstName("Dana");
    	    user1.setLastName("Jason");
    	    user1.setDisplayName("danajason");
    	    user1.setAvatarUrl("https://cdn.fakercloud.com/avatars/smile.jpg");
    	    user1.setLocation("kingston");
    	    User createdUser1 = userService.createUser(user1);
    	    
    	    User user2 = new User();
    	    user2.setFirstName("Rob");
    	    user2.setLastName("Bruce");
    	    user2.setDisplayName("robbruce");
    	    user2.setAvatarUrl("https://cdn.fakercloud.com/avatars/angry.jpg");
    	    user2.setLocation("winnipeg");
    	    User createdUser2 = userService.createUser(user2);
    	    
    	    
    	    Team team = new Team();
    	    team.setName("alpha team");
    	    team.setTeamLead(createdUser);
    	    team.setTeamMembers(Lists.newArrayList(createdUser1, createdUser2));
    	    Team createdTeam = teamService.createTeam(team);
    	    
    	    RoleDao requestBody = new RoleDao();
    	    requestBody.setRoleId(createdRole.getRoleId());
    	    
    	    Assertions.assertEquals(teamService.addRoleToTeamUser(createdTeam.getTeamId(), createdUser.getUserId(), null), true);
         }
    
    @Test
    void assignUnknownRoleToTeamMember() {
    	
    	    User user = new User();
    	    user.setFirstName("Jhon");
    	    user.setLastName("simon");
    	    user.setDisplayName("jhonsimon");
    	    user.setAvatarUrl("https://cdn.fakercloud.com/avatars/rude_128.jpg");
    	    user.setLocation("ottawa");
    	    User createdUser = userService.createUser(user);
    	    
    	    User user1 = new User();
    	    user1.setFirstName("Dana");
    	    user1.setLastName("Jason");
    	    user1.setDisplayName("danajason");
    	    user1.setAvatarUrl("https://cdn.fakercloud.com/avatars/smile.jpg");
    	    user1.setLocation("kingston");
    	    User createdUser1 = userService.createUser(user1);
    	    
    	    User user2 = new User();
    	    user2.setFirstName("Rob");
    	    user2.setLastName("Bruce");
    	    user2.setDisplayName("robbruce");
    	    user2.setAvatarUrl("https://cdn.fakercloud.com/avatars/angry.jpg");
    	    user2.setLocation("winnipeg");
    	    User createdUser2 = userService.createUser(user2);
    	    
    	    
    	    Team team = new Team();
    	    team.setName("alpha team");
    	    team.setTeamLead(createdUser);
    	    team.setTeamMembers(Lists.newArrayList(createdUser1, createdUser2));
    	    Team createdTeam = teamService.createTeam(team);
    	    
    	    RoleDao requestBody = new RoleDao();
    	    UUID randomId = UUID.randomUUID();
    	    requestBody.setRoleId(randomId);
    	    
    	    EntityNotFoundException thrown = Assertions.assertThrows(EntityNotFoundException.class, () -> teamService.addRoleToTeamUser(createdTeam.getTeamId(), createdUser.getUserId(), requestBody));
    		
    		Assertions.assertEquals("Role not found with ID: " + randomId, thrown.getMessage());
    		
    	   }
    }	


