package org.learning.model.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.learning.model.model.Student;
import org.learning.model.model.Subject;
import org.learning.model.service.SubjectService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "SubjectServlet", value = "/subject")
public class SubjectServlet extends AbstractServlet {

  private final SubjectService service;


  public SubjectServlet() {
    service = new SubjectService();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String id = request.getParameter("id");

    PrintWriter out = response.getWriter();
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    if (Objects.nonNull(id)) {
      out.print(gson.toJson(service.findSubjectById(Integer.valueOf(id))));
    } else {
      out.print(gson.toJson(service.findAllSubjects()));
    }
    out.flush();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      Subject subject = gson.fromJson(request.getReader(), Subject.class);
      subject = service.createSubject(subject);
      String subjectJson = gson.toJson(subject);

      PrintWriter out = response.getWriter();
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      out.print(subjectJson);
      out.flush();
    } catch (JsonParseException e) {
      response.setStatus(400);
    } catch (Exception e) {
      response.setStatus(500);
    }
  }

}
