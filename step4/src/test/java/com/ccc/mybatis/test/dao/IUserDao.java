package com.ccc.mybatis.test.dao;

import com.ccc.mybatis.test.po.User;

public interface IUserDao {

    User queryUserInfoById(Long uId);

}