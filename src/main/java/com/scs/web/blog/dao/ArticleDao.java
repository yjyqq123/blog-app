package com.scs.web.blog.dao;

import com.scs.web.blog.entity.Article;

import java.sql.SQLException;
import java.util.List;

public interface ArticleDao {
    /**
     * 批量新增文章
     *
     * @param articleList
     * @return
     * @throws SQLException
     */
    int[] batchInsert(List<Article> articleList) throws SQLException;

}
