package com.company.resume.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import dao.inter.UserDaoInter;
import entity.User;
import main.Context;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author User
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})

public class LoginController extends HttpServlet {

    private UserDaoInter userDao = Context.instanceUserDao();
    private static  BCrypt.Verifyer verify = BCrypt.verifyer();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      try {
          String email = req.getParameter("email");
          String password = req.getParameter("password");

          User user = userDao.findByEmail(email);
          if (user == null) {
              throw new IllegalArgumentException("This user not exists !!!");
          }

          BCrypt.Result rs = verify.verify(password.toCharArray(),user.getPassword().toCharArray());
          if(!rs.verified){
              throw new IllegalArgumentException("Password is incorrect!!!");
          }
          req.getSession().setAttribute("loggedInUser",user);
          resp.sendRedirect("users");

      }catch(Exception exception){
          ControllerUtil.errorPage(resp,exception);
      }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }
}
