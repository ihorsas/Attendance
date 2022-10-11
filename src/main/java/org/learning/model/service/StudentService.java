package org.learning.model.service;

import org.learning.model.dao.implementation.StudentDaoImpl;
import org.learning.model.dao.interfaces.InterfaceDao;
import org.learning.model.model.Student;

import java.util.List;

public class StudentService {
  private final InterfaceDao<Student, Integer> dao;

  public StudentService() {
    dao = new StudentDaoImpl();
  }

  public void createStudent(Student student) {
    dao.persist(student);
  }

  public void updateStudent(Student student) {
    dao.persist(student);
  }

  public Student findStudentById(Integer id) {
    return dao.findById(id);
  }

  public void removeStudent(Student student) {
    dao.remove(student);
  }

  public List<Student> findAllStudents() {
    return dao.findAll();
  }
}
