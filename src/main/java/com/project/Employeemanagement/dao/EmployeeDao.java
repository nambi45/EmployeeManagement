package com.project.Employeemanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Employeemanagement.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer> {

}
