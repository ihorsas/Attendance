package org.learning.model.dao.implementation;

import org.learning.model.dao.AbstractDao;
import org.learning.model.model.Student;

public class StudentDaoImpl extends AbstractDao<Student, Integer> {

  public StudentDaoImpl() {
    setClasses(Student.class);
  }
}
