package com.scs.web.blog.service;

import com.scs.web.blog.dao.UserDao;
import com.scs.web.blog.domain.UserDto;
import com.scs.web.blog.factory.ServiceFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService userService = ServiceFactory.getUserServiceInstance();

    @Test
    public void signIn(){
        Map<String,Object> map  =new HashMap<>();
        UserDto userDao = new UserDto("13988808582","e46a796ea037ed8ca491b6543337af07");
        map = userService.signIn(userDao);
        System.out.println(map.get("msg"));
        System.out.println(map.get("data"));
    }
}