package com.samsolutions.traceable.util.controller;

import com.samsolutions.traceable.util.Statistic;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dznor on 06.02.2017.
 */

@WebServlet("/")
public class TraceableController extends HttpServlet {
    @Autowired
    private Statistic statistic;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        super.doGet(req, resp);
        statistic.show3LongestOperations();
    }
}
