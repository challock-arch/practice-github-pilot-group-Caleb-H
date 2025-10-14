package Repositories;

import Models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository< Teacher, Integer > {
}
