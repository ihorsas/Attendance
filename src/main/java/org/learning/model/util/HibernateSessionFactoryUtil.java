package org.learning.model.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.learning.model.model.Attendance;
import org.learning.model.model.AttendanceStudent;
import org.learning.model.model.AttendanceStudentId;
import org.learning.model.model.Student;
import org.learning.model.model.Subject;
import org.learning.model.model.Teacher;

public class HibernateSessionFactoryUtil {
  private static SessionFactory sessionFactory;

  private HibernateSessionFactoryUtil() {}

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      try {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Teacher.class);
        configuration.addAnnotatedClass(Subject.class);
        configuration.addAnnotatedClass(Attendance.class);
        configuration.addAnnotatedClass(AttendanceStudent.class);
        configuration.addAnnotatedClass(AttendanceStudentId.class);
        configuration.addAnnotatedClass(Attendance.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());

      } catch (Exception e) {
        System.out.println("Exception!" + e);
      }
    }
    return sessionFactory;
  }
}
