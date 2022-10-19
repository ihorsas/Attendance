package org.learning.model.service;

import org.learning.model.dao.implementation.TeacherDaoImpl;
import org.learning.model.dao.AbstractDao;
import org.learning.model.model.Teacher;

import java.util.List;

public class TeacherService {
  private final AbstractDao<Teacher, Integer> dao;

  public TeacherService() {
    dao = new TeacherDaoImpl();
  }

  public Teacher createTeacher(Teacher teacher) {
    return dao.merge(teacher);
  }

  public Teacher updateTeacher(Teacher teacher) {
    return dao.merge(teacher);
  }

  public Teacher findTeacherById(Integer id) {
    return dao.findById(id);
  }

  public void removeTeacher(Teacher teacher) {
    dao.remove(teacher);
  }

  public List<Teacher> findAllTeachers() {
    return dao.findAll();
  }
}
