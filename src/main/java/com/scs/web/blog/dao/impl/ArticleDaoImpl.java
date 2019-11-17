package com.scs.web.blog.dao.impl;

import com.scs.web.blog.dao.ArticleDao;
import com.scs.web.blog.entity.Article;
import com.scs.web.blog.util.DbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ArticleDaoImpl implements ArticleDao {
    private static Logger logger = LoggerFactory.getLogger(ArticleDaoImpl.class);

    @Override
    public int[] batchInsert(List<Article> articleList) throws SQLException {
        Connection connection = DbUtil.getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO t_article (user_id,title,summary,thumbnail,content,likes,comments,create_time) VALUES (?,?,?,?,?,?,?,?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        articleList.forEach(article -> {
            try {
                pstmt.setLong(1, article.getUserId());
                pstmt.setString(2, article.getTitle());
                pstmt.setString(3, article.getSummary());
                pstmt.setString(4, article.getThumbnail());
                pstmt.setString(5, article.getContent());
                pstmt.setInt(6, article.getLikes());
                pstmt.setInt(7, article.getComments());
                pstmt.setObject(8, article.getCreateTime());
                pstmt.addBatch();
            } catch (SQLException e) {
                logger.error("批量加入文章数据产生异常");
            }
        });
        int[] result = pstmt.executeBatch();
        connection.commit();
        DbUtil.close(null, pstmt, connection);
        return result;
    }
}
