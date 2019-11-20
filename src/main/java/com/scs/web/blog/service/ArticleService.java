package com.scs.web.blog.service;

import com.scs.web.blog.domain.VO.ArticleVo;

import java.util.List;

public interface ArticleService {
    /**
     * 获取热门文章
     * @return
     */
    List<ArticleVo> getHotArticles();
}
