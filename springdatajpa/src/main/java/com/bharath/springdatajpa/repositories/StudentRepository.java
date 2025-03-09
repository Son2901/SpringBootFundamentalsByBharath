package com.bharath.springdatajpa.repositories;

import com.bharath.springdatajpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
