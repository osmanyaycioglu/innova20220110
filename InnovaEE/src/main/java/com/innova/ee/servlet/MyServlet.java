package com.innova.ee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/servlet")
public class MyServlet extends HttpServlet {


    @Override
    protected void doGet(final HttpServletRequest reqParam,
                         final HttpServletResponse respParam) throws ServletException, IOException {
        System.out.println("Servlete Geldi");
        PrintWriter writerLoc = respParam.getWriter();
        writerLoc.println("Hello World");
        respParam.addHeader("Content-Type",
                            "text/plain");
    }

    @Override
    protected void doPost(final HttpServletRequest reqParam,
                          final HttpServletResponse respParam) throws ServletException, IOException {
        System.out.println("Servlete Geldi");
        PrintWriter writerLoc = respParam.getWriter();
        writerLoc.println("Hello World");
        respParam.addHeader("Content-Type",
                            "text/plain");
    }


}
