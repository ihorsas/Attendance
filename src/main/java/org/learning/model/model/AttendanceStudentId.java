package org.learning.model.model;

import com.google.gson.annotations.Expose;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@Embeddable
public class AttendanceStudentId implements Serializable {

  @Column(name = "attendance_id")
  @Expose
  private Integer attendanceId;

  @Column(name = "student_id")
  @Expose
  private Integer studentId;

  public AttendanceStudentId(Integer attendanceId, Integer studentId) {
    this.attendanceId = attendanceId;
    this.studentId = studentId;
  }

  public AttendanceStudentId() {

  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttendanceStudentId that = (AttendanceStudentId) o;
    return Objects.equals(attendanceId, that.attendanceId) && Objects.equals(
        studentId, that.studentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attendanceId, studentId);
  }

}