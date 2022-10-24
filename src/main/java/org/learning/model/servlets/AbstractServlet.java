package org.learning.model.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.http.HttpServlet;

//TODO
public abstract class AbstractServlet extends HttpServlet {
  protected Gson gson;

  AbstractServlet() {
    gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
  }
}
