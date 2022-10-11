package org.learning.model.service;

import org.learning.model.dao.implementation.TeacherDaoImpl;
import org.learning.model.dao.interfaces.InterfaceDao;
import org.learning.model.model.Teacher;

import java.util.List;

public class TeacherService {
  private final InterfaceDao<Teacher, Integer> dao;

  public TeacherService() {
    dao = new TeacherDaoImpl();
  }

  public void createTeacher(Teacher teacher) {
    dao.persist(teacher);
  }

  public void updateTeacher(Teacher teacher) {
    dao.persist(teacher);
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
