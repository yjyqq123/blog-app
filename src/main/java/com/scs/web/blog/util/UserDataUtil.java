package com.scs.web.blog.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;

/**
 * @author mq_xu
 * @ClassName StingUtil
 * @Description 模拟构造用户数据的工具类
 * @Date 11:30 2019/11/9
 * @Version 1.0
 **/
public class UserDataUtil {
    public static String getMobile() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder("139");
        for (int i = 0; i < 8; i++) {
            stringBuilder.append(String.valueOf(random.nextInt(9)));
        }
        return stringBuilder.toString();
    }

    public static String getPassword() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(String.valueOf(random.nextInt(9)));
        }
        return DigestUtils.md5Hex(stringBuilder.toString());
    }

    public static String getGender() {
        Random random = new Random();
        String[] data = new String[]{"男", "女"};
        int index = random.nextInt(2);
        return data[index];
    }

    public static LocalDate getBirthday() {
        LocalDate now = LocalDate.now();
        Random random = new Random();
        int bound = random.nextInt(8888);
        return now.minusDays(bound);
    }
}
