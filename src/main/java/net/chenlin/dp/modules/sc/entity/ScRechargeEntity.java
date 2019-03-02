package net.chenlin.dp.modules.sc.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public class ScRechargeEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Long rechargeid;
	
	/**
	 * 
	 */
	private String userid;
	
	/**
	 * 
	 */
	private Date rechargedate;
	
	/**
	 * 
	 */
	private Float amount;
	
	/**
	 * 
	 */
	private Integer mode;
	
	/**
	 * 
	 */
	private String transactionid;
	
	/**
	 * 
	 */
	private String timeend;
	
    /**
     * ScRechargeEntity constructor
     */
	public ScRechargeEntity() {
		super();
	}

    /**
     * setter for rechargeid
     * @param rechargeid
     */
	public void setRechargeid(Long rechargeid) {
		this.rechargeid = rechargeid;
	}

    /**
     * getter for rechargeid
     */
	public Long getRechargeid() {
		return rechargeid;
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
     * setter for rechargedate
     * @param rechargedate
     */
	public void setRechargedate(Date rechargedate) {
		this.rechargedate = rechargedate;
	}

    /**
     * getter for rechargedate
     */
	public Date getRechargedate() {
		return rechargedate;
	}

    /**
     * setter for amount
     * @param amount
     */
	public void setAmount(Float amount) {
		this.amount = amount;
	}

    /**
     * getter for amount
     */
	public Float getAmount() {
		return amount;
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
     * setter for transactionid
     * @param transactionid
     */
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

    /**
     * getter for transactionid
     */
	public String getTransactionid() {
		return transactionid;
	}

    /**
     * setter for timeend
     * @param timeend
     */
	public void setTimeend(String timeend) {
		this.timeend = timeend;
	}

    /**
     * getter for timeend
     */
	public String getTimeend() {
		return timeend;
	}

    /**
     * ScRechargeEntity.toString()
     */
    @Override
    public String toString() {
        return "ScRechargeEntity{" +
               "rechargeid='" + rechargeid + '\'' +
               ", userid='" + userid + '\'' +
               ", rechargedate='" + rechargedate + '\'' +
               ", amount='" + amount + '\'' +
               ", mode='" + mode + '\'' +
               ", transactionid='" + transactionid + '\'' +
               ", timeend='" + timeend + '\'' +
               '}';
    }

}
