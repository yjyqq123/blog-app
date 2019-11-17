package com.scs.web.blog.factory;

import com.scs.web.blog.dao.AddressDao;
import com.scs.web.blog.dao.ArticleDao;
import com.scs.web.blog.dao.UserDao;
import com.scs.web.blog.dao.impl.AddressDaoImpl;
import com.scs.web.blog.dao.impl.ArticleDaoImpl;
import com.scs.web.blog.dao.impl.UserDaoImpl;


public class DaoFactory {

    public static UserDao getUserDaoInstance() {
        return new UserDaoImpl();
    }
    public static AddressDao getAddressDaoInstance(){ return new AddressDaoImpl();}

    public static ArticleDao getArticleDaoInstance() {
        return new ArticleDaoImpl();
    }

}
