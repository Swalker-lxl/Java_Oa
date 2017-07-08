package com.chinasofti.model.admin;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {
	
	    private String cid;

	    private String cname;

	    private String cpwd;

	    private String createid;

	    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	    private Date createtime;

	    private String modifyid;

	    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	    private Date modifytime;
	    
	    //----------------------
	    private Integer page;
	    
	    private Integer rows;
	    
	    private String order;
	    
	    private String sort;
	    
	    private String ids;

		public String getCid() {
			return cid;
		}

		public void setCid(String cid) {
			this.cid = cid;
		}

		public String getCname() {
			return cname;
		}

		public void setCname(String cname) {
			this.cname = cname;
		}

		public String getCpwd() {
			return cpwd;
		}

		public void setCpwd(String cpwd) {
			this.cpwd = cpwd;
		}

		public String getCreateid() {
			return createid;
		}

		public void setCreateid(String createid) {
			this.createid = createid;
		}

		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
		public Date getCreatetime() {
			return createtime;
		}

		public void setCreatetime(Date createtime) {
			this.createtime = createtime;
		}

		public String getModifyid() {
			return modifyid;
		}

		public void setModifyid(String modifyid) {
			this.modifyid = modifyid;
		}

		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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

		public String getIds() {
			return ids;
		}

		public void setIds(String ids) {
			this.ids = ids;
		}
		
}
