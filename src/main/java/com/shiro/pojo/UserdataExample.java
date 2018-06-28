package com.shiro.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserdataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserdataExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUserstatusIsNull() {
            addCriterion("userStatus is null");
            return (Criteria) this;
        }

        public Criteria andUserstatusIsNotNull() {
            addCriterion("userStatus is not null");
            return (Criteria) this;
        }

        public Criteria andUserstatusEqualTo(Integer value) {
            addCriterion("userStatus =", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusNotEqualTo(Integer value) {
            addCriterion("userStatus <>", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusGreaterThan(Integer value) {
            addCriterion("userStatus >", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("userStatus >=", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusLessThan(Integer value) {
            addCriterion("userStatus <", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusLessThanOrEqualTo(Integer value) {
            addCriterion("userStatus <=", value, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusIn(List<Integer> values) {
            addCriterion("userStatus in", values, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusNotIn(List<Integer> values) {
            addCriterion("userStatus not in", values, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusBetween(Integer value1, Integer value2) {
            addCriterion("userStatus between", value1, value2, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUserstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("userStatus not between", value1, value2, "userstatus");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andUsersortIsNull() {
            addCriterion("userSort is null");
            return (Criteria) this;
        }

        public Criteria andUsersortIsNotNull() {
            addCriterion("userSort is not null");
            return (Criteria) this;
        }

        public Criteria andUsersortEqualTo(String value) {
            addCriterion("userSort =", value, "usersort");
            return (Criteria) this;
        }

        public Criteria andUsersortNotEqualTo(String value) {
            addCriterion("userSort <>", value, "usersort");
            return (Criteria) this;
        }

        public Criteria andUsersortGreaterThan(String value) {
            addCriterion("userSort >", value, "usersort");
            return (Criteria) this;
        }

        public Criteria andUsersortGreaterThanOrEqualTo(String value) {
            addCriterion("userSort >=", value, "usersort");
            return (Criteria) this;
        }

        public Criteria andUsersortLessThan(String value) {
            addCriterion("userSort <", value, "usersort");
            return (Criteria) this;
        }

        public Criteria andUsersortLessThanOrEqualTo(String value) {
            addCriterion("userSort <=", value, "usersort");
            return (Criteria) this;
        }

        public Criteria andUsersortLike(String value) {
            addCriterion("userSort like", value, "usersort");
            return (Criteria) this;
        }

        public Criteria andUsersortNotLike(String value) {
            addCriterion("userSort not like", value, "usersort");
            return (Criteria) this;
        }

        public Criteria andUsersortIn(List<String> values) {
            addCriterion("userSort in", values, "usersort");
            return (Criteria) this;
        }

        public Criteria andUsersortNotIn(List<String> values) {
            addCriterion("userSort not in", values, "usersort");
            return (Criteria) this;
        }

        public Criteria andUsersortBetween(String value1, String value2) {
            addCriterion("userSort between", value1, value2, "usersort");
            return (Criteria) this;
        }

        public Criteria andUsersortNotBetween(String value1, String value2) {
            addCriterion("userSort not between", value1, value2, "usersort");
            return (Criteria) this;
        }

        public Criteria andRegistertimeIsNull() {
            addCriterion("registerTime is null");
            return (Criteria) this;
        }

        public Criteria andRegistertimeIsNotNull() {
            addCriterion("registerTime is not null");
            return (Criteria) this;
        }

        public Criteria andRegistertimeEqualTo(String value) {
            addCriterion("registerTime =", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeNotEqualTo(String value) {
            addCriterion("registerTime <>", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeGreaterThan(String value) {
            addCriterion("registerTime >", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeGreaterThanOrEqualTo(String value) {
            addCriterion("registerTime >=", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeLessThan(String value) {
            addCriterion("registerTime <", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeLessThanOrEqualTo(String value) {
            addCriterion("registerTime <=", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeLike(String value) {
            addCriterion("registerTime like", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeNotLike(String value) {
            addCriterion("registerTime not like", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeIn(List<String> values) {
            addCriterion("registerTime in", values, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeNotIn(List<String> values) {
            addCriterion("registerTime not in", values, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeBetween(String value1, String value2) {
            addCriterion("registerTime between", value1, value2, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeNotBetween(String value1, String value2) {
            addCriterion("registerTime not between", value1, value2, "registertime");
            return (Criteria) this;
        }

        public Criteria andConnecttimeIsNull() {
            addCriterion("connectTime is null");
            return (Criteria) this;
        }

        public Criteria andConnecttimeIsNotNull() {
            addCriterion("connectTime is not null");
            return (Criteria) this;
        }

        public Criteria andConnecttimeEqualTo(String value) {
            addCriterion("connectTime =", value, "connecttime");
            return (Criteria) this;
        }

        public Criteria andConnecttimeNotEqualTo(String value) {
            addCriterion("connectTime <>", value, "connecttime");
            return (Criteria) this;
        }

        public Criteria andConnecttimeGreaterThan(String value) {
            addCriterion("connectTime >", value, "connecttime");
            return (Criteria) this;
        }

        public Criteria andConnecttimeGreaterThanOrEqualTo(String value) {
            addCriterion("connectTime >=", value, "connecttime");
            return (Criteria) this;
        }

        public Criteria andConnecttimeLessThan(String value) {
            addCriterion("connectTime <", value, "connecttime");
            return (Criteria) this;
        }

        public Criteria andConnecttimeLessThanOrEqualTo(String value) {
            addCriterion("connectTime <=", value, "connecttime");
            return (Criteria) this;
        }

        public Criteria andConnecttimeLike(String value) {
            addCriterion("connectTime like", value, "connecttime");
            return (Criteria) this;
        }

        public Criteria andConnecttimeNotLike(String value) {
            addCriterion("connectTime not like", value, "connecttime");
            return (Criteria) this;
        }

        public Criteria andConnecttimeIn(List<String> values) {
            addCriterion("connectTime in", values, "connecttime");
            return (Criteria) this;
        }

        public Criteria andConnecttimeNotIn(List<String> values) {
            addCriterion("connectTime not in", values, "connecttime");
            return (Criteria) this;
        }

        public Criteria andConnecttimeBetween(String value1, String value2) {
            addCriterion("connectTime between", value1, value2, "connecttime");
            return (Criteria) this;
        }

        public Criteria andConnecttimeNotBetween(String value1, String value2) {
            addCriterion("connectTime not between", value1, value2, "connecttime");
            return (Criteria) this;
        }

        public Criteria andUsertokenIsNull() {
            addCriterion("userToken is null");
            return (Criteria) this;
        }

        public Criteria andUsertokenIsNotNull() {
            addCriterion("userToken is not null");
            return (Criteria) this;
        }

        public Criteria andUsertokenEqualTo(String value) {
            addCriterion("userToken =", value, "usertoken");
            return (Criteria) this;
        }

        public Criteria andUsertokenNotEqualTo(String value) {
            addCriterion("userToken <>", value, "usertoken");
            return (Criteria) this;
        }

        public Criteria andUsertokenGreaterThan(String value) {
            addCriterion("userToken >", value, "usertoken");
            return (Criteria) this;
        }

        public Criteria andUsertokenGreaterThanOrEqualTo(String value) {
            addCriterion("userToken >=", value, "usertoken");
            return (Criteria) this;
        }

        public Criteria andUsertokenLessThan(String value) {
            addCriterion("userToken <", value, "usertoken");
            return (Criteria) this;
        }

        public Criteria andUsertokenLessThanOrEqualTo(String value) {
            addCriterion("userToken <=", value, "usertoken");
            return (Criteria) this;
        }

        public Criteria andUsertokenLike(String value) {
            addCriterion("userToken like", value, "usertoken");
            return (Criteria) this;
        }

        public Criteria andUsertokenNotLike(String value) {
            addCriterion("userToken not like", value, "usertoken");
            return (Criteria) this;
        }

        public Criteria andUsertokenIn(List<String> values) {
            addCriterion("userToken in", values, "usertoken");
            return (Criteria) this;
        }

        public Criteria andUsertokenNotIn(List<String> values) {
            addCriterion("userToken not in", values, "usertoken");
            return (Criteria) this;
        }

        public Criteria andUsertokenBetween(String value1, String value2) {
            addCriterion("userToken between", value1, value2, "usertoken");
            return (Criteria) this;
        }

        public Criteria andUsertokenNotBetween(String value1, String value2) {
            addCriterion("userToken not between", value1, value2, "usertoken");
            return (Criteria) this;
        }

        public Criteria andTokencreattimeIsNull() {
            addCriterion("tokenCreatTime is null");
            return (Criteria) this;
        }

        public Criteria andTokencreattimeIsNotNull() {
            addCriterion("tokenCreatTime is not null");
            return (Criteria) this;
        }

        public Criteria andTokencreattimeEqualTo(String value) {
            addCriterion("tokenCreatTime =", value, "tokencreattime");
            return (Criteria) this;
        }

        public Criteria andTokencreattimeNotEqualTo(String value) {
            addCriterion("tokenCreatTime <>", value, "tokencreattime");
            return (Criteria) this;
        }

        public Criteria andTokencreattimeGreaterThan(String value) {
            addCriterion("tokenCreatTime >", value, "tokencreattime");
            return (Criteria) this;
        }

        public Criteria andTokencreattimeGreaterThanOrEqualTo(String value) {
            addCriterion("tokenCreatTime >=", value, "tokencreattime");
            return (Criteria) this;
        }

        public Criteria andTokencreattimeLessThan(String value) {
            addCriterion("tokenCreatTime <", value, "tokencreattime");
            return (Criteria) this;
        }

        public Criteria andTokencreattimeLessThanOrEqualTo(String value) {
            addCriterion("tokenCreatTime <=", value, "tokencreattime");
            return (Criteria) this;
        }

        public Criteria andTokencreattimeLike(String value) {
            addCriterion("tokenCreatTime like", value, "tokencreattime");
            return (Criteria) this;
        }

        public Criteria andTokencreattimeNotLike(String value) {
            addCriterion("tokenCreatTime not like", value, "tokencreattime");
            return (Criteria) this;
        }

        public Criteria andTokencreattimeIn(List<String> values) {
            addCriterion("tokenCreatTime in", values, "tokencreattime");
            return (Criteria) this;
        }

        public Criteria andTokencreattimeNotIn(List<String> values) {
            addCriterion("tokenCreatTime not in", values, "tokencreattime");
            return (Criteria) this;
        }

        public Criteria andTokencreattimeBetween(String value1, String value2) {
            addCriterion("tokenCreatTime between", value1, value2, "tokencreattime");
            return (Criteria) this;
        }

        public Criteria andTokencreattimeNotBetween(String value1, String value2) {
            addCriterion("tokenCreatTime not between", value1, value2, "tokencreattime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeIsNull() {
            addCriterion("logoutTime is null");
            return (Criteria) this;
        }

        public Criteria andLogouttimeIsNotNull() {
            addCriterion("logoutTime is not null");
            return (Criteria) this;
        }

        public Criteria andLogouttimeEqualTo(String value) {
            addCriterion("logoutTime =", value, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeNotEqualTo(String value) {
            addCriterion("logoutTime <>", value, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeGreaterThan(String value) {
            addCriterion("logoutTime >", value, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeGreaterThanOrEqualTo(String value) {
            addCriterion("logoutTime >=", value, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeLessThan(String value) {
            addCriterion("logoutTime <", value, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeLessThanOrEqualTo(String value) {
            addCriterion("logoutTime <=", value, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeLike(String value) {
            addCriterion("logoutTime like", value, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeNotLike(String value) {
            addCriterion("logoutTime not like", value, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeIn(List<String> values) {
            addCriterion("logoutTime in", values, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeNotIn(List<String> values) {
            addCriterion("logoutTime not in", values, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeBetween(String value1, String value2) {
            addCriterion("logoutTime between", value1, value2, "logouttime");
            return (Criteria) this;
        }

        public Criteria andLogouttimeNotBetween(String value1, String value2) {
            addCriterion("logoutTime not between", value1, value2, "logouttime");
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