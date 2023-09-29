package com.mycompany.jpa.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.jpa.entity.Department;
import com.mycompany.jpa.entity.EmployeeEntity;
import com.mycompany.jpa.entity.Movie;

@Repository
public interface MovieCrud extends JpaRepository<Movie, Long>{

}

