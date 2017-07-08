package com.chinasofti.dao.admin;

import java.util.List;

import com.chinasofti.model.admin.User;

public interface UserMapper {
    int deleteByPrimaryKey(String cid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String cid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	Long count(User user);

	List<User> selectList(User user);
}