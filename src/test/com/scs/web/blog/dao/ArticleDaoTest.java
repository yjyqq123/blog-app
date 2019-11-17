package com.scs.web.blog.dao;

import com.scs.web.blog.factory.DaoFactory;
import com.scs.web.blog.util.JSoupSpider;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ArticleDaoTest {
    private ArticleDao articleDao = DaoFactory.getArticleDaoInstance();

    @Test
    public void batchInsert() throws Exception{
        int[] result = articleDao.batchInsert(JSoupSpider.getArticles());
        System.out.println(result.length);

    }
}