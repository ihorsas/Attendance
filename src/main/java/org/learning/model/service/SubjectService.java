package org.learning.model.service;

import org.learning.model.dao.implementation.SubjectDaoImpl;
import org.learning.model.dao.AbstractDao;
import org.learning.model.model.Subject;

import java.util.List;

public class SubjectService {
  private final AbstractDao<Subject, Integer> dao;

  public SubjectService() {
    dao = new SubjectDaoImpl();
  }

  public Subject createSubject(Subject subject) {
    return dao.merge(subject);
  }

  public Subject updateSubject(Subject subject) {
    return dao.merge(subject);
  }

  public Subject findSubjectById(Integer id) {
    return dao.findById(id);
  }

  public void removeSubject(Subject subject) {
    dao.remove(subject);
  }

  public List<Subject> findAllSubjects() {
    return dao.findAll();
  }
}
