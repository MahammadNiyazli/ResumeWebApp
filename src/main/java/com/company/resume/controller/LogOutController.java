package com.company.resume.controller;



import dao.inter.UserDaoInter;
import main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author User
 */
@WebServlet(name = "LogOutController", urlPatterns = {"/logout"})
public class LogOutController extends HttpServlet {

    UserDaoInter userDao = Context.instanceUserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession oldSession = request.getSession(false);
        if(oldSession!=null){
            oldSession.invalidate();
            try {
                response.sendRedirect("login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     doPost(request,response);


    }

}


