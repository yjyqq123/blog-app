package com.scs.web.blog.dao.impl;

import com.scs.web.blog.dao.AddressDao;
import com.scs.web.blog.entity.Address;
import com.scs.web.blog.entity.User;
import com.scs.web.blog.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class AddressDaoImpl implements AddressDao {

    @Override
    public int[] batchInsert(List<Address> addressList) throws SQLException {
        Connection connection = DbUtil.getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO t_address (address) VALUES (?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        addressList.forEach(user -> {
            try {
                pstmt.setString(1, user.getAddress());
                pstmt.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        int[] result = pstmt.executeBatch();
        //别忘记提交
        connection.commit();
        DbUtil.close(null, pstmt, connection);
        return result;
    }
}


