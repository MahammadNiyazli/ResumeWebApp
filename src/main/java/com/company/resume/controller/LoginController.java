package com.company.resume.controller;

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
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        if(name!=null && surname!=null){
        UserDaoInter userDao = Context.instanceUserDao();
        List<User> list = null;
        try {
            list = userDao.getAll(null,null,null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String s=null;

        for (User u : list){
            if(name.equalsIgnoreCase(u.getName().trim()) && surname.equalsIgnoreCase(u.getSurname().trim())){
                s="users";
                break;
            }else{
                s="login";
            }

        }

          resp.sendRedirect(s);

      }else{
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
