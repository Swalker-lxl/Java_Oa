package com.chinasofti.model.base;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Afl {
    private String aflid;

    private String id;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date aflstime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date faletime;

    private Integer manhours;

    private String afltype;

    private String btexplan;

    private String btapprover;

    private String btappss;
    
    //----------------------
    private Integer page;
    
    private Integer rows;
    
    private String order;
    
    private String sort;
    
    private String ids;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date btappdate;

    private String addname;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date addtime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatetime;

    private String updatename;

    public String getAflid() {
        return aflid;
    }

    public void setAflid(String aflid) {
        this.aflid = aflid == null ? null : aflid.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getAflstime() {
        return aflstime;
    }

    public void setAflstime(Date aflstime) {
        this.aflstime = aflstime;
    }
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getFaletime() {
        return faletime;
    }

    public void setFaletime(Date faletime) {
        this.faletime = faletime;
    }

    public Integer getManhours() {
        return manhours;
    }

    public void setManhours(Integer manhours) {
        this.manhours = manhours;
    }

    public String getAfltype() {
        return afltype;
    }

    public void setAfltype(String afltype) {
        this.afltype = afltype == null ? null : afltype.trim();
    }

    public String getBtexplan() {
        return btexplan;
    }

    public void setBtexplan(String btexplan) {
        this.btexplan = btexplan == null ? null : btexplan.trim();
    }

    public String getBtapprover() {
        return btapprover;
    }

    public void setBtapprover(String btapprover) {
        this.btapprover = btapprover == null ? null : btapprover.trim();
    }

    public String getBtappss() {
        return btappss;
    }

    public void setBtappss(String btappss) {
        this.btappss = btappss == null ? null : btappss.trim();
    }
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getBtappdate() {
        return btappdate;
    }

    public void setBtappdate(Date btappdate) {
        this.btappdate = btappdate;
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
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdatename() {
        return updatename;
    }

    public void setUpdatename(String updatename) {
        this.updatename = updatename == null ? null : updatename.trim();
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