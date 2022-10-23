package org.learning.model.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.learning.model.model.Attendance;
import org.learning.model.service.AttendanceService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "AttendanceServlet", value = "/attendance")
public class AttendanceServlet extends HttpServlet {

  private final AttendanceService service;
  private Gson gson = new Gson();


  public AttendanceServlet() {
    service = new AttendanceService();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String id = request.getParameter("id");

    PrintWriter out = response.getWriter();
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    if (Objects.nonNull(id)) {
      out.print(gson.toJson(service.findAttendanceById(Integer.valueOf(id))));
    } else {
      out.print(gson.toJson(service.findAllAttendances()));
    }
    out.flush();
  }
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      Attendance attendance = gson.fromJson(request.getReader(), Attendance.class);
      attendance = service.createAttendance(attendance);
      String attendanceJson = gson.toJson(attendance);

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

  @Override
  protected void doPut(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      Attendance attendance = gson.fromJson(request.getReader(), Attendance.class);
      if(attendance.getId() == null) {
        response.setStatus(400);
        return;
      }
      attendance = service.updateAttendance(attendance);
      String attendanceJson = gson.toJson(attendance);

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
