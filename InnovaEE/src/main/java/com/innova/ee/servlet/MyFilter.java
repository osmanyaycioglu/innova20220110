package com.innova.ee.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class MyFilter implements Filter {

    @Override
    public void doFilter(final ServletRequest requestParam,
                         final ServletResponse responseParam,
                         final FilterChain chainParam) throws IOException, ServletException {
        System.out.println("Filter çalıştı");
        String parameterLoc = requestParam.getParameter("name");
        if (!"osman".equals(parameterLoc)) {
            chainParam.doFilter(requestParam,
                                responseParam);
        } else {
            responseParam.getWriter()
                         .print("Filtere devam etmedi");
            ((HttpServletResponse) responseParam).addHeader("Content-Type",
                                                            "text/plain");

        }
    }

}
