package org.learning.model.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "student")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  private String email;
  @Column(name = "joining_date")
  private Date joiningDate;
  private Date birthday;

  @ManyToMany(cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE
  })
  @JoinTable(name = "student_has_subject",
      joinColumns = @JoinColumn(name = "student_id"),
      inverseJoinColumns = @JoinColumn(name = "subject_id")
  )
  @ToString.Exclude
  private Set<Subject> subjects ;

  @OneToMany(
      mappedBy = "student",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  @ToString.Exclude
  private List<AttendanceStudent> attendances;

  public Student() {
     subjects = new HashSet<>();
     attendances = new ArrayList<>();
  }

  public Student(Integer id, String firstName, String lastName, String email, Date joiningDate,
      Date birthday, Set<Subject> subjects,
      List<AttendanceStudent> attendances) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.joiningDate = joiningDate;
    this.birthday = birthday;
    this.subjects = subjects;
    this.attendances = attendances;
  }

  public void addSubject(Subject subject) {
    subjects.add(subject);
    subject.getStudents().add(this);
  }

  public void removeSubject(Subject subject) {
    subjects.remove(subject);
    subject.getStudents().remove(this);
  }

}

