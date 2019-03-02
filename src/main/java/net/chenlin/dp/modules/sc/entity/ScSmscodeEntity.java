package net.chenlin.dp.modules.sc.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public class ScSmscodeEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private String phonenum;
	
	/**
	 * 
	 */
	private String smscode;
	
	/**
	 * 
	 */
	private Date creattime;
	
    /**
     * ScSmscodeEntity constructor
     */
	public ScSmscodeEntity() {
		super();
	}

    /**
     * setter for phonenum
     * @param phonenum
     */
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

    /**
     * getter for phonenum
     */
	public String getPhonenum() {
		return phonenum;
	}

    /**
     * setter for smscode
     * @param smscode
     */
	public void setSmscode(String smscode) {
		this.smscode = smscode;
	}

    /**
     * getter for smscode
     */
	public String getSmscode() {
		return smscode;
	}

    /**
     * setter for creattime
     * @param creattime
     */
	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

    /**
     * getter for creattime
     */
	public Date getCreattime() {
		return creattime;
	}

    /**
     * ScSmscodeEntity.toString()
     */
    @Override
    public String toString() {
        return "ScSmscodeEntity{" +
               "phonenum='" + phonenum + '\'' +
               ", smscode='" + smscode + '\'' +
               ", creattime='" + creattime + '\'' +
               '}';
    }

}
