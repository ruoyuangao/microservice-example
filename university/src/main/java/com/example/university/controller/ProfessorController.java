package com.example.university.controller;

import com.example.university.entity.Professor;
import com.example.university.entity.Student;
import com.example.university.service.ProfessorService;
import com.example.university.service.impl.ProfessorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    private final ProfessorService service;

    @Autowired
    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createPro(@RequestBody Professor professor) {
        this.service.createPro(professor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProById(@PathVariable int id) {
        this.service.deleteProById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProById(@PathVariable int id, @RequestBody Professor professor) {
        this.service.updateProById(id, professor);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getAllPro() {
        return new ResponseEntity<List<Professor>>(this.service.getAllPro(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProById(@PathVariable int id) {
        return new ResponseEntity<Professor>(this.service.getProById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<Student>> getRelationById(@PathVariable int id) {
        return new ResponseEntity<>(this.service.getRelationById(id), HttpStatus.OK);
    }
}
