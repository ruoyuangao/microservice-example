package com.example.university.repository;

import com.example.university.entity.Professor;
import com.example.university.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    public Professor findById(int id);
    public void deleteById(int id);

    @Query(value="select distinct s from Student s left join Professor_Student ps on s.id = ps.stu.id where ps.pro.id = :id")
    List<Student> getRelationById(int id);
}
