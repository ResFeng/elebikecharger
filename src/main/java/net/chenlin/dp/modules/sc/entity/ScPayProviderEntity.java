package net.chenlin.dp.modules.sc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ScPayProviderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private int Id;

    private String providerId;

    private String payMonth;

    private Date payDate;

    private String randomString;

    private BigDecimal Amount;

    private int paymentType;

    private String openId;

    private String accountName;

    private String providerName;

    private String bankAccount;

    private String bankCode;

    private String paymentStatus;

    private String remark;

    private String ip;

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getPayDate() {
        return payDate;
    }

    public int getId() {
        return Id;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPayMonth() {
        return payMonth;
    }

    public String getRandomString() {
        return randomString;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPayMonth(String payMonth) {
        this.payMonth = payMonth;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public String getIp() {
        return ip;
    }

    public String getOpenId() {
        return openId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
