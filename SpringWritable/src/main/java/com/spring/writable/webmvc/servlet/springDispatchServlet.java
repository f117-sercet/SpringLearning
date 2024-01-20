package com.spring.writable.webmvc.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Description： TODO
 *
 * @author: 段世超
 * @aate: Created in 2024/1/12 18:08
 */
@Slf4j
public class springDispatchServlet extends HttpServlet {

    private final String Location = "contextConfiguration";

    private List<GPHandlerMapping>

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
