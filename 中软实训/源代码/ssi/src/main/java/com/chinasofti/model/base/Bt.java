package com.chinasofti.model.base;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Bt {
    private String btid;

    private String id;

    private String name;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date btsdate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date btedate;

    private String btplace;

    private String btvehicle;

    private String btexplain;

    private String btapprover;

    private String attappss;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date btappdate;

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
    
    private String ids;

    public String getBtid() {
        return btid;
    }

    public void setBtid(String btid) {
        this.btid = btid == null ? null : btid.trim();
    }

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
    public Date getBtsdate() {
        return btsdate;
    }

    public void setBtsdate(Date btsdate) {
        this.btsdate = btsdate;
    }
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getBtedate() {
        return btedate;
    }

    public void setBtedate(Date btedate) {
        this.btedate = btedate;
    }

    public String getBtplace() {
        return btplace;
    }

    public void setBtplace(String btplace) {
        this.btplace = btplace == null ? null : btplace.trim();
    }

    public String getBtvehicle() {
        return btvehicle;
    }

    public void setBtvehicle(String btvehicle) {
        this.btvehicle = btvehicle == null ? null : btvehicle.trim();
    }

    public String getBtexplain() {
        return btexplain;
    }

    public void setBtexplain(String btexplain) {
        this.btexplain = btexplain == null ? null : btexplain.trim();
    }

    public String getBtapprover() {
        return btapprover;
    }

    public void setBtapprover(String btapprover) {
        this.btapprover = btapprover == null ? null : btapprover.trim();
    }

    public String getAttappss() {
        return attappss;
    }

    public void setAttappss(String attappss) {
        this.attappss = attappss == null ? null : attappss.trim();
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

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
    
}