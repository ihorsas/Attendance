package org.learning.model.dao.implementation;

import org.learning.model.dao.AbstractDao;
import org.learning.model.model.AttendanceStudent;
import org.learning.model.model.AttendanceStudentId;

public class AttendanceStudentDaoImpl extends AbstractDao<AttendanceStudent, AttendanceStudentId> {

  public AttendanceStudentDaoImpl() {
    setClasses(AttendanceStudent.class);
  }
}
