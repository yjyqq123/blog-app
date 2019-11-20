package com.scs.web.blog.domain.VO;

import lombok.Data;

@Data
public class ArticleVo {
    private Long id;
    private Long userId;
    private String nickname;
    private String avatar;
    private String title;
    private String summary;
    private String thumbnail;
    private Integer likes;
    private Integer comments;
}
