package com.scs.web.blog.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.scs.web.blog.dao.UserDao;
import com.scs.web.blog.domain.UserDto;
import com.scs.web.blog.entity.User;
import com.scs.web.blog.factory.ServiceFactory;
import com.scs.web.blog.filter.CorsFilter;
import com.scs.web.blog.service.UserService;
import com.scs.web.blog.util.Message;
import com.scs.web.blog.util.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @author mq_xu
 * @ClassName UserController
 * @Description 用户控制器
 * @Date 15:56 2019/11/9
 * @Version 1.0
 **/
@WebServlet(urlPatterns = {"/sign-in"})
public class UserController extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService = ServiceFactory.getUserServiceInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        logger.info("登录用户信息：" + stringBuilder.toString());
        Gson gson = new GsonBuilder().create();
        UserDto userDto = gson.fromJson(stringBuilder.toString(), UserDto.class);
        Map<String, Object> map = userService.signIn(userDto);
        String msg = (String) map.get("msg");
        ResponseObject ro;
        if (msg.equals(Message.SIGN_IN_SUCCESS)) {
            ro = ResponseObject.success(200, msg, map.get("data"));
        } else {
            ro = ResponseObject.success(200, msg);
        }
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = userService.listUser();
        Gson gson = new GsonBuilder().create();
        ResponseObject ro=new ResponseObject();
        ro.setCode(resp.getStatus());
        if(resp.getStatus()==200){
            ro.setMsg("响应成功");
        }else{
            ro.setMsg("响应失败");
        }
        ro.setData(userList);
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }

    @Override
    public void init() throws ServletException {
        logger.info("UserController初始化");
    }
}