package org.learning.model.servlets;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServlet;
import org.learning.model.service.SubjectService;

import java.io.Serializable;

//TODO
public abstract class AbstractServlet<T, Id extends Serializable> extends HttpServlet {

}
