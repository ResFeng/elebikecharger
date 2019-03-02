package net.chenlin.dp.modules.sc.entity;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;


/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public class ScOutletEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 智能充电桩
	 */
	private String outletid;
	
	/**
	 * 
	 */
	private String providerid;
	
	/**
	 * 
	 */
	private String outletname;
	
	/**
	 * 
	 */
	private String typeid;
	
	/**
	 * 
	 */
	private BigDecimal price;
	
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
	private String areaid;
	
	/**
	 * 
	 */
	private String serverid;
	
	/**
	 * 
	 */
	private String installationsite;
	
	/**
	 * 
	 */
	private BigDecimal longitude;
	
	/**
	 * 
	 */
	private BigDecimal latitude;
	
	/**
	 * 
	 */
	private Integer serialnumber;
	
	/**
	 * 
	 */
	private Integer pricemode;
	
	/**
	 * 
	 */
	private String describe;
	
	/**
	 * 
	 */
	private String ip;
	
	/**
	 * 
	 */
	private Integer serialnum;
	
	/**
	 * 
	 */
	private String session;
	
	/**
	 * 
	 */
	private String appkey;
	
	/**
	 * 
	 */
	private Integer isonline;
	
	/**
	 * 
	 */
	private Integer signalquality;
	
	/**
	 * 
	 */
	private Integer enable;
	
	/**
	 * 
	 */
	private String version;
	
	/**
	 * 
	 */
	private String iccid;
	
	/**
	 * 
	 */
	private Date enabledate;
	
	/**
	 * 
	 */
	private Date recoverdate;
	
	/**
	 * 
	 */
	private BigDecimal electricityprice;
	
	/**
	 * 
	 */
	private Integer distributionmode;
	
    /**
     * ScOutletEntity constructor
     */
	public ScOutletEntity() {
		super();
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
     * setter for outletname
     * @param outletname
     */
	public void setOutletname(String outletname) {
		this.outletname = outletname;
	}

    /**
     * getter for outletname
     */
	public String getOutletname() {
		return outletname;
	}

    /**
     * setter for typeid
     * @param typeid
     */
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

    /**
     * getter for typeid
     */
	public String getTypeid() {
		return typeid;
	}

    /**
     * setter for price
     * @param price
     */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

    /**
     * getter for price
     */
	public BigDecimal getPrice() {
		return price;
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
     * setter for areaid
     * @param areaid
     */
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

    /**
     * getter for areaid
     */
	public String getAreaid() {
		return areaid;
	}

    /**
     * setter for serverid
     * @param serverid
     */
	public void setServerid(String serverid) {
		this.serverid = serverid;
	}

    /**
     * getter for serverid
     */
	public String getServerid() {
		return serverid;
	}

    /**
     * setter for installationsite
     * @param installationsite
     */
	public void setInstallationsite(String installationsite) {
		this.installationsite = installationsite;
	}

    /**
     * getter for installationsite
     */
	public String getInstallationsite() {
		return installationsite;
	}

    /**
     * setter for longitude
     * @param longitude
     */
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

    /**
     * getter for longitude
     */
	public BigDecimal getLongitude() {
		return longitude;
	}

    /**
     * setter for latitude
     * @param latitude
     */
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

    /**
     * getter for latitude
     */
	public BigDecimal getLatitude() {
		return latitude;
	}

    /**
     * setter for serialnumber
     * @param serialnumber
     */
	public void setSerialnumber(Integer serialnumber) {
		this.serialnumber = serialnumber;
	}

    /**
     * getter for serialnumber
     */
	public Integer getSerialnumber() {
		return serialnumber;
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
     * setter for describe
     * @param describe
     */
	public void setDescribe(String describe) {
		this.describe = describe;
	}

    /**
     * getter for describe
     */
	public String getDescribe() {
		return describe;
	}

    /**
     * setter for ip
     * @param ip
     */
	public void setIp(String ip) {
		this.ip = ip;
	}

    /**
     * getter for ip
     */
	public String getIp() {
		return ip;
	}

    /**
     * setter for serialnum
     * @param serialnum
     */
	public void setSerialnum(Integer serialnum) {
		this.serialnum = serialnum;
	}

    /**
     * getter for serialnum
     */
	public Integer getSerialnum() {
		return serialnum;
	}

    /**
     * setter for session
     * @param session
     */
	public void setSession(String session) {
		this.session = session;
	}

    /**
     * getter for session
     */
	public String getSession() {
		return session;
	}

    /**
     * setter for appkey
     * @param appkey
     */
	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

    /**
     * getter for appkey
     */
	public String getAppkey() {
		return appkey;
	}

    /**
     * setter for isonline
     * @param isonline
     */
	public void setIsonline(Integer isonline) {
		this.isonline = isonline;
	}

    /**
     * getter for isonline
     */
	public Integer getIsonline() {
		return isonline;
	}

    /**
     * setter for signalquality
     * @param signalquality
     */
	public void setSignalquality(Integer signalquality) {
		this.signalquality = signalquality;
	}

    /**
     * getter for signalquality
     */
	public Integer getSignalquality() {
		return signalquality;
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
     * setter for version
     * @param version
     */
	public void setVersion(String version) {
		this.version = version;
	}

    /**
     * getter for version
     */
	public String getVersion() {
		return version;
	}

    /**
     * setter for iccid
     * @param iccid
     */
	public void setIccid(String iccid) {
		this.iccid = iccid;
	}

    /**
     * getter for iccid
     */
	public String getIccid() {
		return iccid;
	}

    /**
     * setter for enabledate
     * @param enabledate
     */
	public void setEnabledate(Date enabledate) {
		this.enabledate = enabledate;
	}

    /**
     * getter for enabledate
     */
	public Date getEnabledate() {
		return enabledate;
	}

    /**
     * setter for recoverdate
     * @param recoverdate
     */
	public void setRecoverdate(Date recoverdate) {
		this.recoverdate = recoverdate;
	}

    /**
     * getter for recoverdate
     */
	public Date getRecoverdate() {
		return recoverdate;
	}

    /**
     * setter for electricityprice
     * @param electricityprice
     */
	public void setElectricityprice(BigDecimal electricityprice) {
		this.electricityprice = electricityprice;
	}

    /**
     * getter for electricityprice
     */
	public BigDecimal getElectricityprice() {
		return electricityprice;
	}

    /**
     * setter for distributionmode
     * @param distributionmode
     */
	public void setDistributionmode(Integer distributionmode) {
		this.distributionmode = distributionmode;
	}

    /**
     * getter for distributionmode
     */
	public Integer getDistributionmode() {
		return distributionmode;
	}

    /**
     * ScOutletEntity.toString()
     */
    @Override
    public String toString() {
        return "ScOutletEntity{" +
               "outletid='" + outletid + '\'' +
               ", providerid='" + providerid + '\'' +
               ", outletname='" + outletname + '\'' +
               ", typeid='" + typeid + '\'' +
               ", price='" + price + '\'' +
               ", province='" + province + '\'' +
               ", city='" + city + '\'' +
               ", areaid='" + areaid + '\'' +
               ", serverid='" + serverid + '\'' +
               ", installationsite='" + installationsite + '\'' +
               ", longitude='" + longitude + '\'' +
               ", latitude='" + latitude + '\'' +
               ", serialnumber='" + serialnumber + '\'' +
               ", pricemode='" + pricemode + '\'' +
               ", describe='" + describe + '\'' +
               ", ip='" + ip + '\'' +
               ", serialnum='" + serialnum + '\'' +
               ", session='" + session + '\'' +
               ", appkey='" + appkey + '\'' +
               ", isonline='" + isonline + '\'' +
               ", signalquality='" + signalquality + '\'' +
               ", enable='" + enable + '\'' +
               ", version='" + version + '\'' +
               ", iccid='" + iccid + '\'' +
               ", enabledate='" + enabledate + '\'' +
               ", recoverdate='" + recoverdate + '\'' +
               ", electricityprice='" + electricityprice + '\'' +
               ", distributionmode='" + distributionmode + '\'' +
               '}';
    }

}
