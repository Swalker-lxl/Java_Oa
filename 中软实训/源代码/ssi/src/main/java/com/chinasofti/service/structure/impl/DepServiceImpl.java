package com.chinasofti.service.structure.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.dao.structure.DepMapper;
import com.chinasofti.model.admin.Menu;
import com.chinasofti.model.structure.Dep;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.pageModel.TreeNode;
import com.chinasofti.service.structure.DepService;
@Service("depService")
public class DepServiceImpl implements DepService {
	@Autowired
	private DepMapper depMapper;

	@Override
	public List<TreeNode> menuTree() {
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		Dep dept = this.depMapper.selectRoot();
		TreeNode node = new TreeNode();
		node.setId(dept.getPid());
		node.setText(dept.getPname());
		node.setIconCls(dept.getPidconcls());
		if (dept.getChildren().size() > 0) {
			node.setChildren(this.getChildren(dept));
		}
		nodeList.add(node);
		return nodeList;
	}

	private List<TreeNode> getChildren(Dep dept) {
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		List<Dep> depts = dept.getChildren();
		for (Dep m : depts) {
			TreeNode node = new TreeNode();
			m = this.depMapper.selectByPrimaryKey(m.getPid());
			node.setId(m.getPid());
			node.setText(m.getPname());
			node.setIconCls(m.getPidconcls());
			if (m.getChildren().size() > 0) {
				node.setChildren(this.getChildren(m));
			} else {
				Map<String, Object> attributes = new HashMap<String, Object>();
				attributes.put("message", m.getMessage());
				node.setAttributes(attributes);
			}
			nodeList.add(node);
		}
		return nodeList;
	}

	private List<Dep> getMenuChildren(Dep dept) {
		List<Dep> nodeList = new ArrayList<Dep>();
		List<Dep> menus = dept.getChildren();
		for (Dep m : menus) {
			m = this.depMapper.selectByPrimaryKey(m.getPid());
			nodeList.add(m);
			if (m.getChildren().size() > 0) {
				m.setChildren(this.getMenuChildren(m));
			}
		}
		return nodeList;
	}
	@Override
	public List<Dep> treegrid() {
		List<Dep> nodeList = new ArrayList<Dep>();
		Dep post = this.depMapper.selectRoot();
		nodeList.add(post);
		if (post.getChildren().size() > 0) {
			post.setChildren(this.getMenuChildren(post));
		}
		return nodeList;
	}

	@Override
	public int insertSelective(Dep record) {
		record.setPid(UUID.randomUUID().toString());
		return this.depMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Dep record) {
		return this.depMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteById(String cid) {
		Dep menu = this.depMapper.selectByPrimaryKey(cid);
		if (menu.getChildren().size() > 0) {
			this.deleteChildren(menu);
		}
		return this.depMapper.deleteByPrimaryKey(cid);
	}
	private void deleteChildren(Dep menu) {
		List<Dep> menus = menu.getChildren();
		for (Dep m : menus) {
			m = this.depMapper.selectByPrimaryKey(m.getPid());
			if (m.getChildren().size() > 0) {
				this.deleteChildren(m);
			}
			this.depMapper.deleteByPrimaryKey(m.getPid());
		}
	}
	

}
