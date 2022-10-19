package org.learning.model.service;

import org.learning.model.dao.implementation.StudentDaoImpl;
import org.learning.model.dao.AbstractDao;
import org.learning.model.model.Student;

import java.util.List;

public class StudentService {
  private final AbstractDao<Student, Integer> dao;

  public StudentService() {
    dao = new StudentDaoImpl();
  }

  public Student createStudent(Student student) {
    return dao.merge(student);
  }

  public Student updateStudent(Student student) {
    return dao.merge(student);
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
