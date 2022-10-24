package org.learning.model.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.learning.model.model.Attendance;
import org.learning.model.model.AttendanceStudent;
import org.learning.model.model.AttendanceStudentId;
import org.learning.model.service.AttendanceService;
import org.learning.model.service.AttendanceStudentService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Objects;
import java.util.Scanner;

@WebServlet(name = "AttendanceStudentServlet", value = "/attendance-student")
public class AttendanceStudentServlet extends AbstractServlet {

  private final AttendanceStudentService service;

  public AttendanceStudentServlet() {
    service = new AttendanceStudentService();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String attendanceId = request.getParameter("attendanceId");
    String studentId = request.getParameter("studentId");

    PrintWriter out = response.getWriter();
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    if (Objects.nonNull(attendanceId) && Objects.nonNull(studentId)) {
      AttendanceStudentId id = new AttendanceStudentId(Integer.valueOf(attendanceId),
          Integer.valueOf(studentId));
      out.print(gson.toJson(service.findAttendanceStudentById(id)));
    } else {
      out.print(gson.toJson(service.findAllAttendanceStudents()));
    }
    out.flush();
  }
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
//      System.out.println(extractPostRequestBody(request));
      AttendanceStudent attendanceStudent = gson.fromJson(request.getReader(), AttendanceStudent.class);
      attendanceStudent = service.createAttendanceStudent(attendanceStudent);
      String attendanceJson = gson.toJson(attendanceStudent);

      PrintWriter out = response.getWriter();
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      out.print(attendanceJson);
      out.flush();
    } catch (JsonParseException e) {
      response.setStatus(400);
    } catch (Exception e) {
      response.setStatus(500);
    }
  }

  static String extractPostRequestBody(HttpServletRequest request) {
    if ("POST".equalsIgnoreCase(request.getMethod())) {
      Scanner s = null;
      try {
        s = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
      } catch (IOException e) {
        e.printStackTrace();
      }
      return s.hasNext() ? s.next() : "";
    }
    return "";
  }

  @Override
  protected void doPut(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      AttendanceStudent attendanceStudent = gson.fromJson(request.getReader(), AttendanceStudent.class);
      if(attendanceStudent.getId() == null) {
        response.setStatus(400);
        return;
      }
      attendanceStudent = service.updateAttendanceStudent(attendanceStudent);
      String attendanceJson = gson.toJson(attendanceStudent);

      PrintWriter out = response.getWriter();
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      out.print(attendanceJson);
      out.flush();
    } catch (JsonParseException e) {
      response.setStatus(400);
    } catch (Exception e) {
      response.setStatus(500);
    }
  }

}
