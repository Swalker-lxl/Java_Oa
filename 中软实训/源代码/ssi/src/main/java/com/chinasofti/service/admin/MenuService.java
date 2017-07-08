package com.chinasofti.service.admin;

import java.util.List;
import com.chinasofti.model.admin.Menu;
import com.chinasofti.pageModel.TreeNode;

public interface MenuService {

	public List<TreeNode> menuTree();

	public List<Menu> treegrid();

	public int insertSelective(Menu record);

	public int updateByPrimaryKeySelective(Menu record);

	public int deleteById(String cid);

}
