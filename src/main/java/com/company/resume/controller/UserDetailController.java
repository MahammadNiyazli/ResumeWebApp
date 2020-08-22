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

/**
 *
 * @author User
 */
@WebServlet(name = "UserDetailController", urlPatterns = {"/userdetail"})
public class UserDetailController extends HttpServlet {

    UserDaoInter userDao = Context.instanceUserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.valueOf(request.getParameter("id"));
        String action = request.getParameter("action");
        if(action.equals("Update")) {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");

            User u = userDao.getById(id);
            u.setName(name);
            u.setSurname(surname);
            userDao.updateUser(u);
        }else if(action.equals("delete")){
            userDao.removeUser(id);
        }
        response.sendRedirect("users");


    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       try {
           UserDaoInter userDao = Context.instanceUserDao();
           User user = null;
           String id = request.getParameter("id");
           if (id == null || id.trim().isEmpty()) {
               throw new IllegalArgumentException("id is not specified");
           }
           Integer idInt = Integer.parseInt(id);
           user = userDao.getById(idInt);
           if (user == null) {
               throw new IllegalArgumentException("There is no with this id");
           }
           request.setAttribute("owner",true);
           request.setAttribute("user",user);
           request.getRequestDispatcher("userdetail.jsp").forward(request,response);
       }catch (Exception ex){
           ex.printStackTrace();
           response.sendRedirect("error?msg="+ex.getMessage());
    }
    }


}

