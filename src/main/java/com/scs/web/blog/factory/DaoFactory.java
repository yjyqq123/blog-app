package com.scs.web.blog.factory;

import com.scs.web.blog.dao.AddressDao;
import com.scs.web.blog.dao.UserDao;
import com.scs.web.blog.dao.impl.AddressDaoImpl;
import com.scs.web.blog.dao.impl.UserDaoImpl;

/**
 * @author mq_xu
 * @ClassName DaoFactory
 * @Description Dao工厂类
 * @Date 11:39 2019/11/6
 * @Version 1.0
 **/
public class DaoFactory {

    public static UserDao getUserDaoInstance() {
        return new UserDaoImpl();
    }
    public static AddressDao getAddressDaoInstance(){ return new AddressDaoImpl();}

}
