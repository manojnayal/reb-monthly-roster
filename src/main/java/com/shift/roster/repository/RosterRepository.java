package com.shift.roster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shift.roster.entity.EmployeeEntity;

public interface RosterRepository extends JpaRepository<EmployeeEntity, Integer> {

	
}
