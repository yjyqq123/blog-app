package com.scs.web.blog.factory;

import com.scs.web.blog.service.UserService;
import com.scs.web.blog.service.impl.UserServiceImpl;


public class ServiceFactory {
    public static UserService getUserServiceInstance() {
        return new UserServiceImpl();
    }
}
