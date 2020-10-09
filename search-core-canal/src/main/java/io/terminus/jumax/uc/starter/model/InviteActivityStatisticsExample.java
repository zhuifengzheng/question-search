package io.terminus.jumax.uc.starter.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InviteActivityStatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InviteActivityStatisticsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andInviteActivityStatisticsIdIsNull() {
            addCriterion("invite_activity_statistics_id is null");
            return (Criteria) this;
        }

        public Criteria andInviteActivityStatisticsIdIsNotNull() {
            addCriterion("invite_activity_statistics_id is not null");
            return (Criteria) this;
        }

        public Criteria andInviteActivityStatisticsIdEqualTo(Long value) {
            addCriterion("invite_activity_statistics_id =", value, "inviteActivityStatisticsId");
            return (Criteria) this;
        }

        public Criteria andInviteActivityStatisticsIdNotEqualTo(Long value) {
            addCriterion("invite_activity_statistics_id <>", value, "inviteActivityStatisticsId");
            return (Criteria) this;
        }

        public Criteria andInviteActivityStatisticsIdGreaterThan(Long value) {
            addCriterion("invite_activity_statistics_id >", value, "inviteActivityStatisticsId");
            return (Criteria) this;
        }

        public Criteria andInviteActivityStatisticsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("invite_activity_statistics_id >=", value, "inviteActivityStatisticsId");
            return (Criteria) this;
        }

        public Criteria andInviteActivityStatisticsIdLessThan(Long value) {
            addCriterion("invite_activity_statistics_id <", value, "inviteActivityStatisticsId");
            return (Criteria) this;
        }

        public Criteria andInviteActivityStatisticsIdLessThanOrEqualTo(Long value) {
            addCriterion("invite_activity_statistics_id <=", value, "inviteActivityStatisticsId");
            return (Criteria) this;
        }

        public Criteria andInviteActivityStatisticsIdIn(List<Long> values) {
            addCriterion("invite_activity_statistics_id in", values, "inviteActivityStatisticsId");
            return (Criteria) this;
        }

        public Criteria andInviteActivityStatisticsIdNotIn(List<Long> values) {
            addCriterion("invite_activity_statistics_id not in", values, "inviteActivityStatisticsId");
            return (Criteria) this;
        }

        public Criteria andInviteActivityStatisticsIdBetween(Long value1, Long value2) {
            addCriterion("invite_activity_statistics_id between", value1, value2, "inviteActivityStatisticsId");
            return (Criteria) this;
        }

        public Criteria andInviteActivityStatisticsIdNotBetween(Long value1, Long value2) {
            addCriterion("invite_activity_statistics_id not between", value1, value2, "inviteActivityStatisticsId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(Long value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(Long value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(Long value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(Long value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(Long value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<Long> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<Long> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(Long value1, Long value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(Long value1, Long value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andInviteActivityIdIsNull() {
            addCriterion("invite_activity_id is null");
            return (Criteria) this;
        }

        public Criteria andInviteActivityIdIsNotNull() {
            addCriterion("invite_activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andInviteActivityIdEqualTo(Long value) {
            addCriterion("invite_activity_id =", value, "inviteActivityId");
            return (Criteria) this;
        }

        public Criteria andInviteActivityIdNotEqualTo(Long value) {
            addCriterion("invite_activity_id <>", value, "inviteActivityId");
            return (Criteria) this;
        }

        public Criteria andInviteActivityIdGreaterThan(Long value) {
            addCriterion("invite_activity_id >", value, "inviteActivityId");
            return (Criteria) this;
        }

        public Criteria andInviteActivityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("invite_activity_id >=", value, "inviteActivityId");
            return (Criteria) this;
        }

        public Criteria andInviteActivityIdLessThan(Long value) {
            addCriterion("invite_activity_id <", value, "inviteActivityId");
            return (Criteria) this;
        }

        public Criteria andInviteActivityIdLessThanOrEqualTo(Long value) {
            addCriterion("invite_activity_id <=", value, "inviteActivityId");
            return (Criteria) this;
        }

        public Criteria andInviteActivityIdIn(List<Long> values) {
            addCriterion("invite_activity_id in", values, "inviteActivityId");
            return (Criteria) this;
        }

        public Criteria andInviteActivityIdNotIn(List<Long> values) {
            addCriterion("invite_activity_id not in", values, "inviteActivityId");
            return (Criteria) this;
        }

        public Criteria andInviteActivityIdBetween(Long value1, Long value2) {
            addCriterion("invite_activity_id between", value1, value2, "inviteActivityId");
            return (Criteria) this;
        }

        public Criteria andInviteActivityIdNotBetween(Long value1, Long value2) {
            addCriterion("invite_activity_id not between", value1, value2, "inviteActivityId");
            return (Criteria) this;
        }

        public Criteria andInviterIdIsNull() {
            addCriterion("inviter_id is null");
            return (Criteria) this;
        }

        public Criteria andInviterIdIsNotNull() {
            addCriterion("inviter_id is not null");
            return (Criteria) this;
        }

        public Criteria andInviterIdEqualTo(Long value) {
            addCriterion("inviter_id =", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdNotEqualTo(Long value) {
            addCriterion("inviter_id <>", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdGreaterThan(Long value) {
            addCriterion("inviter_id >", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("inviter_id >=", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdLessThan(Long value) {
            addCriterion("inviter_id <", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdLessThanOrEqualTo(Long value) {
            addCriterion("inviter_id <=", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdIn(List<Long> values) {
            addCriterion("inviter_id in", values, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdNotIn(List<Long> values) {
            addCriterion("inviter_id not in", values, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdBetween(Long value1, Long value2) {
            addCriterion("inviter_id between", value1, value2, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdNotBetween(Long value1, Long value2) {
            addCriterion("inviter_id not between", value1, value2, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterPhoneIsNull() {
            addCriterion("inviter_phone is null");
            return (Criteria) this;
        }

        public Criteria andInviterPhoneIsNotNull() {
            addCriterion("inviter_phone is not null");
            return (Criteria) this;
        }

        public Criteria andInviterPhoneEqualTo(String value) {
            addCriterion("inviter_phone =", value, "inviterPhone");
            return (Criteria) this;
        }

        public Criteria andInviterPhoneNotEqualTo(String value) {
            addCriterion("inviter_phone <>", value, "inviterPhone");
            return (Criteria) this;
        }

        public Criteria andInviterPhoneGreaterThan(String value) {
            addCriterion("inviter_phone >", value, "inviterPhone");
            return (Criteria) this;
        }

        public Criteria andInviterPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("inviter_phone >=", value, "inviterPhone");
            return (Criteria) this;
        }

        public Criteria andInviterPhoneLessThan(String value) {
            addCriterion("inviter_phone <", value, "inviterPhone");
            return (Criteria) this;
        }

        public Criteria andInviterPhoneLessThanOrEqualTo(String value) {
            addCriterion("inviter_phone <=", value, "inviterPhone");
            return (Criteria) this;
        }

        public Criteria andInviterPhoneLike(String value) {
            addCriterion("inviter_phone like", value, "inviterPhone");
            return (Criteria) this;
        }

        public Criteria andInviterPhoneNotLike(String value) {
            addCriterion("inviter_phone not like", value, "inviterPhone");
            return (Criteria) this;
        }

        public Criteria andInviterPhoneIn(List<String> values) {
            addCriterion("inviter_phone in", values, "inviterPhone");
            return (Criteria) this;
        }

        public Criteria andInviterPhoneNotIn(List<String> values) {
            addCriterion("inviter_phone not in", values, "inviterPhone");
            return (Criteria) this;
        }

        public Criteria andInviterPhoneBetween(String value1, String value2) {
            addCriterion("inviter_phone between", value1, value2, "inviterPhone");
            return (Criteria) this;
        }

        public Criteria andInviterPhoneNotBetween(String value1, String value2) {
            addCriterion("inviter_phone not between", value1, value2, "inviterPhone");
            return (Criteria) this;
        }

        public Criteria andInviterNameIsNull() {
            addCriterion("inviter_name is null");
            return (Criteria) this;
        }

        public Criteria andInviterNameIsNotNull() {
            addCriterion("inviter_name is not null");
            return (Criteria) this;
        }

        public Criteria andInviterNameEqualTo(String value) {
            addCriterion("inviter_name =", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameNotEqualTo(String value) {
            addCriterion("inviter_name <>", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameGreaterThan(String value) {
            addCriterion("inviter_name >", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameGreaterThanOrEqualTo(String value) {
            addCriterion("inviter_name >=", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameLessThan(String value) {
            addCriterion("inviter_name <", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameLessThanOrEqualTo(String value) {
            addCriterion("inviter_name <=", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameLike(String value) {
            addCriterion("inviter_name like", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameNotLike(String value) {
            addCriterion("inviter_name not like", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameIn(List<String> values) {
            addCriterion("inviter_name in", values, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameNotIn(List<String> values) {
            addCriterion("inviter_name not in", values, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameBetween(String value1, String value2) {
            addCriterion("inviter_name between", value1, value2, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameNotBetween(String value1, String value2) {
            addCriterion("inviter_name not between", value1, value2, "inviterName");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(Byte value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(Byte value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(Byte value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(Byte value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(Byte value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<Byte> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<Byte> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(Byte value1, Byte value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andInviteAmountIsNull() {
            addCriterion("invite_amount is null");
            return (Criteria) this;
        }

        public Criteria andInviteAmountIsNotNull() {
            addCriterion("invite_amount is not null");
            return (Criteria) this;
        }

        public Criteria andInviteAmountEqualTo(Integer value) {
            addCriterion("invite_amount =", value, "inviteAmount");
            return (Criteria) this;
        }

        public Criteria andInviteAmountNotEqualTo(Integer value) {
            addCriterion("invite_amount <>", value, "inviteAmount");
            return (Criteria) this;
        }

        public Criteria andInviteAmountGreaterThan(Integer value) {
            addCriterion("invite_amount >", value, "inviteAmount");
            return (Criteria) this;
        }

        public Criteria andInviteAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("invite_amount >=", value, "inviteAmount");
            return (Criteria) this;
        }

        public Criteria andInviteAmountLessThan(Integer value) {
            addCriterion("invite_amount <", value, "inviteAmount");
            return (Criteria) this;
        }

        public Criteria andInviteAmountLessThanOrEqualTo(Integer value) {
            addCriterion("invite_amount <=", value, "inviteAmount");
            return (Criteria) this;
        }

        public Criteria andInviteAmountIn(List<Integer> values) {
            addCriterion("invite_amount in", values, "inviteAmount");
            return (Criteria) this;
        }

        public Criteria andInviteAmountNotIn(List<Integer> values) {
            addCriterion("invite_amount not in", values, "inviteAmount");
            return (Criteria) this;
        }

        public Criteria andInviteAmountBetween(Integer value1, Integer value2) {
            addCriterion("invite_amount between", value1, value2, "inviteAmount");
            return (Criteria) this;
        }

        public Criteria andInviteAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("invite_amount not between", value1, value2, "inviteAmount");
            return (Criteria) this;
        }

        public Criteria andRewardIsNull() {
            addCriterion("reward is null");
            return (Criteria) this;
        }

        public Criteria andRewardIsNotNull() {
            addCriterion("reward is not null");
            return (Criteria) this;
        }

        public Criteria andRewardEqualTo(Long value) {
            addCriterion("reward =", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotEqualTo(Long value) {
            addCriterion("reward <>", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardGreaterThan(Long value) {
            addCriterion("reward >", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardGreaterThanOrEqualTo(Long value) {
            addCriterion("reward >=", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardLessThan(Long value) {
            addCriterion("reward <", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardLessThanOrEqualTo(Long value) {
            addCriterion("reward <=", value, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardIn(List<Long> values) {
            addCriterion("reward in", values, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotIn(List<Long> values) {
            addCriterion("reward not in", values, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardBetween(Long value1, Long value2) {
            addCriterion("reward between", value1, value2, "reward");
            return (Criteria) this;
        }

        public Criteria andRewardNotBetween(Long value1, Long value2) {
            addCriterion("reward not between", value1, value2, "reward");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andExtraJsonIsNull() {
            addCriterion("extra_json is null");
            return (Criteria) this;
        }

        public Criteria andExtraJsonIsNotNull() {
            addCriterion("extra_json is not null");
            return (Criteria) this;
        }

        public Criteria andExtraJsonEqualTo(String value) {
            addCriterion("extra_json =", value, "extraJson");
            return (Criteria) this;
        }

        public Criteria andExtraJsonNotEqualTo(String value) {
            addCriterion("extra_json <>", value, "extraJson");
            return (Criteria) this;
        }

        public Criteria andExtraJsonGreaterThan(String value) {
            addCriterion("extra_json >", value, "extraJson");
            return (Criteria) this;
        }

        public Criteria andExtraJsonGreaterThanOrEqualTo(String value) {
            addCriterion("extra_json >=", value, "extraJson");
            return (Criteria) this;
        }

        public Criteria andExtraJsonLessThan(String value) {
            addCriterion("extra_json <", value, "extraJson");
            return (Criteria) this;
        }

        public Criteria andExtraJsonLessThanOrEqualTo(String value) {
            addCriterion("extra_json <=", value, "extraJson");
            return (Criteria) this;
        }

        public Criteria andExtraJsonLike(String value) {
            addCriterion("extra_json like", value, "extraJson");
            return (Criteria) this;
        }

        public Criteria andExtraJsonNotLike(String value) {
            addCriterion("extra_json not like", value, "extraJson");
            return (Criteria) this;
        }

        public Criteria andExtraJsonIn(List<String> values) {
            addCriterion("extra_json in", values, "extraJson");
            return (Criteria) this;
        }

        public Criteria andExtraJsonNotIn(List<String> values) {
            addCriterion("extra_json not in", values, "extraJson");
            return (Criteria) this;
        }

        public Criteria andExtraJsonBetween(String value1, String value2) {
            addCriterion("extra_json between", value1, value2, "extraJson");
            return (Criteria) this;
        }

        public Criteria andExtraJsonNotBetween(String value1, String value2) {
            addCriterion("extra_json not between", value1, value2, "extraJson");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}