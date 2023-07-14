package com.jpa.ManyToOne.subject;

import java.util.List;

import com.jpa.ManyToOne.student.Student;
import com.jpa.ManyToOne.teacher.Teacher;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String name;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "student_enrolled",
      joinColumns =  @JoinColumn(name = "subject_id", referencedColumnName = "id"),
      inverseJoinColumns =  @JoinColumn(name = "student_id", referencedColumnName = "id")
  )
  private List<Student> enrolledStudents;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "teacher_id", referencedColumnName = "id")
  private Teacher teacher;

}
