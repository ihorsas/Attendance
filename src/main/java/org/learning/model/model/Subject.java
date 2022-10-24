package org.learning.model.model;

import com.google.gson.annotations.Expose;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "subject")
public class Subject {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Expose
  private Integer id;
  @Expose
  private String name;
  @Expose
  private Integer credit;

  @ManyToMany(mappedBy = "subjects")
  @ToString.Exclude
  private List<Student> students;

  @ManyToMany(mappedBy = "subjects")
  @ToString.Exclude
  private List<Teacher> teachers;


  @OneToOne(mappedBy = "subject")
  @ToString.Exclude
  private Attendance attendance;

  public Subject() {
    students = new ArrayList<>();
    teachers = new ArrayList<>();
  }

  public Subject(Integer id, String name, Integer credit,
      List<Student> students, List<Teacher> teachers, Attendance attendance) {
    this.id = id;
    this.name = name;
    this.credit = credit;
    this.students = students;
    this.teachers = teachers;
    this.attendance = attendance;
  }
}
