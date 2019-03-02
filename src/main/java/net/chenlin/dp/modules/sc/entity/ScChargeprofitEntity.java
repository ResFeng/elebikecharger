package net.chenlin.dp.modules.sc.entity;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;


/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public class ScChargeprofitEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Long id;
	
	/**
	 * 
	 */
	private String chargedate;
	
	/**
	 * 
	 */
	private String outletid;
	
	/**
	 * 
	 */
	private BigDecimal profits;
	
	/**
	 * 
	 */
	private Integer chargenum;
	
	/**
	 * 
	 */
	private BigDecimal powerconsumption;
	
	/**
	 * 
	 */
	private BigDecimal distprofits;
	
    /**
     * ScChargeprofitEntity constructor
     */
	public ScChargeprofitEntity() {
		super();
	}

    /**
     * setter for id
     * @param id
     */
	public void setId(Long id) {
		this.id = id;
	}

    /**
     * getter for id
     */
	public Long getId() {
		return id;
	}

    /**
     * setter for chargedate
     * @param chargedate
     */
	public void setChargedate(String chargedate) {
		this.chargedate = chargedate;
	}

    /**
     * getter for chargedate
     */
	public String getChargedate() {
		return chargedate;
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
     * setter for profits
     * @param profits
     */
	public void setProfits(BigDecimal profits) {
		this.profits = profits;
	}

    /**
     * getter for profits
     */
	public BigDecimal getProfits() {
		return profits;
	}

    /**
     * setter for chargenum
     * @param chargenum
     */
	public void setChargenum(Integer chargenum) {
		this.chargenum = chargenum;
	}

    /**
     * getter for chargenum
     */
	public Integer getChargenum() {
		return chargenum;
	}

    /**
     * setter for powerconsumption
     * @param powerconsumption
     */
	public void setPowerconsumption(BigDecimal powerconsumption) {
		this.powerconsumption = powerconsumption;
	}

    /**
     * getter for powerconsumption
     */
	public BigDecimal getPowerconsumption() {
		return powerconsumption;
	}

    /**
     * setter for distprofits
     * @param distprofits
     */
	public void setDistprofits(BigDecimal distprofits) {
		this.distprofits = distprofits;
	}

    /**
     * getter for distprofits
     */
	public BigDecimal getDistprofits() {
		return distprofits;
	}

    /**
     * ScChargeprofitEntity.toString()
     */
    @Override
    public String toString() {
        return "ScChargeprofitEntity{" +
               "id='" + id + '\'' +
               ", chargedate='" + chargedate + '\'' +
               ", outletid='" + outletid + '\'' +
               ", profits='" + profits + '\'' +
               ", chargenum='" + chargenum + '\'' +
               ", powerconsumption='" + powerconsumption + '\'' +
               ", distprofits='" + distprofits + '\'' +
               '}';
    }

}