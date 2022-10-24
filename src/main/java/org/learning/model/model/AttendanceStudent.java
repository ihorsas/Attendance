package org.learning.model.model;

import com.google.gson.annotations.Expose;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "attendance_has_student")
public class AttendanceStudent {

  @EmbeddedId
  @Expose
  private AttendanceStudentId id;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("attendance_id")
  @ToString.Exclude
  @Expose
  private Attendance attendance;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("student_id")
  @ToString.Exclude
  @Expose
  private Student student;

  @Expose
  private Date date;
  @Expose
  private String state;
  @Expose
  private String comment;

  public AttendanceStudent(Attendance attendance,
      Student student, Date date, String state, String comment) {
    this.id = new AttendanceStudentId(attendance.getId(), student.getId());
    this.attendance = attendance;
    this.student = student;
    this.date = date;
    this.state = state;
    this.comment = comment;
  }

  public AttendanceStudent() {

  }

  public AttendanceStudent(AttendanceStudentId id, Attendance attendance,
      Student student, Date date, String state, String comment) {
    this.id = id;
    this.attendance = attendance;
    this.student = student;
    this.date = date;
    this.state = state;
    this.comment = comment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttendanceStudent that = (AttendanceStudent) o;
    return Objects.equals(id, that.id) && Objects.equals(attendance,
        that.attendance) && Objects.equals(student, that.student)
        && Objects.equals(date, that.date) && Objects.equals(state, that.state)
        && Objects.equals(comment, that.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, attendance, student, date, state, comment);
  }

}
