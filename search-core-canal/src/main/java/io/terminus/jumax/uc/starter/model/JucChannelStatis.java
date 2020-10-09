package io.terminus.jumax.uc.starter.model;

import java.util.Date;

public class JucChannelStatis {
    private Long id;

    private Long userId;

    private String name;

    private Integer todayTotal;

    private Integer historyTotal;

    private Long channelId;

    private String channelName;

    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getTodayTotal() {
        return todayTotal;
    }

    public void setTodayTotal(Integer todayTotal) {
        this.todayTotal = todayTotal;
    }

    public Integer getHistoryTotal() {
        return historyTotal;
    }

    public void setHistoryTotal(Integer historyTotal) {
        this.historyTotal = historyTotal;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}