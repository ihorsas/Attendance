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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "teacher")
public class Teacher {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  private String email;
  private Date birthday;

  @ManyToMany(cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE
  })
  @JoinTable(name = "teacher_has_subject",
      joinColumns = @JoinColumn(name = "teacher_id"),
      inverseJoinColumns = @JoinColumn(name = "subject_id")
  )
  @ToString.Exclude
  private Set<Subject> subjects;


  @OneToOne(mappedBy = "teacher")
  @ToString.Exclude
  private Attendance attendance;

  public Teacher() {
    subjects = new HashSet<>();
  }

  public Teacher(Integer id, String firstName, String lastName, String email, Date birthday,
      Set<Subject> subjects, Attendance attendance) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.birthday = birthday;
    this.subjects = subjects;
    this.attendance = attendance;
  }

  public void addSubject(Subject subject) {
    subjects.add(subject);
    subject.getTeachers().add(this);
  }

  public void removeSubject(Subject subject) {
    subjects.remove(subject);
    subject.getTeachers().remove(this);
  }
}
