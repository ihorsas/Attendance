package org.learning.model.dao.implementation;

import org.learning.model.dao.AbstractDao;
import org.learning.model.model.Teacher;

public class TeacherDaoImpl extends AbstractDao<Teacher, Integer> {

  public TeacherDaoImpl() {
    setClasses(Teacher.class);
  }
}
