package org.learning.model.service;

import org.learning.model.dao.implementation.AttendanceDaoImpl;
import org.learning.model.dao.interfaces.InterfaceDao;
import org.learning.model.model.Attendance;

import java.util.List;

public class AttendanceService {
  private final InterfaceDao<Attendance, Integer> dao;

  public AttendanceService() {
    dao = new AttendanceDaoImpl();
  }

  public void createAttendance(Attendance attendance) {
    dao.persist(attendance);
  }

  public void updateAttendance(Attendance attendance) {
    dao.persist(attendance);
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
