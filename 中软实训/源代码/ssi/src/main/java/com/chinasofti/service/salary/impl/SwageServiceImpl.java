package com.chinasofti.service.salary.impl;

import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chinasofti.dao.admin.UserMapper;
import com.chinasofti.dao.salary.SwageMapper;
import com.chinasofti.model.admin.User;
import com.chinasofti.model.salary.Swage;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.service.admin.UserService;
import com.chinasofti.service.salary.SwageService;
import com.chinasofti.util.Md5Util;
import com.chinasofti.util.ToolUtil;

@Service("SwageService")
public class SwageServiceImpl implements SwageService {

	@Autowired
	private SwageMapper swageMapper;

	@Override
	public Swage query(Swage user) {
		return swageMapper.selectByPrimaryKey(user.getId());
	}


	@Override
	public DataGrid datagrid(Swage user) {
		DataGrid dataGrid = new DataGrid();
		user.setPage((user.getPage() - 1) * user.getRows());
		dataGrid.setTotal(swageMapper.count(user));
		dataGrid.setRows(swageMapper.selectList(user));
		return dataGrid;
	}

	@Override
	public void add(Swage user, HttpSession session) {
		user.setCreateid(ToolUtil.user(session));
		user.setCreatetime(new Date());
		swageMapper.insertSelective(user);
	}

	@Override
	public void remove(Swage user) {
		String[] ids = user.getIds().split(",");
		for (String id : ids) {
			swageMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public void edit(Swage user, HttpSession session) {
		user.setModifyid(ToolUtil.user(session));
		user.setModifytime(new Date());
		swageMapper.updateByPrimaryKeySelective(user);
	}

	

}
