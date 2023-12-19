package com.uk.teams.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Team {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID teamId;

    private String name;
    
    @ManyToOne
    @JoinColumn(name = "teamLeadId")
    private User teamLead;

    @ManyToMany
    @JoinTable(name = "teammembers",
        joinColumns = @JoinColumn(name = "teamId"),
        inverseJoinColumns = @JoinColumn(name = "userId"))
    private List<User> teamMembers = new ArrayList<User>();
    
    @OneToMany(mappedBy = "team", fetch=FetchType.LAZY)    
    Set<TeamAssignment> assignments = new HashSet<>();

	public Set<TeamAssignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(Set<TeamAssignment> assignments) {
		this.assignments = assignments;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getTeamId() {
		return teamId;
	}

	public void setTeamId(UUID teamId) {
		this.teamId = teamId;
	}

	public User getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(User teamLead) {
		this.teamLead = teamLead;
	}

	public List<User> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List<User> teamMembers) {
		this.teamMembers = teamMembers;
	}  	
}
