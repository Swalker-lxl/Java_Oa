package com.chinasofti.model.salary;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Swage {
    private String id;

    private Double basewage;

    private Double meriwag;

    private Double waward;

    private String wbank;

    private String wrank;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    private String createid;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date modifytime;

    private String modifyid;
    //----------------------
    private Integer page;
    
    private Integer rows;
    
    private String order;
    
    private String sort;
    
    public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	private String ids;
    
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

    public Double getBasewage() {
        return basewage;
    }

    public void setBasewage(Double basewage) {
        this.basewage = basewage;
    }

    public Double getMeriwag() {
        return meriwag;
    }

    public void setMeriwag(Double meriwag) {
        this.meriwag = meriwag;
    }

    public Double getWaward() {
        return waward;
    }

    public void setWaward(Double waward) {
        this.waward = waward;
    }

    public String getWbank() {
        return wbank;
    }

    public void setWbank(String wbank) {
        this.wbank = wbank == null ? null : wbank.trim();
    }

    public String getWrank() {
        return wrank;
    }

    public void setWrank(String wrank) {
        this.wrank = wrank == null ? null : wrank.trim();
    }
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateid() {
        return createid;
    }

    public void setCreateid(String createid) {
        this.createid = createid == null ? null : createid.trim();
    }
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getModifyid() {
        return modifyid;
    }

    public void setModifyid(String modifyid) {
        this.modifyid = modifyid == null ? null : modifyid.trim();
    }
}