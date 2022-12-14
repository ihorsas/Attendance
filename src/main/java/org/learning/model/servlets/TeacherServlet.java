package org.learning.model.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.learning.model.model.Teacher;
import org.learning.model.service.TeacherService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "teacherServlet", value = "/teacher")
public class TeacherServlet extends AbstractServlet {

  private final TeacherService service;

  public TeacherServlet() {
    service = new TeacherService();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String id = request.getParameter("id");

    PrintWriter out = response.getWriter();
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    if (Objects.nonNull(id)) {
      out.print(gson.toJson(service.findTeacherById(Integer.valueOf(id))));
    } else {
      out.print(gson.toJson(service.findAllTeachers()));
    }
    out.flush();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      Teacher teacher = gson.fromJson(request.getReader(), Teacher.class);
      teacher = service.createTeacher(teacher);
      String teacherJson = gson.toJson(teacher);

      PrintWriter out = response.getWriter();
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      out.print(teacherJson);
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
      Teacher teacher = gson.fromJson(request.getReader(), Teacher.class);
      if(teacher.getId() == null) {
        response.setStatus(400);
        return;
      }
      teacher = service.updateTeacher(teacher);
      String teacherJson = gson.toJson(teacher);

      PrintWriter out = response.getWriter();
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      out.print(teacherJson);
      out.flush();
    } catch (JsonParseException e) {
      response.setStatus(400);
    } catch (Exception e) {
      response.setStatus(500);
    }
  }

}
