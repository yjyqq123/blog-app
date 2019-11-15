package com.scs.web.blog.service;

import com.scs.web.blog.domain.UserDto;
import com.scs.web.blog.entity.User;

import java.util.List;
import java.util.Map;


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
