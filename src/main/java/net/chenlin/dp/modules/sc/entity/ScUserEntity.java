package net.chenlin.dp.modules.sc.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ScUserEntity {

    private static final long serialVersionUID = 1L;

    private Long UserId;

    private String username;

    private String mobile;

    private String password;

    private BigDecimal account;

    private String openid;

    private Date createtime;

    public Long getUserId() {
        return UserId;
    }

    public String getUsername() {
        return username;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }

    public BigDecimal getAccount() {
        return account;
    }

    public String getOpenid() {
        return openid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setUserId(Long userId) {
        this.UserId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
