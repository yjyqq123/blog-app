package com.scs.web.blog.service;

import com.scs.web.blog.domain.UserDto;
import com.scs.web.blog.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author mq_xu
 * @ClassName UserService
 * @Description 用户业务逻辑接口
 * @Date 12:01 2019/11/9
 * @Version 1.0
 **/
public interface UserService {
    /**
     * 用户登录功能
     *
     * @param userDto
     * @return
     */
    Map<String, Object> signIn(UserDto userDto);

    /**
     * 所有用户查询功能
     * @return
     */
    List<User> listUser();
}
