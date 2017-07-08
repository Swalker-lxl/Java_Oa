package com.chinasofti.model.admin;

import java.math.BigDecimal;
import java.util.List;

public class Menu {
    private String cid;

    private String ciconcls;

    private String cname;

    private BigDecimal cseq;

    private String curl;
    
    private String cpid;

    private List<Menu> children;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getCiconcls() {
        return ciconcls;
    }

    public void setCiconcls(String ciconcls) {
        this.ciconcls = ciconcls == null ? null : ciconcls.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public BigDecimal getCseq() {
        return cseq;
    }

    public void setCseq(BigDecimal cseq) {
        this.cseq = cseq;
    }

    public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {
        this.curl = curl == null ? null : curl.trim();
    }
    
	public String getCpid() {
		return cpid;
	}

	public void setCpid(String cpid) {
		this.cpid = cpid;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

}