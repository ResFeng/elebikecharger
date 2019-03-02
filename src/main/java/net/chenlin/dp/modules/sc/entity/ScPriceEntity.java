package net.chenlin.dp.modules.sc.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public class ScPriceEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 智能充电桩
	 */
	private Integer pricemode;
	
	/**
	 * 
	 */
	private Integer range;
	
	/**
	 * 
	 */
	private Float powerfrom;
	
	/**
	 * 
	 */
	private Float powerto;
	
	/**
	 * 
	 */
	private Float price;
	
    /**
     * ScPriceEntity constructor
     */
	public ScPriceEntity() {
		super();
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
     * setter for range
     * @param range
     */
	public void setRange(Integer range) {
		this.range = range;
	}

    /**
     * getter for range
     */
	public Integer getRange() {
		return range;
	}

    /**
     * setter for powerfrom
     * @param powerfrom
     */
	public void setPowerfrom(Float powerfrom) {
		this.powerfrom = powerfrom;
	}

    /**
     * getter for powerfrom
     */
	public Float getPowerfrom() {
		return powerfrom;
	}

    /**
     * setter for powerto
     * @param powerto
     */
	public void setPowerto(Float powerto) {
		this.powerto = powerto;
	}

    /**
     * getter for powerto
     */
	public Float getPowerto() {
		return powerto;
	}

    /**
     * setter for price
     * @param price
     */
	public void setPrice(Float price) {
		this.price = price;
	}

    /**
     * getter for price
     */
	public Float getPrice() {
		return price;
	}

    /**
     * ScPriceEntity.toString()
     */
    @Override
    public String toString() {
        return "ScPriceEntity{" +
               "pricemode='" + pricemode + '\'' +
               ", range='" + range + '\'' +
               ", powerfrom='" + powerfrom + '\'' +
               ", powerto='" + powerto + '\'' +
               ", price='" + price + '\'' +
               '}';
    }

}
