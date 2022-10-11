package org.learning.model.service;

import org.learning.model.dao.implementation.AttendanceStudentDaoImpl;
import org.learning.model.dao.interfaces.InterfaceDao;
import org.learning.model.model.AttendanceStudent;
import org.learning.model.model.AttendanceStudentId;

import java.util.List;

public class AttendanceStudentService {
  private final InterfaceDao<AttendanceStudent, AttendanceStudentId> dao;

  public AttendanceStudentService() {
    dao = new AttendanceStudentDaoImpl();
  }

  public void createAttendanceStudent(AttendanceStudent attendanceStudent) {
    dao.persist(attendanceStudent);
  }

  public void updateAttendanceStudent(AttendanceStudent attendanceStudent) {
    dao.persist(attendanceStudent);
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
