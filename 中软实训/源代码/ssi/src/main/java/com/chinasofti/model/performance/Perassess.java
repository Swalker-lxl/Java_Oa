package com.chinasofti.model.performance;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Perassess {
    private String id;

    private String uid;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date monthtime;

    private String perrank;

    private String asspeople;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date asstime;

    private String createname;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdatetime;

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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getMonthtime() {
        return monthtime;
    }

    public void setMonthtime(Date monthtime) {
        this.monthtime = monthtime;
    }

    public String getPerrank() {
        return perrank;
    }

    public void setPerrank(String perrank) {
        this.perrank = perrank == null ? null : perrank.trim();
    }

    public String getAsspeople() {
        return asspeople;
    }

    public void setAsspeople(String asspeople) {
        this.asspeople = asspeople == null ? null : asspeople.trim();
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getAsstime() {
        return asstime;
    }

    public void setAsstime(Date asstime) {
        this.asstime = asstime;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }
}