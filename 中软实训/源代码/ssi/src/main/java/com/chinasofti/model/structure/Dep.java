package com.chinasofti.model.structure;

import java.math.BigDecimal;
import java.util.List;

import com.chinasofti.model.admin.Menu;

public class Dep {
    private String pid;

    private String pidconcls;

    private String pname;

    private BigDecimal cseq;

    private String cpid;

    private String message;
    
    public List<Dep> getChildren() {
		return children;
	}

	public void setChildren(List<Dep> children) {
		this.children = children;
	}

	private List<Dep> children;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getPidconcls() {
        return pidconcls;
    }

    public void setPidconcls(String pidconcls) {
        this.pidconcls = pidconcls == null ? null : pidconcls.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public BigDecimal getCseq() {
        return cseq;
    }

    public void setCseq(BigDecimal cseq) {
        this.cseq = cseq;
    }

    public String getCpid() {
        return cpid;
    }

    public void setCpid(String cpid) {
        this.cpid = cpid == null ? null : cpid.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}