package com.chinasofti.service.employee.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.dao.employee.JobMapper;
import com.chinasofti.model.employee.Job;
import com.chinasofti.pageModel.DataGrid;
import com.chinasofti.service.employee.JobService;
import com.chinasofti.util.ToolUtil;
@Service("jobService")
public class JobServiceImpl implements JobService{
	@Autowired
	private JobMapper jobMapper;

	@Override
	public DataGrid datagrid(Job job) {
		DataGrid dataGrid = new DataGrid();
		job.setPage((job.getPage() - 1) * job.getRows());
		dataGrid.setTotal(jobMapper.count(job));
		dataGrid.setRows(jobMapper.selectList(job));
		return dataGrid;
	}

	@Override
	public void add(Job job, HttpSession session) {
		job.setAddname((ToolUtil.user(session)));
		job.setAddtime(new Date());
		jobMapper.insertSelective(job);
	}

	@Override
	public void edit(Job job, HttpSession session) {
		job.setUpdatename(ToolUtil.user(session));
		job.setUpdatetime(new Date());
		jobMapper.updateByPrimaryKeySelective(job);
	}

	@Override
	public void remove(Job job) {
		String[] ids = job.getIds().split(",");
		for (String id : ids) {
			jobMapper.deleteByPrimaryKey(id);
		}
	}
}
