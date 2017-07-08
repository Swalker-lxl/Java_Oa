package com.chinasofti.model.base;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Att {
    private String id;

    private String name;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date attdate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date atworktime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date offtime;

    private String errorstate;

    private String attappss;

    private String addname;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date addtime;

    private String updatename;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatetime;
    
    //----------------------
    private Integer page;
    
    private Integer rows;
    
    private String order;
    
    private String sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getAttdate() {
        return attdate;
    }

    public void setAttdate(Date attdate) {
        this.attdate = attdate;
    }
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getAtworktime() {
        return atworktime;
    }

    public void setAtworktime(Date atworktime) {
        this.atworktime = atworktime;
    }
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getOfftime() {
        return offtime;
    }

    public void setOfftime(Date offtime) {
        this.offtime = offtime;
    }

    public String getErrorstate() {
        return errorstate;
    }

    public void setErrorstate(String errorstate) {
        this.errorstate = errorstate == null ? null : errorstate.trim();
    }

    public String getAttappss() {
        return attappss;
    }

    public void setAttappss(String attappss) {
        this.attappss = attappss == null ? null : attappss.trim();
    }

    public String getAddname() {
        return addname;
    }

    public void setAddname(String addname) {
        this.addname = addname == null ? null : addname.trim();
    }
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getUpdatename() {
        return updatename;
    }

    public void setUpdatename(String updatename) {
        this.updatename = updatename == null ? null : updatename.trim();
    }
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
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