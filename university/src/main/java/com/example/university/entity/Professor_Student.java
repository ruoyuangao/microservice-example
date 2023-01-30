package com.example.university.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="professor_student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professor_Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "s_id")
    private Student stu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "p_id")
    private Professor pro;

    @Override
    public String toString() {
        return "Professor_Student{" +
                "id='" + id + '\'' +
                "stu='" + stu.getName() + '\'' +
                "pro='" + pro.getName() + '\'' +
                '}';
    }


}
