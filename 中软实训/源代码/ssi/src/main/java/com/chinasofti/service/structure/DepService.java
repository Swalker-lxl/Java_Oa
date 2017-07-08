package com.chinasofti.service.structure;


import java.util.List;

import com.chinasofti.model.structure.Dep;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.pageModel.TreeNode;

public interface DepService {
	public List<TreeNode> menuTree();

	public List<Dep> treegrid();

	public int insertSelective(Dep record);

	public int updateByPrimaryKeySelective(Dep record);

	public int deleteById(String Pid);
}
