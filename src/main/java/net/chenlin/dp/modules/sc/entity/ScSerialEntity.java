package net.chenlin.dp.modules.sc.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public class ScSerialEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Long id;
	
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
	private Integer status;
	
    /**
     * ScSerialEntity constructor
     */
	public ScSerialEntity() {
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
     * ScSerialEntity.toString()
     */
    @Override
    public String toString() {
        return "ScSerialEntity{" +
               "id='" + id + '\'' +
               ", outletid='" + outletid + '\'' +
               ", serialid='" + serialid + '\'' +
               ", status='" + status + '\'' +
               '}';
    }

}
