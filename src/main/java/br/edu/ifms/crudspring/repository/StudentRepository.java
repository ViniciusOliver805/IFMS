package br.edu.ifms.crudspring.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.crudspring.model.Student;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    
}
