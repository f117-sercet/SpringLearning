package com.spring.writable.webmvc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2024/1/12 18:08
 */
public class springDispatchServlet extends HttpServlet {
    @Override
    public void init() throws ServletException  {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
