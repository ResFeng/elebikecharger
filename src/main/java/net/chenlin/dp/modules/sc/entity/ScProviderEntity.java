package net.chenlin.dp.modules.sc.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public class ScProviderEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private Long id;
	
	/**
	 * 
	 */
	private String providerid;
	
	/**
	 * 
	 */
	private String providertype;
	
	/**
	 * 
	 */
	private String providername;

	private String providerfullname;
	
	/**
	 * 
	 */
	private Date joindate;
	
	/**
	 * 
	 */
	private String address;
	
	/**
	 * 
	 */
	private String province;
	
	/**
	 * 
	 */
	private String city;
	
	/**
	 * 
	 */
	private String area;
	
	/**
	 * 
	 */
	private String legal;
	
	/**
	 * 
	 */
	private String telephone;
	
	/**
	 * 
	 */
	private String wechatid;
	
	/**
	 * 
	 */
	private String openid;
	
	/**
	 * 
	 */
	private String citizenid;
	
	/**
	 * 
	 */
	private String email;
	
	/**
	 * 
	 */
	private String bank;
	
	/**
	 * 
	 */
	private String accountname;
	
	/**
	 * 
	 */
	private String account;
	
	/**
	 * 
	 */
	private Integer enable;
	
	/**
	 * 
	 */
	private String remark;
	
    /**
     * ScProviderEntity constructor
     */
	public ScProviderEntity() {
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
     * setter for providertype
     * @param providertype
     */
	public void setProvidertype(String providertype) {
		this.providertype = providertype;
	}

    /**
     * getter for providertype
     */
	public String getProvidertype() {
		return providertype;
	}

    /**
     * setter for providername
     * @param providername
     */
	public void setProvidername(String providername) {
		this.providername = providername;
	}

	public String getProviderfullname() {
		return providerfullname;
	}

	public void setProviderfullname(String providerfullname) {
		this.providerfullname = providerfullname;
	}

	/**
     * getter for providername
     */
	public String getProvidername() {
		return providername;
	}

    /**
     * setter for joindate
     * @param joindate
     */
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

    /**
     * getter for joindate
     */
	public Date getJoindate() {
		return joindate;
	}

    /**
     * setter for address
     * @param address
     */
	public void setAddress(String address) {
		this.address = address;
	}

    /**
     * getter for address
     */
	public String getAddress() {
		return address;
	}

    /**
     * setter for province
     * @param province
     */
	public void setProvince(String province) {
		this.province = province;
	}

    /**
     * getter for province
     */
	public String getProvince() {
		return province;
	}

    /**
     * setter for city
     * @param city
     */
	public void setCity(String city) {
		this.city = city;
	}

    /**
     * getter for city
     */
	public String getCity() {
		return city;
	}

    /**
     * setter for area
     * @param area
     */
	public void setArea(String area) {
		this.area = area;
	}

    /**
     * getter for area
     */
	public String getArea() {
		return area;
	}

    /**
     * setter for legal
     * @param legal
     */
	public void setLegal(String legal) {
		this.legal = legal;
	}

    /**
     * getter for legal
     */
	public String getLegal() {
		return legal;
	}

    /**
     * setter for telephone
     * @param telephone
     */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

    /**
     * getter for telephone
     */
	public String getTelephone() {
		return telephone;
	}

    /**
     * setter for wechatid
     * @param wechatid
     */
	public void setWechatid(String wechatid) {
		this.wechatid = wechatid;
	}

    /**
     * getter for wechatid
     */
	public String getWechatid() {
		return wechatid;
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
     * setter for citizenid
     * @param citizenid
     */
	public void setCitizenid(String citizenid) {
		this.citizenid = citizenid;
	}

    /**
     * getter for citizenid
     */
	public String getCitizenid() {
		return citizenid;
	}

    /**
     * setter for email
     * @param email
     */
	public void setEmail(String email) {
		this.email = email;
	}

    /**
     * getter for email
     */
	public String getEmail() {
		return email;
	}

    /**
     * setter for bank
     * @param bank
     */
	public void setBank(String bank) {
		this.bank = bank;
	}

    /**
     * getter for bank
     */
	public String getBank() {
		return bank;
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
     * setter for account
     * @param account
     */
	public void setAccount(String account) {
		this.account = account;
	}

    /**
     * getter for account
     */
	public String getAccount() {
		return account;
	}

    /**
     * setter for enable
     * @param enable
     */
	public void setEnable(Integer enable) {
		this.enable = enable;
	}

    /**
     * getter for enable
     */
	public Integer getEnable() {
		return enable;
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
     * ScProviderEntity.toString()
     */
    @Override
    public String toString() {
        return "ScProviderEntity{" +
               "id='" + id + '\'' +
               ", providerid='" + providerid + '\'' +
               ", providertype='" + providertype + '\'' +
               ", providername='" + providername + '\'' +
               ", joindate='" + joindate + '\'' +
               ", address='" + address + '\'' +
               ", province='" + province + '\'' +
               ", city='" + city + '\'' +
               ", area='" + area + '\'' +
               ", legal='" + legal + '\'' +
               ", telephone='" + telephone + '\'' +
               ", wechatid='" + wechatid + '\'' +
               ", openid='" + openid + '\'' +
               ", citizenid='" + citizenid + '\'' +
               ", email='" + email + '\'' +
               ", bank='" + bank + '\'' +
               ", accountname='" + accountname + '\'' +
               ", account='" + account + '\'' +
               ", enable='" + enable + '\'' +
               ", remark='" + remark + '\'' +
               '}';
    }

}
