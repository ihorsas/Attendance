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
public class StudentServlet extends HttpServlet {

  private final StudentService service;
  private Gson gson = new Gson();


  public StudentServlet() {
    service = new StudentService();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String id = request.getParameter("id");

    response.setContentType("text/html");
    PrintWriter printWriter = response.getWriter();
    if (Objects.nonNull(id)) {
      printWriter.write("<h2>Requested student</h2>");
      printWriter.write("<p>" + service.findStudentById(Integer.valueOf(id)).toString() + "</p>");
    } else {
      printWriter.write("<p>All students:</p>");
      for (Student student : service.findAllStudents()) {
        printWriter.write("<p>" + student.toString() + "</p>");

      }
    }
    printWriter.close();
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

}
