package org.learning.model.dao.implementation;

import org.learning.model.dao.interfaces.AbstractDao;
import org.learning.model.model.Subject;

public class SubjectDaoImpl extends AbstractDao<Subject, Integer> {

  public SubjectDaoImpl() {
    setClasses(Subject.class);
  }
}
