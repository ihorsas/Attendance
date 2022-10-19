package org.learning.model.service;

import org.learning.model.dao.implementation.AttendanceDaoImpl;
import org.learning.model.dao.AbstractDao;
import org.learning.model.model.Attendance;

import java.util.List;

public class AttendanceService {
  private final AbstractDao<Attendance, Integer> dao;

  public AttendanceService() {
    dao = new AttendanceDaoImpl();
  }

  public Attendance createAttendance(Attendance attendance) {
    return dao.merge(attendance);
  }

  public Attendance updateAttendance(Attendance attendance) {
    return dao.merge(attendance);
  }

  public Attendance findAttendanceById(Integer id) {
    return dao.findById(id);
  }

  public void removeAttendance(Attendance attendance) {
    dao.remove(attendance);
  }

  public List<Attendance> findAllAttendances() {
    return dao.findAll();
  }
}
