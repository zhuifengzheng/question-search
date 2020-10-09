package io.terminus.jumax.uc.starter.model;

import java.util.Date;

public class InviteActivityDayStatistics {
    private Long inviteActivityDayStatisticsId;

    private Long tenantId;

    private Long inviteActivityId;

    private String date;

    private Long inviterId;

    private String inviterPhone;

    private String inviterName;

    private Byte userType;

    private Integer inviteAmount;

    private Long reward;

    private Integer version;

    private String extraJson;

    private Date createdAt;

    private Date updatedAt;

    public Long getInviteActivityDayStatisticsId() {
        return inviteActivityDayStatisticsId;
    }

    public void setInviteActivityDayStatisticsId(Long inviteActivityDayStatisticsId) {
        this.inviteActivityDayStatisticsId = inviteActivityDayStatisticsId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getInviteActivityId() {
        return inviteActivityId;
    }

    public void setInviteActivityId(Long inviteActivityId) {
        this.inviteActivityId = inviteActivityId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public Long getInviterId() {
        return inviterId;
    }

    public void setInviterId(Long inviterId) {
        this.inviterId = inviterId;
    }

    public String getInviterPhone() {
        return inviterPhone;
    }

    public void setInviterPhone(String inviterPhone) {
        this.inviterPhone = inviterPhone == null ? null : inviterPhone.trim();
    }

    public String getInviterName() {
        return inviterName;
    }

    public void setInviterName(String inviterName) {
        this.inviterName = inviterName == null ? null : inviterName.trim();
    }

    public Byte getUserType() {
        return userType;
    }

    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    public Integer getInviteAmount() {
        return inviteAmount;
    }

    public void setInviteAmount(Integer inviteAmount) {
        this.inviteAmount = inviteAmount;
    }

    public Long getReward() {
        return reward;
    }

    public void setReward(Long reward) {
        this.reward = reward;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getExtraJson() {
        return extraJson;
    }

    public void setExtraJson(String extraJson) {
        this.extraJson = extraJson == null ? null : extraJson.trim();
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
}