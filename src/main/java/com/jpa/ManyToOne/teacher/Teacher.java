package com.jpa.ManyToOne.teacher;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpa.ManyToOne.subject.Subject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String name;

  @JsonIgnore
  @OneToMany(mappedBy = "teacher")
  private List<Subject> subjects;

}
