package org.learning.model.dao.implementation;

import org.learning.model.dao.interfaces.AbstractDao;
import org.learning.model.model.Attendance;

public class AttendanceDaoImpl extends AbstractDao<Attendance, Integer> {

  public AttendanceDaoImpl(){
    setClasses(Attendance.class);
  }
}
