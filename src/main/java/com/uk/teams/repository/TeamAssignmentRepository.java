package com.uk.teams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uk.teams.model.TeamAssignment;
import com.uk.teams.model.TeamAssignment.TeamAssignmentId;

@Repository
public interface TeamAssignmentRepository extends JpaRepository<TeamAssignment, TeamAssignmentId>{

}
