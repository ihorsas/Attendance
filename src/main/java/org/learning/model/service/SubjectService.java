package org.learning.model.service;

import org.learning.model.dao.implementation.SubjectDaoImpl;
import org.learning.model.dao.interfaces.InterfaceDao;
import org.learning.model.model.Subject;

import java.util.List;

public class SubjectService {
  private final InterfaceDao<Subject, Integer> dao;

  public SubjectService() {
    dao = new SubjectDaoImpl();
  }

  public void createSubject(Subject subject) {
    dao.persist(subject);
  }

  public void updateSubject(Subject subject) {
    dao.persist(subject);
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
