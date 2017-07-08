package com.chinasofti.service.admin.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chinasofti.dao.admin.MenuMapper;
import com.chinasofti.model.admin.Menu;
import com.chinasofti.pageModel.TreeNode;
import com.chinasofti.service.admin.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<TreeNode> menuTree() {
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		Menu menu = this.menuMapper.selectRoot();
		TreeNode node = new TreeNode();
		node.setId(menu.getCid());
		node.setText(menu.getCname());
		node.setIconCls(menu.getCiconcls());
		if (menu.getChildren().size() > 0) {
			node.setChildren(this.getChildren(menu));
		}
		nodeList.add(node);
		return nodeList;
	}

	private List<TreeNode> getChildren(Menu menu) {
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		List<Menu> menus = menu.getChildren();
		for (Menu m : menus) {
			TreeNode node = new TreeNode();
			m = this.menuMapper.selectByPrimaryKey(m.getCid());
			node.setId(m.getCid());
			node.setText(m.getCname());
			node.setIconCls(m.getCiconcls());
			if (m.getChildren().size() > 0) {
				node.setChildren(this.getChildren(m));
			} else {
				Map<String, Object> attributes = new HashMap<String, Object>();
				attributes.put("url", m.getCurl());
				node.setAttributes(attributes);
			}
			nodeList.add(node);
		}
		return nodeList;
	}

	private List<Menu> getMenuChildren(Menu menu) {
		List<Menu> nodeList = new ArrayList<Menu>();
		List<Menu> menus = menu.getChildren();
		for (Menu m : menus) {
			m = this.menuMapper.selectByPrimaryKey(m.getCid());
			nodeList.add(m);
			if (m.getChildren().size() > 0) {
				m.setChildren(this.getMenuChildren(m));
			}
		}
		return nodeList;
	}

	@Override
	public List<Menu> treegrid() {
		List<Menu> nodeList = new ArrayList<Menu>();
		Menu menu = this.menuMapper.selectRoot();
		nodeList.add(menu);
		if (menu.getChildren().size() > 0) {
			menu.setChildren(this.getMenuChildren(menu));
		}
		return nodeList;
	}

	@Override
	public int insertSelective(Menu record) {
		record.setCid(UUID.randomUUID().toString());
		return this.menuMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Menu record) {
		return this.menuMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteById(String cid) {
		Menu menu = this.menuMapper.selectByPrimaryKey(cid);
		if (menu.getChildren().size() > 0) {
			this.deleteChildren(menu);
		}
		return this.menuMapper.deleteByPrimaryKey(cid);
	}

	private void deleteChildren(Menu menu) {
		List<Menu> menus = menu.getChildren();
		for (Menu m : menus) {
			m = this.menuMapper.selectByPrimaryKey(m.getCid());
			if (m.getChildren().size() > 0) {
				this.deleteChildren(m);
			}
			this.menuMapper.deleteByPrimaryKey(m.getCid());
		}
	}

}
