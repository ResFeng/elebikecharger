package net.chenlin.dp.modules.sc.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public class ScChargeEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Long chargeid;
	
	/**
	 * 智能充电桩
	 */
	private String userid;
	
	/**
	 * 
	 */
	private String outletid;
	
	/**
	 * 
	 */
	private Integer serialid;
	
	/**
	 * 
	 */
	private Date chargedate;
	
	/**
	 * 
	 */
	private Integer mode;
	
	/**
	 * 
	 */
	private Integer currentstatus;
	
	/**
	 * 
	 */
	private Integer settingtime;
	
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
	private Float realcost;
	
	/**
	 * 
	 */
	private Float payment;
	
	/**
	 * 
	 */
	private Integer stoptype;
	
	/**
	 * 
	 */
	private Date enddate;
	
	/**
	 * 
	 */
	private Integer status;
	
	/**
	 * 
	 */
	private Integer havelooked;

	/**
	 *
	 */
	private String outletName;

	/**
	 *
	 */
	private int serialNum;

	/**
	 *
	 */
	private int chargeNum;
	
    /**
     * ScChargeEntity constructor
     */
	public ScChargeEntity() {
		super();
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
     * setter for userid
     * @param userid
     */
	public void setUserid(String userid) {
		this.userid = userid;
	}

    /**
     * getter for userid
     */
	public String getUserid() {
		return userid;
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
     * setter for chargedate
     * @param chargedate
     */
	public void setChargedate(Date chargedate) {
		this.chargedate = chargedate;
	}

    /**
     * getter for chargedate
     */
	public Date getChargedate() {
		return chargedate;
	}

    /**
     * setter for mode
     * @param mode
     */
	public void setMode(Integer mode) {
		this.mode = mode;
	}

    /**
     * getter for mode
     */
	public Integer getMode() {
		return mode;
	}

    /**
     * setter for currentstatus
     * @param currentstatus
     */
	public void setCurrentstatus(Integer currentstatus) {
		this.currentstatus = currentstatus;
	}

    /**
     * getter for currentstatus
     */
	public Integer getCurrentstatus() {
		return currentstatus;
	}

    /**
     * setter for settingtime
     * @param settingtime
     */
	public void setSettingtime(Integer settingtime) {
		this.settingtime = settingtime;
	}

    /**
     * getter for settingtime
     */
	public Integer getSettingtime() {
		return settingtime;
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
     * setter for payment
     * @param payment
     */
	public void setPayment(Float payment) {
		this.payment = payment;
	}

    /**
     * getter for payment
     */
	public Float getPayment() {
		return payment;
	}

    /**
     * setter for stoptype
     * @param stoptype
     */
	public void setStoptype(Integer stoptype) {
		this.stoptype = stoptype;
	}

    /**
     * getter for stoptype
     */
	public Integer getStoptype() {
		return stoptype;
	}

    /**
     * setter for enddate
     * @param enddate
     */
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

    /**
     * getter for enddate
     */
	public Date getEnddate() {
		return enddate;
	}

    /**
     * setter for status
     * @param status
     */
	public void setStatus(Integer status) {
		this.status = status;
	}

    /**
     * getter for status
     */
	public Integer getStatus() {
		return status;
	}

    /**
     * setter for havelooked
     * @param havelooked
     */
	public void setHavelooked(Integer havelooked) {
		this.havelooked = havelooked;
	}

    /**
     * getter for havelooked
     */
	public Integer getHavelooked() {
		return havelooked;
	}

	/**
	 *
	 */
	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}

	/**
	 *
	 */
	public int getSerialNum() {
		return serialNum;
	}

	/**
	 *
	 */
	public void setOutletName(String outletName) {
		this.outletName = outletName;
	}

	/**
	 *
	 */
	public String getOutletName() {
		return outletName;
	}

	/**
	 *
	 */
	public int getChargeNum() {
		return chargeNum;
	}

	/**
	 *
	 */
	public void setChargeNum(int chargeNum) {
		this.chargeNum = chargeNum;
	}

	/**
     * ScChargeEntity.toString()
     */
    @Override
    public String toString() {
        return "ScChargeEntity{" +
               "chargeid='" + chargeid + '\'' +
               ", userid='" + userid + '\'' +
               ", outletid='" + outletid + '\'' +
               ", serialid='" + serialid + '\'' +
               ", chargedate='" + chargedate + '\'' +
               ", mode='" + mode + '\'' +
               ", currentstatus='" + currentstatus + '\'' +
               ", settingtime='" + settingtime + '\'' +
               ", chargetime='" + chargetime + '\'' +
               ", remaintime='" + remaintime + '\'' +
               ", realcost='" + realcost + '\'' +
               ", payment='" + payment + '\'' +
               ", stoptype='" + stoptype + '\'' +
               ", enddate='" + enddate + '\'' +
               ", status='" + status + '\'' +
               ", havelooked='" + havelooked + '\'' +
               '}';
    }

}
