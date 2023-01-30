package com.example.university.controller;

import com.example.university.entity.Professor;
import com.example.university.entity.Professor_Student;
import com.example.university.entity.Student;
import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStu() {
        return new ResponseEntity<>(this.service.getAllStu(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStuById(@PathVariable int id) {
        return new ResponseEntity<>(this.service.getStuById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createStu(@RequestBody Student student) {
        this.service.createStu(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStuById(@PathVariable int id) {
        this.service.deleteStuByID(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStuById(@PathVariable int id, @RequestBody Student student) {
        this.service.updateStuById(id, student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/professors")
    public ResponseEntity<List<Professor>> getRelationById(@PathVariable int id) {
        return new ResponseEntity<List<Professor>>(this.service.getRelationById(id),HttpStatus.OK);
    }



}
