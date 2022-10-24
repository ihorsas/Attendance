package org.learning.model.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.learning.model.model.Student;
import org.learning.model.service.StudentService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends AbstractServlet {

  private final StudentService service;


  public StudentServlet() {
    service = new StudentService();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String id = request.getParameter("id");

    PrintWriter out = response.getWriter();
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    if (Objects.nonNull(id)) {
      out.print(gson.toJson(service.findStudentById(Integer.valueOf(id))));
    } else {
      out.print(gson.toJson(service.findAllStudents()));
    }
    out.flush();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      Student student = gson.fromJson(request.getReader(), Student.class);
      student = service.createStudent(student);
      String studentJson = gson.toJson(student);

      PrintWriter out = response.getWriter();
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      out.print(studentJson);
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
      Student student = gson.fromJson(request.getReader(), Student.class);
      if(student.getId() == null) {
        response.setStatus(400);
        return;
      }
      student = service.updateStudent(student);
      String studentJson = gson.toJson(student);

      PrintWriter out = response.getWriter();
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      out.print(studentJson);
      out.flush();
    } catch (JsonParseException e) {
      response.setStatus(400);
    } catch (Exception e) {
      response.setStatus(500);
    }
  }

}
