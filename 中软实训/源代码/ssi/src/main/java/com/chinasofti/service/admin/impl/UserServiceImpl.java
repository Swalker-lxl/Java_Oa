package com.chinasofti.service.admin.impl;

import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chinasofti.dao.admin.UserMapper;
import com.chinasofti.model.admin.User;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.service.admin.UserService;
import com.chinasofti.util.Md5Util;
import com.chinasofti.util.ToolUtil;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User query(User user) {
		return userMapper.selectByPrimaryKey(user.getCid());
	}

	@Override
	public void edit(User user, HttpSession session) {
		if (!ToolUtil.isEmpty(user.getCpwd())) {
			user.setCpwd(Md5Util.md5(user.getCpwd()));
		}
		user.setModifyid(ToolUtil.user(session));
		user.setModifytime(new Date());
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public DataGrid datagrid(User user) {
		DataGrid dataGrid = new DataGrid();
		user.setPage((user.getPage() - 1) * user.getRows());
		dataGrid.setTotal(userMapper.count(user));
		dataGrid.setRows(userMapper.selectList(user));
		return dataGrid;
	}

	@Override
	public void add(User user, HttpSession session) {
		user.setCpwd(Md5Util.md5(user.getCpwd()));
		user.setCreateid(ToolUtil.user(session));
		user.setCreatetime(new Date());
		userMapper.insertSelective(user);
	}

	@Override
	public void remove(User user) {
		String[] ids = user.getIds().split(",");
		for (String id : ids) {
			userMapper.deleteByPrimaryKey(id);
		}
	}

}
