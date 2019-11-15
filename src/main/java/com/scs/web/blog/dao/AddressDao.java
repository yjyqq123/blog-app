package com.scs.web.blog.dao;

import com.scs.web.blog.entity.Address;
import com.scs.web.blog.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface AddressDao {
    /**
     * 批量新增用户
     *
     * @param studentList
     * @return int[]
     * @throws SQLException
     */
    int[] batchInsert(List<Address> addressList) throws SQLException;
}
