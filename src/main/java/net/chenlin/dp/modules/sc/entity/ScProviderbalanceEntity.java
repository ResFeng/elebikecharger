package net.chenlin.dp.modules.sc.entity;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;


/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public class ScProviderbalanceEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private String balanceid;
	
	/**
	 * 
	 */
	private String providerid;
	
	/**
	 * 
	 */
	private Date balancedate;
	
	/**
	 * 
	 */
	private String operator;
	
	/**
	 * 
	 */
	private BigDecimal amount;
	
	/**
	 * 
	 */
	private String paymenttype;
	
	/**
	 * 
	 */
	private String openid;
	
	/**
	 * 
	 */
	private String accountname;
	
	/**
	 * 
	 */
	private BigDecimal paymentamount;
	
	/**
	 * 
	 */
	private Integer paymentratio;
	
	/**
	 * 
	 */
	private Integer paymentstatus;
	
	/**
	 * 
	 */
	private String paymentid;
	
	/**
	 * 
	 */
	private Date paymentdate;
	
	/**
	 * 
	 */
	private String remark;
	
    /**
     * ScProviderbalanceEntity constructor
     */
	public ScProviderbalanceEntity() {
		super();
	}

    /**
     * setter for balanceid
     * @param balanceid
     */
	public void setBalanceid(String balanceid) {
		this.balanceid = balanceid;
	}

    /**
     * getter for balanceid
     */
	public String getBalanceid() {
		return balanceid;
	}

    /**
     * setter for providerid
     * @param providerid
     */
	public void setProviderid(String providerid) {
		this.providerid = providerid;
	}

    /**
     * getter for providerid
     */
	public String getProviderid() {
		return providerid;
	}

    /**
     * setter for balancedate
     * @param balancedate
     */
	public void setBalancedate(Date balancedate) {
		this.balancedate = balancedate;
	}

    /**
     * getter for balancedate
     */
	public Date getBalancedate() {
		return balancedate;
	}

    /**
     * setter for operator
     * @param operator
     */
	public void setOperator(String operator) {
		this.operator = operator;
	}

    /**
     * getter for operator
     */
	public String getOperator() {
		return operator;
	}

    /**
     * setter for amount
     * @param amount
     */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

    /**
     * getter for amount
     */
	public BigDecimal getAmount() {
		return amount;
	}

    /**
     * setter for paymenttype
     * @param paymenttype
     */
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

    /**
     * getter for paymenttype
     */
	public String getPaymenttype() {
		return paymenttype;
	}

    /**
     * setter for openid
     * @param openid
     */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

    /**
     * getter for openid
     */
	public String getOpenid() {
		return openid;
	}

    /**
     * setter for accountname
     * @param accountname
     */
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

    /**
     * getter for accountname
     */
	public String getAccountname() {
		return accountname;
	}

    /**
     * setter for paymentamount
     * @param paymentamount
     */
	public void setPaymentamount(BigDecimal paymentamount) {
		this.paymentamount = paymentamount;
	}

    /**
     * getter for paymentamount
     */
	public BigDecimal getPaymentamount() {
		return paymentamount;
	}

    /**
     * setter for paymentratio
     * @param paymentratio
     */
	public void setPaymentratio(Integer paymentratio) {
		this.paymentratio = paymentratio;
	}

    /**
     * getter for paymentratio
     */
	public Integer getPaymentratio() {
		return paymentratio;
	}

    /**
     * setter for paymentstatus
     * @param paymentstatus
     */
	public void setPaymentstatus(Integer paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

    /**
     * getter for paymentstatus
     */
	public Integer getPaymentstatus() {
		return paymentstatus;
	}

    /**
     * setter for paymentid
     * @param paymentid
     */
	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}

    /**
     * getter for paymentid
     */
	public String getPaymentid() {
		return paymentid;
	}

    /**
     * setter for paymentdate
     * @param paymentdate
     */
	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}

    /**
     * getter for paymentdate
     */
	public Date getPaymentdate() {
		return paymentdate;
	}

    /**
     * setter for remark
     * @param remark
     */
	public void setRemark(String remark) {
		this.remark = remark;
	}

    /**
     * getter for remark
     */
	public String getRemark() {
		return remark;
	}

    /**
     * ScProviderbalanceEntity.toString()
     */
    @Override
    public String toString() {
        return "ScProviderbalanceEntity{" +
               "balanceid='" + balanceid + '\'' +
               ", providerid='" + providerid + '\'' +
               ", balancedate='" + balancedate + '\'' +
               ", operator='" + operator + '\'' +
               ", amount='" + amount + '\'' +
               ", paymenttype='" + paymenttype + '\'' +
               ", openid='" + openid + '\'' +
               ", accountname='" + accountname + '\'' +
               ", paymentamount='" + paymentamount + '\'' +
               ", paymentratio='" + paymentratio + '\'' +
               ", paymentstatus='" + paymentstatus + '\'' +
               ", paymentid='" + paymentid + '\'' +
               ", paymentdate='" + paymentdate + '\'' +
               ", remark='" + remark + '\'' +
               '}';
    }

}
