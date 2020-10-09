package io.terminus.jumax.uc.starter.model;

import java.util.Date;

public class UcUser {
    private Long id;

    private Long pk;

    private Integer tenantId;

    private String username;

    private String nickname;

    private String avatar;

    private String mobile;

    private String email;

    private String password;

    private Date pwdExpireAt;

    private Boolean enabled;

    private Boolean locked;

    private Boolean deleted;

    private String channel;

    private String channelType;

    private String source;

    private String sourceType;

    private String tag;

    private Integer version;

    private String extra;

    private String updatedBy;

    private Date lastLoginAt;

    private Date createdAt;

    private Date updatedAt;

    private Boolean recordUpdateMsg;

    private Boolean recordCreateMsg;

    private Long userIdThird;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getPwdExpireAt() {
        return pwdExpireAt;
    }

    public void setPwdExpireAt(Date pwdExpireAt) {
        this.pwdExpireAt = pwdExpireAt;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType == null ? null : channelType.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra == null ? null : extra.trim();
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Date getLastLoginAt() {
        return lastLoginAt;
    }

    public void setLastLoginAt(Date lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getRecordUpdateMsg() {
        return recordUpdateMsg;
    }

    public void setRecordUpdateMsg(Boolean recordUpdateMsg) {
        this.recordUpdateMsg = recordUpdateMsg;
    }

    public Boolean getRecordCreateMsg() {
        return recordCreateMsg;
    }

    public void setRecordCreateMsg(Boolean recordCreateMsg) {
        this.recordCreateMsg = recordCreateMsg;
    }

    public Long getUserIdThird() {
        return userIdThird;
    }

    public void setUserIdThird(Long userIdThird) {
        this.userIdThird = userIdThird;
    }
}