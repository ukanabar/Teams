package com.uk.teams.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class TeamAssignment {
	@EmbeddedId
    private TeamAssignmentId id;
 
    @ManyToOne
    @MapsId("teamId")
    private Team team;
 
    @ManyToOne
    @MapsId("roleId")
    private Role role;
 
    @ManyToOne
    @MapsId("userId")
    private User user;
    
    public TeamAssignmentId getId() {
		return id;
	}



	public void setId(TeamAssignmentId id) {
		this.id = id;
	}



	public Team getTeam() {
		return team;
	}



	public void setTeam(Team team) {
		this.team = team;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Embeddable
    public static class TeamAssignmentId implements Serializable {
        
    	/**
		 * 
		 */
		private static final long serialVersionUID = -7314144607876960180L;
		private UUID teamId;
        private UUID roleId;
        private UUID userId;
        
        public UUID getTeamId() {
			return teamId;
		}
		public void setTeamId(UUID teamId) {
			this.teamId = teamId;
		}
		public UUID getRoleId() {
			return roleId;
		}
		public void setRoleId(UUID roleId) {
			this.roleId = roleId;
		}
		public UUID getUserId() {
			return userId;
		}
		public void setUserId(UUID userId) {
			this.userId = userId;
		}      
    }
}
