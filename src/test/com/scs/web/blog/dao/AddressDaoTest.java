package com.scs.web.blog.dao;

import com.scs.web.blog.factory.DaoFactory;
import com.scs.web.blog.util.JSoupSpider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class AddressDaoTest {

    private static Logger logger = LoggerFactory.getLogger(AddressDaoTest.class);
    private AddressDao addressDao = DaoFactory.getAddressDaoInstance();

    @Test
    public void batchInsert() {
        try {
            int[] result = addressDao.batchInsert(JSoupSpider.getAddress());
            if (result.length != 0) {
                logger.info("成功新增" + result.length + "个用户");
            }
        } catch (SQLException e) {
            logger.error("批量新增用户出现异常");
        }
    }
}