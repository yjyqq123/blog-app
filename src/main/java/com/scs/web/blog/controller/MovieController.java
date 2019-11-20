package com.scs.web.blog.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(urlPatterns = {"/api/movie"})
public class MovieController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File("D:/12.mp4");

        InputStream inputStream = new FileInputStream(file);
        byte[] b = new byte[(int) file.length()];
        inputStream.read(b);
        resp.setContentType("video/mp4");

        OutputStream outputStream = resp.getOutputStream();
        outputStream.write(b);

        outputStream.close();
        inputStream.close();
    }
}
