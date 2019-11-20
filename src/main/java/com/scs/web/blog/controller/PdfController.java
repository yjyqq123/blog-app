package com.scs.web.blog.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(urlPatterns = {"/api/pdf"})
public class PdfController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file1 = new File("D:/JAVA_WEB_笔记 .pdf");

        InputStream inputStream = new FileInputStream(file1);
        byte[] b = new byte[(int) file1.length()];
        inputStream.read(b);
        resp.setContentType("application/pdf");

        OutputStream outputStream = resp.getOutputStream();
        outputStream.write(b);

        outputStream.close();
        inputStream.close();
    }
}
