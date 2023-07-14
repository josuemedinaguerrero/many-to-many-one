package com.jpa.ManyToOne.student;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpa.ManyToOne.subject.Subject;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @JsonIgnore
  @ManyToMany(mappedBy = "enrolledStudents", fetch = FetchType.LAZY)
  private List<Subject> subjects;

}
