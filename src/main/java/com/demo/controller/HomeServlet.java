package com.demo.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomeServlet")
public class HomeServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("service");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost");
        String username = request.getParameter("username");


        Cookie cookie1 = new Cookie("name", "fpt");
        Cookie cookie2 = new Cookie("phone", "123");

        cookie1.setMaxAge(60*60);
//        Xoa cookie
        cookie2.setMaxAge(0);

        response.addCookie(cookie1);
        response.addCookie(cookie2);

        System.out.println(username);
        PrintWriter out = response.getWriter();
        out.println(username);

        String product = getInitParameter("productname");
        out.println(product);

        ServletContext context = getServletContext();
        String connection = context.getInitParameter("connection");
        out.println(connection);
//        response.sendError(404,"Loi roi");

//        Khong hien thi ra duoi file .jsp => back end lam gi, nguoi dung ko biet, an url
        request.getRequestDispatcher("index.jsp").forward(request,response);
//        Ket thuc luon chu trinh va tra ve luon cho nguoi dung file index.jsp
//        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        System.out.println(name);

        String token = request.getHeader("token");

        PrintWriter out = response.getWriter();
        out.println(name);
        out.println(phone);
        out.println(token);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
        System.out.println("doPut");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
        System.out.println("doDelete");
    }
}
