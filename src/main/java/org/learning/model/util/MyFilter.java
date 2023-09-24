package org.learning.model.util;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(displayName = "MyFilter", value = "/admin")
public class MyFilter implements Filter {

  public void init(FilterConfig arg0) throws ServletException {
  }

  public void doFilter(ServletRequest req, ServletResponse resp,
      FilterChain chain) throws IOException, ServletException {

    PrintWriter out = resp.getWriter();

    String password = req.getParameter("password");
    if (password.equals("admin")) {
      chain.doFilter(req, resp);//sends request to next resource
    } else {
      out.print("username or password error!");
      RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
      rd.include(req, resp);
    }

  }

  public void destroy() {
  }

}