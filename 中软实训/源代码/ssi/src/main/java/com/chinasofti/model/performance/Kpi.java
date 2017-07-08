package com.chinasofti.model.performance;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Kpi {
	private String id;

	private String pername;

	private String percontent;

	private String post;

	private Integer flag;

	private String createname;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createtime;

	private String modifyname;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifytime;

	// ----------------------
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getPername() {
		return pername;
	}

	public void setPername(String pername) {
		this.pername = pername == null ? null : pername.trim();
	}

	public String getPercontent() {
		return percontent;
	}

	public void setPercontent(String percontent) {
		this.percontent = percontent == null ? null : percontent.trim();
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post == null ? null : post.trim();
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getCreatename() {
		return createname;
	}

	public void setCreatename(String createname) {
		this.createname = createname == null ? null : createname.trim();
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getModifyname() {
		return modifyname;
	}

	public void setModifyname(String modifyname) {
		this.modifyname = modifyname == null ? null : modifyname.trim();
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
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

}