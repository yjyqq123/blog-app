package com.scs.web.blog.controller;

import com.scs.web.blog.util.StringUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 请求验证码的接口
 */
@WebServlet(urlPatterns = {"/api/code"})
public class CodeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.调用字符串生成的方法，生成随机字符串
        String code = StringUtil.getRandomCode();
        //2.存入session，同事会返回给客户端的cookie
        HttpSession session=req.getSession();
        session.setAttribute("code",code);
        int width=130;
        int height=35;
        Random random = new Random();
        Color color = new Color(130,182,45);
        //3.调用生成图形的工具方法，传入图片的高、宽、需要写入的字符串，得到图形象
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //4.将图片先暂存到服务器指定路径
        Graphics g = bi.getGraphics();
        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        g.setColor(color);
        g.fillRect(0,0,width,height);
        g.setColor(Color.DARK_GRAY);
        g.drawString(code,width/4,height/2);
        //5.通过输出流，把图片返回给客户端
        resp.setContentType("image/jpg");
        //6.通过输出流，将数组内容传送到客户端
        ServletOutputStream out=resp.getOutputStream();
        ImageIO.write(bi,"jpg",out);
        //7.关闭流
        out.close();
    }
}
