package org.learning.model.service;

import org.learning.model.dao.implementation.AttendanceStudentDaoImpl;
import org.learning.model.dao.AbstractDao;
import org.learning.model.model.AttendanceStudent;
import org.learning.model.model.AttendanceStudentId;

import java.util.List;

public class AttendanceStudentService {
  private final AbstractDao<AttendanceStudent, AttendanceStudentId> dao;

  public AttendanceStudentService() {
    dao = new AttendanceStudentDaoImpl();
  }

  public AttendanceStudent createAttendanceStudent(AttendanceStudent attendanceStudent) {
    return dao.merge(attendanceStudent);
  }

  public AttendanceStudent updateAttendanceStudent(AttendanceStudent attendanceStudent) {
    return dao.merge(attendanceStudent);
  }

  public AttendanceStudent findAttendanceStudentById(AttendanceStudentId id) {
    return dao.findById(id);
  }

  public void removeAttendanceStudent(AttendanceStudent attendanceStudent) {
    dao.remove(attendanceStudent);
  }

  public List<AttendanceStudent> findAllAttendanceStudents() {
    return dao.findAll();
  }
}
