package com.jpa.ManyToOne.subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.ManyToOne.student.Student;
import com.jpa.ManyToOne.student.StudentRepository;
import com.jpa.ManyToOne.teacher.Teacher;
import com.jpa.ManyToOne.teacher.TeacherRepository;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
  
  @Autowired
  private SubjectRepository subjectRepository;
  
  @Autowired
  private StudentRepository studentRepository;
  
  @Autowired
  private TeacherRepository teacherRepository;
  
  @GetMapping
  public List<Subject> getSubjects() {
    return subjectRepository.findAll();
  }

  @GetMapping("/{subjectId}")
  public Subject getSubject(@PathVariable Long subjectId) {
    return subjectRepository.findById(subjectId).get();
  }

  @PostMapping
  public Subject createSubject(@RequestBody Subject subject) {
    return subjectRepository.save(subject);
  }

  @PutMapping("/{subjectId}/students/{studentId}")
  public Subject enrollStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId) {
    List<Student> students = null;

    Subject subject = subjectRepository.findById(subjectId).get();
    Student student = studentRepository.findById(studentId).get();

    students = subject.getEnrolledStudents();
    students.add(student);

    subject.setEnrolledStudents(students);
    return subjectRepository.save(subject);
  }
 
  @PutMapping("/{subjectId}/teacher/{teacherId}")
  public Subject assignTeacherToSubject(@PathVariable Long subjectId, @PathVariable Long teacherId) {
    Subject subject = subjectRepository.findById(subjectId).get();
    Teacher teacher = teacherRepository.findById(teacherId).get();

    subject.setTeacher(teacher);
    return subjectRepository.save(subject);
  }

}
