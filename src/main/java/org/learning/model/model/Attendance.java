package org.learning.model.model;

import com.google.gson.annotations.Expose;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "attendance")
public class Attendance {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Expose
  private Integer id;
  @Expose
  private Date date;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "subject_id", referencedColumnName = "id")
  @Expose
  private Subject subject;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "teacher_id", referencedColumnName = "id")
  @Expose
  private Teacher teacher;

  @OneToMany(
      mappedBy = "attendance",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  @ToString.Exclude
  private List<AttendanceStudent> students;

  public Attendance() {
    students = new ArrayList<>();
  }

  public Attendance(Integer id, Date date, Subject subject, Teacher teacher,
      List<AttendanceStudent> students) {
    this.id = id;
    this.date = date;
    this.subject = subject;
    this.teacher = teacher;
    this.students = students;
  }

}
