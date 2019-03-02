package net.chenlin.dp.modules.sc.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public class ScUploadEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Long uploadid;
	
	/**
	 * 智能充电桩
	 */
	private String outletid;
	
	/**
	 * 
	 */
	private Integer serialid;
	
	/**
	 * 
	 */
	private Long chargeid;
	
	/**
	 * 
	 */
	private Date uploaddate;
	
	/**
	 * 
	 */
	private Float votage;
	
	/**
	 * 
	 */
	private Float current;
	
	/**
	 * 
	 */
	private Float power;
	
	/**
	 * 
	 */
	private Integer chargetime;
	
	/**
	 * 
	 */
	private Integer remaintime;
	
	/**
	 * 
	 */
	private Integer pricemode;
	
	/**
	 * 
	 */
	private Float realcost;
	
    /**
     * ScUploadEntity constructor
     */
	public ScUploadEntity() {
		super();
	}

    /**
     * setter for uploadid
     * @param uploadid
     */
	public void setUploadid(Long uploadid) {
		this.uploadid = uploadid;
	}

    /**
     * getter for uploadid
     */
	public Long getUploadid() {
		return uploadid;
	}

    /**
     * setter for outletid
     * @param outletid
     */
	public void setOutletid(String outletid) {
		this.outletid = outletid;
	}

    /**
     * getter for outletid
     */
	public String getOutletid() {
		return outletid;
	}

    /**
     * setter for serialid
     * @param serialid
     */
	public void setSerialid(Integer serialid) {
		this.serialid = serialid;
	}

    /**
     * getter for serialid
     */
	public Integer getSerialid() {
		return serialid;
	}

    /**
     * setter for chargeid
     * @param chargeid
     */
	public void setChargeid(Long chargeid) {
		this.chargeid = chargeid;
	}

    /**
     * getter for chargeid
     */
	public Long getChargeid() {
		return chargeid;
	}

    /**
     * setter for uploaddate
     * @param uploaddate
     */
	public void setUploaddate(Date uploaddate) {
		this.uploaddate = uploaddate;
	}

    /**
     * getter for uploaddate
     */
	public Date getUploaddate() {
		return uploaddate;
	}

    /**
     * setter for votage
     * @param votage
     */
	public void setVotage(Float votage) {
		this.votage = votage;
	}

    /**
     * getter for votage
     */
	public Float getVotage() {
		return votage;
	}

    /**
     * setter for current
     * @param current
     */
	public void setCurrent(Float current) {
		this.current = current;
	}

    /**
     * getter for current
     */
	public Float getCurrent() {
		return current;
	}

    /**
     * setter for power
     * @param power
     */
	public void setPower(Float power) {
		this.power = power;
	}

    /**
     * getter for power
     */
	public Float getPower() {
		return power;
	}

    /**
     * setter for chargetime
     * @param chargetime
     */
	public void setChargetime(Integer chargetime) {
		this.chargetime = chargetime;
	}

    /**
     * getter for chargetime
     */
	public Integer getChargetime() {
		return chargetime;
	}

    /**
     * setter for remaintime
     * @param remaintime
     */
	public void setRemaintime(Integer remaintime) {
		this.remaintime = remaintime;
	}

    /**
     * getter for remaintime
     */
	public Integer getRemaintime() {
		return remaintime;
	}

    /**
     * setter for pricemode
     * @param pricemode
     */
	public void setPricemode(Integer pricemode) {
		this.pricemode = pricemode;
	}

    /**
     * getter for pricemode
     */
	public Integer getPricemode() {
		return pricemode;
	}

    /**
     * setter for realcost
     * @param realcost
     */
	public void setRealcost(Float realcost) {
		this.realcost = realcost;
	}

    /**
     * getter for realcost
     */
	public Float getRealcost() {
		return realcost;
	}

    /**
     * ScUploadEntity.toString()
     */
    @Override
    public String toString() {
        return "ScUploadEntity{" +
               "uploadid='" + uploadid + '\'' +
               ", outletid='" + outletid + '\'' +
               ", serialid='" + serialid + '\'' +
               ", chargeid='" + chargeid + '\'' +
               ", uploaddate='" + uploaddate + '\'' +
               ", votage='" + votage + '\'' +
               ", current='" + current + '\'' +
               ", power='" + power + '\'' +
               ", chargetime='" + chargetime + '\'' +
               ", remaintime='" + remaintime + '\'' +
               ", pricemode='" + pricemode + '\'' +
               ", realcost='" + realcost + '\'' +
               '}';
    }

}
