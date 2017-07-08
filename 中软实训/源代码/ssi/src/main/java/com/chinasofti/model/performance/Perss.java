package com.chinasofti.model.performance;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Perss {
	private String id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date monthtime;

	private String state;

	private String createname;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdatetime;

	private String modifyname;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifydatetime;

	private Integer page;
	private Integer rows;
	private String order;
	private String sort;
	private String ids;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getMonthtime() {
		return monthtime;
	}

	public void setMonthtime(Date monthtime) {
		this.monthtime = monthtime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public String getCreatename() {
		return createname;
	}

	public void setCreatename(String createname) {
		this.createname = createname == null ? null : createname.trim();
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreatedatetime() {
		return createdatetime;
	}

	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}

	public String getModifyname() {
		return modifyname;
	}

	public void setModifyname(String modifyname) {
		this.modifyname = modifyname == null ? null : modifyname.trim();
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getModifydatetime() {
		return modifydatetime;
	}

	public void setModifydatetime(Date modifydatetime) {
		this.modifydatetime = modifydatetime;
	}
}