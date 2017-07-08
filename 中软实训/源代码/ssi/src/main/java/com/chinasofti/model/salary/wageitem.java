package com.chinasofti.model.salary;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class wageitem {
	  private Integer page;
	    
	    private Integer rows;
	    
	    private String order;
	    
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

		private String sort;
	    
	    private String ids;
    private String waid;

    private String wuid;

    private Double basewage;

    private Double meritwage;

    private Double bouns;

    private Double deductions;

    private Double dedfiveone;

    private String wagetime;

    private Double shsend;

    private Double realsend;

    private String createname;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    private String modifyname;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date modifytime;

    public String getWaid() {
        return waid;
    }

    public void setWaid(String waid) {
        this.waid = waid == null ? null : waid.trim();
    }

    public String getWuid() {
        return wuid;
    }

    public void setWuid(String wuid) {
        this.wuid = wuid == null ? null : wuid.trim();
    }

    public Double getBasewage() {
        return basewage;
    }

    public void setBasewage(Double basewage) {
        this.basewage = basewage;
    }

    public Double getMeritwage() {
        return meritwage;
    }

    public void setMeritwage(Double meritwage) {
        this.meritwage = meritwage;
    }

    public Double getBouns() {
        return bouns;
    }

    public void setBouns(Double bouns) {
        this.bouns = bouns;
    }

    public Double getDeductions() {
        return deductions;
    }

    public void setDeductions(Double deductions) {
        this.deductions = deductions;
    }

    public Double getDedfiveone() {
        return dedfiveone;
    }

    public void setDedfiveone(Double dedfiveone) {
        this.dedfiveone = dedfiveone;
    }

    public String getWagetime() {
        return wagetime;
    }

    public void setWagetime(String wagetime) {
        this.wagetime = wagetime == null ? null : wagetime.trim();
    }

    public Double getShsend() {
        return shsend;
    }

    public void setShsend(Double shsend) {
        this.shsend = shsend;
    }

    public Double getRealsend() {
        return realsend;
    }

    public void setRealsend(Double realsend) {
        this.realsend = realsend;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }
}