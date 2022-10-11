package org.learning.view_controller;

import org.learning.model.model.Attendance;
import org.learning.model.model.AttendanceStudent;
import org.learning.model.model.AttendanceStudentId;
import org.learning.model.model.Student;
import org.learning.model.model.Subject;
import org.learning.model.model.Teacher;
import org.learning.model.service.AttendanceService;
import org.learning.model.service.AttendanceStudentService;
import org.learning.model.service.StudentService;
import org.learning.model.service.SubjectService;
import org.learning.model.service.TeacherService;

import java.util.Calendar;
import java.util.NoSuchElementException;

public class Main {

  public static void main(String[] args) {

    Subject subject = new Subject();
    subject.setName("Hybrid Systems");
    subject.setCredit(4);

    Calendar birthday = Calendar.getInstance();
    birthday.set(Calendar.YEAR, 1988);
    birthday.set(Calendar.MONTH, Calendar.JANUARY);
    birthday.set(Calendar.DAY_OF_MONTH, 1);

    Calendar joiningDate = Calendar.getInstance();
    joiningDate.set(Calendar.YEAR, 2022);
    joiningDate.set(Calendar.MONTH, Calendar.SEPTEMBER);
    joiningDate.set(Calendar.DAY_OF_MONTH, 1);

    Student student = new Student();
    student.setFirstName("Ihor");
    student.setLastName("Sas");
    student.setEmail("isas@uni.com");
    student.setJoiningDate(joiningDate.getTime());
    student.setBirthday(birthday.getTime());

    Teacher teacher = new Teacher();
    teacher.setFirstName("Umberto");
    teacher.setLastName("Triacca");
    teacher.setEmail("utriacca@uni.com");
    teacher.setBirthday(birthday.getTime());

    SubjectService subjectService = new SubjectService();
    StudentService studentService = new StudentService();
    TeacherService teacherService = new TeacherService();
    AttendanceService attendanceService = new AttendanceService();
    AttendanceStudentService attendanceStudentService = new AttendanceStudentService();
    try {
      subjectService.createSubject(subject);
      student.addSubject(subject);
      teacher.addSubject(subject);
      studentService.createStudent(student);
      teacherService.createTeacher(teacher);
      subject = getSubject(subjectService, subject);
      student = getStudent(studentService, student);
      teacher = getTeacher(teacherService, teacher);

      Attendance attendance = new Attendance();
      attendance.setDate(Calendar.getInstance().getTime());
      attendance.setTeacher(teacher);
      attendance.setSubject(subject);

      attendanceService.createAttendance(attendance);
      attendance = getAttendance(attendanceService, attendance);

      AttendanceStudent attendanceStudent = AttendanceStudent.builder()
          .id(AttendanceStudentId.builder()
              .attendanceId(attendance.getId())
              .studentId(student.getId())
              .build())
          .student(student)
          .attendance(attendance)
          .state("Absent")
          .comment("Missiles strike")
          .date(Calendar.getInstance().getTime())
          .build();
      attendanceStudentService.createAttendanceStudent(attendanceStudent);

      System.out.println("All attendances students: ");
      for (AttendanceStudent c : attendanceStudentService.findAllAttendanceStudents()) {
        System.out.println(c);
      }
    } finally {
      for (AttendanceStudent c : attendanceStudentService.findAllAttendanceStudents()) {
        attendanceStudentService.removeAttendanceStudent(c);
      }
      for (Attendance atd : attendanceService.findAllAttendances()) {
        attendanceService.removeAttendance(atd);
      }
      for (Teacher tch : teacherService.findAllTeachers()) {
        teacherService.removeTeacher(tch);
      }
      for (Subject sbj : subjectService.findAllSubjects()) {
        subjectService.removeSubject(sbj);
      }
      for (Student std : studentService.findAllStudents()) {
        studentService.removeStudent(std);
      }
    }
  }

  private static Attendance getAttendance(AttendanceService attendanceService,
      Attendance attendance) {
    for (Attendance atd : attendanceService.findAllAttendances()) {
      if (atd.getSubject().getName().equals(attendance.getSubject().getName())
      && atd.getTeacher().getLastName().equals(attendance.getTeacher().getLastName())) {
        return atd;
      }
    }
    throw new NoSuchElementException("Attendance " + attendance.getSubject().getName()
        + " is not found");
  }

  private static Teacher getTeacher(TeacherService teacherService, Teacher teacher) {
    for (Teacher tch : teacherService.findAllTeachers()) {
      if (tch.getFirstName().equals(teacher.getFirstName())
          && tch.getLastName().equals(teacher.getLastName())) {
        return tch;
      }
    }
    throw new NoSuchElementException("Teacher " + teacher.getFirstName() + " "
        + teacher.getLastName() + " is not found");
  }

  private static Student getStudent(StudentService studentService, Student student) {
    for (Student std : studentService.findAllStudents()) {
      if (std.getFirstName().equals(student.getFirstName())
          && std.getLastName().equals(student.getLastName())) {
        return std;
      }
    }
    throw new NoSuchElementException("Student " + student.getFirstName() + " "
        + student.getLastName() + " is not found");
  }

  private static Subject getSubject(SubjectService subjectService, Subject subject) {
    for (Subject sbj : subjectService.findAllSubjects()) {
      if (sbj.getName().equals(subject.getName())) {
        return sbj;
      }
    }
    throw new NoSuchElementException("Subject " + subject.getName() + " is not found");
  }
}
