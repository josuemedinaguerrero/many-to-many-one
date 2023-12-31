package com.jpa.ManyToOne.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
  
  @Autowired
  private StudentRepository studentRepository;

  @GetMapping
  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  @PostMapping
  public Student createStudent(@RequestBody Student student) {
    return studentRepository.save(student);
  }

}
