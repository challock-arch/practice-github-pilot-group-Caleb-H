package com.example.practice_github_pilot.Repositories;

import com.example.practice_github_pilot.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository <Student, Integer > {
}
