package com.example.university.service.impl;

import com.example.university.entity.Professor;
import com.example.university.entity.Student;
import com.example.university.exception.ResourceNotFoundException;
import com.example.university.repository.ProfessorRepository;
import com.example.university.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository repository;

    @Autowired
    public ProfessorServiceImpl (ProfessorRepository repository) {
        this.repository = repository;
    }
    @Override
    @Transactional
    public void createPro(Professor professor) {
        this.repository.save(professor);
    }

    @Override
    @Transactional
    public void deleteProById(int id) {
        this.repository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateProById(int id, Professor professor) {
        professor.setId(id);
        this.repository.save(professor);
    }

    @Override
    public List<Professor> getAllPro() {
        List<Professor> list =  this.repository.findAll();
        if (list == null) {
            throw new ResourceNotFoundException("Professor list not found");
        }
        return list;
    }

    @Override
    public Professor getProById(int id) {
        Professor professor = this.repository.findById(id);
        if (professor == null) {
            throw new ResourceNotFoundException("Professor not found");
        }
        return professor;
    }

    @Override
    public List<Student> getRelationById(int id) {
        List<Student> list = this.repository.getRelationById(id);
        if (list == null) {
            throw new ResourceNotFoundException("Relation not found");
        }
        return list;
    }
}
