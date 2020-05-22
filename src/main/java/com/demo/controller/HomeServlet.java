package com.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
