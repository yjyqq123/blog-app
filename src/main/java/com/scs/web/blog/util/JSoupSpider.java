package com.scs.web.blog.util;

import com.scs.web.blog.entity.Address;
import com.scs.web.blog.entity.Article;
import com.scs.web.blog.entity.User;
import org.jsoup.Jsoup;
import org.jsoup.helper.DataUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class JSoupSpider {
    private static Logger logger = LoggerFactory.getLogger(JSoupSpider.class);

    public static List<User> getUsers() {
        Document document = null;
        List<User> userList = new ArrayList<>(100);
        for (int i = 1; i <= 3; i++) {
            try {
                document = Jsoup.connect("https://www.jianshu.com/recommendations/users?utm_source=desktop&utm_medium=index-users&page=" + i).get();
            } catch (IOException e) {
                logger.error("连接失败");
            }
            Elements divs = document.getElementsByClass("col-xs-8");
            divs.forEach(div -> {
                Element wrapDiv = div.child(0);
                Element link = wrapDiv.child(0);
                Elements linkChildren = link.children();
                User user = new User();
                user.setMobile(UserDataUtil.getMobile());
                user.setPassword(UserDataUtil.getPassword());
                user.setGender(UserDataUtil.getGender());
                user.setAvatar("https:" + linkChildren.get(0).attr("src"));
                user.setNickname(linkChildren.get(1).text());
                user.setIntroduction(linkChildren.get(2).text());
                user.setBirthday(UserDataUtil.getBirthday());
                user.setCreateTime(LocalDateTime.now());
                userList.add(user);
            });
        }
        return userList;
    }
    public static List<Address> getAddress() {
        Document document = null;
        List<Address> addressList = new ArrayList();

        try {
            document = Jsoup.connect("http://www.ip33.com/area_code.html" ).get();
        } catch (IOException e) {
            logger.error("连接失败");
        }
        Elements divs = document.getElementsByClass("ip");
        divs.forEach(div -> {

            Elements elements = div.child(1).child(0).child(1).children();
            elements.forEach(element -> {
                Address address = new Address();
                StringBuilder province = new StringBuilder("");
                String country = div.child(1).child(0).child(0).text();
                int c = country.indexOf(" ");
                int p = div.child(0).text().indexOf(" ");
                int e = element.text().indexOf(" ");
                province.append(div.child(0).text().substring(0, p)).append(country.substring(0,c)).append(element.text().substring(0, e));
                address.setAddress(province.toString());
                addressList.add(address);
            });

        });

        return addressList;
    }
    public static List<Article> getArticles() {
        Document document = null;
        List<Article> articleList = new ArrayList<>(100);
        for (int i = 1; i < 10; i++) {
            try {
                document = Jsoup.connect("https://www.jianshu.com/c/87b50a03a96e?order_by=top&count=50&page=" + i).get();
            } catch (IOException e) {
                logger.error("连接失败");
            }
            Elements divs = document.getElementsByClass("have-img");
            divs.forEach(div -> {
                String articleUrl = div.child(0).attr("href");
                Document document1 = null;
                try {
                    document1 = Jsoup.connect("https://www.jianshu.com" + articleUrl).get();
                } catch (IOException e) {
                    logger.error("连接失败");
                }
                Element articleElement = document1.getElementsByClass("_2rhmJa").first();
                Article article = new Article();
                article.setContent(articleElement.html());

                Elements elements = div.children();
                Element linkElement = elements.get(0);
                Element divElement = elements.get(1);
                article.setUserId(DbUtil.getUserId());
                article.setTitle(divElement.child(0).text());
                article.setSummary(divElement.child(1).text());
                String img = "https:" + linkElement.child(0).attr("src");
                int index = img.indexOf("?");
                article.setThumbnail(img.substring(0, index));
                Elements metaChildren = divElement.child(2).children();
                String comments = metaChildren.get(2).text();
                String likes = metaChildren.last().text();
                try {
                    article.setComments(Integer.parseInt(comments));
                    article.setLikes(Integer.parseInt(likes));
                } catch (NumberFormatException e) {
                    logger.error("格式转换异常");
                }
                article.setCreateTime(DbUtil.getCreateTime());
                articleList.add(article);
            });
        }
        System.out.println(articleList.size());
        return articleList;
    }

}

