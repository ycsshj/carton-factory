package com.carton.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CartonCategoryExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CartonCategoryExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCartonBigTypeIsNull() {
            addCriterion("carton_big_type is null");
            return (Criteria) this;
        }

        public Criteria andCartonBigTypeIsNotNull() {
            addCriterion("carton_big_type is not null");
            return (Criteria) this;
        }

        public Criteria andCartonBigTypeEqualTo(String value) {
            addCriterion("carton_big_type =", value, "cartonBigType");
            return (Criteria) this;
        }

        public Criteria andCartonBigTypeNotEqualTo(String value) {
            addCriterion("carton_big_type <>", value, "cartonBigType");
            return (Criteria) this;
        }

        public Criteria andCartonBigTypeGreaterThan(String value) {
            addCriterion("carton_big_type >", value, "cartonBigType");
            return (Criteria) this;
        }

        public Criteria andCartonBigTypeGreaterThanOrEqualTo(String value) {
            addCriterion("carton_big_type >=", value, "cartonBigType");
            return (Criteria) this;
        }

        public Criteria andCartonBigTypeLessThan(String value) {
            addCriterion("carton_big_type <", value, "cartonBigType");
            return (Criteria) this;
        }

        public Criteria andCartonBigTypeLessThanOrEqualTo(String value) {
            addCriterion("carton_big_type <=", value, "cartonBigType");
            return (Criteria) this;
        }

        public Criteria andCartonBigTypeLike(String value) {
            addCriterion("carton_big_type like", value, "cartonBigType");
            return (Criteria) this;
        }

        public Criteria andCartonBigTypeNotLike(String value) {
            addCriterion("carton_big_type not like", value, "cartonBigType");
            return (Criteria) this;
        }

        public Criteria andCartonBigTypeIn(List<String> values) {
            addCriterion("carton_big_type in", values, "cartonBigType");
            return (Criteria) this;
        }

        public Criteria andCartonBigTypeNotIn(List<String> values) {
            addCriterion("carton_big_type not in", values, "cartonBigType");
            return (Criteria) this;
        }

        public Criteria andCartonBigTypeBetween(String value1, String value2) {
            addCriterion("carton_big_type between", value1, value2, "cartonBigType");
            return (Criteria) this;
        }

        public Criteria andCartonBigTypeNotBetween(String value1, String value2) {
            addCriterion("carton_big_type not between", value1, value2, "cartonBigType");
            return (Criteria) this;
        }

        public Criteria andCartonSmallTypeIsNull() {
            addCriterion("carton_small_type is null");
            return (Criteria) this;
        }

        public Criteria andCartonSmallTypeIsNotNull() {
            addCriterion("carton_small_type is not null");
            return (Criteria) this;
        }

        public Criteria andCartonSmallTypeEqualTo(String value) {
            addCriterion("carton_small_type =", value, "cartonSmallType");
            return (Criteria) this;
        }

        public Criteria andCartonSmallTypeNotEqualTo(String value) {
            addCriterion("carton_small_type <>", value, "cartonSmallType");
            return (Criteria) this;
        }

        public Criteria andCartonSmallTypeGreaterThan(String value) {
            addCriterion("carton_small_type >", value, "cartonSmallType");
            return (Criteria) this;
        }

        public Criteria andCartonSmallTypeGreaterThanOrEqualTo(String value) {
            addCriterion("carton_small_type >=", value, "cartonSmallType");
            return (Criteria) this;
        }

        public Criteria andCartonSmallTypeLessThan(String value) {
            addCriterion("carton_small_type <", value, "cartonSmallType");
            return (Criteria) this;
        }

        public Criteria andCartonSmallTypeLessThanOrEqualTo(String value) {
            addCriterion("carton_small_type <=", value, "cartonSmallType");
            return (Criteria) this;
        }

        public Criteria andCartonSmallTypeLike(String value) {
            addCriterion("carton_small_type like", value, "cartonSmallType");
            return (Criteria) this;
        }

        public Criteria andCartonSmallTypeNotLike(String value) {
            addCriterion("carton_small_type not like", value, "cartonSmallType");
            return (Criteria) this;
        }

        public Criteria andCartonSmallTypeIn(List<String> values) {
            addCriterion("carton_small_type in", values, "cartonSmallType");
            return (Criteria) this;
        }

        public Criteria andCartonSmallTypeNotIn(List<String> values) {
            addCriterion("carton_small_type not in", values, "cartonSmallType");
            return (Criteria) this;
        }

        public Criteria andCartonSmallTypeBetween(String value1, String value2) {
            addCriterion("carton_small_type between", value1, value2, "cartonSmallType");
            return (Criteria) this;
        }

        public Criteria andCartonSmallTypeNotBetween(String value1, String value2) {
            addCriterion("carton_small_type not between", value1, value2, "cartonSmallType");
            return (Criteria) this;
        }

        public Criteria andCartonLengthIsNull() {
            addCriterion("carton_length is null");
            return (Criteria) this;
        }

        public Criteria andCartonLengthIsNotNull() {
            addCriterion("carton_length is not null");
            return (Criteria) this;
        }

        public Criteria andCartonLengthEqualTo(Double value) {
            addCriterion("carton_length =", value, "cartonLength");
            return (Criteria) this;
        }

        public Criteria andCartonLengthNotEqualTo(Double value) {
            addCriterion("carton_length <>", value, "cartonLength");
            return (Criteria) this;
        }

        public Criteria andCartonLengthGreaterThan(Double value) {
            addCriterion("carton_length >", value, "cartonLength");
            return (Criteria) this;
        }

        public Criteria andCartonLengthGreaterThanOrEqualTo(Double value) {
            addCriterion("carton_length >=", value, "cartonLength");
            return (Criteria) this;
        }

        public Criteria andCartonLengthLessThan(Double value) {
            addCriterion("carton_length <", value, "cartonLength");
            return (Criteria) this;
        }

        public Criteria andCartonLengthLessThanOrEqualTo(Double value) {
            addCriterion("carton_length <=", value, "cartonLength");
            return (Criteria) this;
        }

        public Criteria andCartonLengthIn(List<Double> values) {
            addCriterion("carton_length in", values, "cartonLength");
            return (Criteria) this;
        }

        public Criteria andCartonLengthNotIn(List<Double> values) {
            addCriterion("carton_length not in", values, "cartonLength");
            return (Criteria) this;
        }

        public Criteria andCartonLengthBetween(Double value1, Double value2) {
            addCriterion("carton_length between", value1, value2, "cartonLength");
            return (Criteria) this;
        }

        public Criteria andCartonLengthNotBetween(Double value1, Double value2) {
            addCriterion("carton_length not between", value1, value2, "cartonLength");
            return (Criteria) this;
        }

        public Criteria andCartonWidthIsNull() {
            addCriterion("carton_width is null");
            return (Criteria) this;
        }

        public Criteria andCartonWidthIsNotNull() {
            addCriterion("carton_width is not null");
            return (Criteria) this;
        }

        public Criteria andCartonWidthEqualTo(Double value) {
            addCriterion("carton_width =", value, "cartonWidth");
            return (Criteria) this;
        }

        public Criteria andCartonWidthNotEqualTo(Double value) {
            addCriterion("carton_width <>", value, "cartonWidth");
            return (Criteria) this;
        }

        public Criteria andCartonWidthGreaterThan(Double value) {
            addCriterion("carton_width >", value, "cartonWidth");
            return (Criteria) this;
        }

        public Criteria andCartonWidthGreaterThanOrEqualTo(Double value) {
            addCriterion("carton_width >=", value, "cartonWidth");
            return (Criteria) this;
        }

        public Criteria andCartonWidthLessThan(Double value) {
            addCriterion("carton_width <", value, "cartonWidth");
            return (Criteria) this;
        }

        public Criteria andCartonWidthLessThanOrEqualTo(Double value) {
            addCriterion("carton_width <=", value, "cartonWidth");
            return (Criteria) this;
        }

        public Criteria andCartonWidthIn(List<Double> values) {
            addCriterion("carton_width in", values, "cartonWidth");
            return (Criteria) this;
        }

        public Criteria andCartonWidthNotIn(List<Double> values) {
            addCriterion("carton_width not in", values, "cartonWidth");
            return (Criteria) this;
        }

        public Criteria andCartonWidthBetween(Double value1, Double value2) {
            addCriterion("carton_width between", value1, value2, "cartonWidth");
            return (Criteria) this;
        }

        public Criteria andCartonWidthNotBetween(Double value1, Double value2) {
            addCriterion("carton_width not between", value1, value2, "cartonWidth");
            return (Criteria) this;
        }

        public Criteria andCartonHeightIsNull() {
            addCriterion("carton_height is null");
            return (Criteria) this;
        }

        public Criteria andCartonHeightIsNotNull() {
            addCriterion("carton_height is not null");
            return (Criteria) this;
        }

        public Criteria andCartonHeightEqualTo(Double value) {
            addCriterion("carton_height =", value, "cartonHeight");
            return (Criteria) this;
        }

        public Criteria andCartonHeightNotEqualTo(Double value) {
            addCriterion("carton_height <>", value, "cartonHeight");
            return (Criteria) this;
        }

        public Criteria andCartonHeightGreaterThan(Double value) {
            addCriterion("carton_height >", value, "cartonHeight");
            return (Criteria) this;
        }

        public Criteria andCartonHeightGreaterThanOrEqualTo(Double value) {
            addCriterion("carton_height >=", value, "cartonHeight");
            return (Criteria) this;
        }

        public Criteria andCartonHeightLessThan(Double value) {
            addCriterion("carton_height <", value, "cartonHeight");
            return (Criteria) this;
        }

        public Criteria andCartonHeightLessThanOrEqualTo(Double value) {
            addCriterion("carton_height <=", value, "cartonHeight");
            return (Criteria) this;
        }

        public Criteria andCartonHeightIn(List<Double> values) {
            addCriterion("carton_height in", values, "cartonHeight");
            return (Criteria) this;
        }

        public Criteria andCartonHeightNotIn(List<Double> values) {
            addCriterion("carton_height not in", values, "cartonHeight");
            return (Criteria) this;
        }

        public Criteria andCartonHeightBetween(Double value1, Double value2) {
            addCriterion("carton_height between", value1, value2, "cartonHeight");
            return (Criteria) this;
        }

        public Criteria andCartonHeightNotBetween(Double value1, Double value2) {
            addCriterion("carton_height not between", value1, value2, "cartonHeight");
            return (Criteria) this;
        }

        public Criteria andCartonStandardIsNull() {
            addCriterion("carton_standard is null");
            return (Criteria) this;
        }

        public Criteria andCartonStandardIsNotNull() {
            addCriterion("carton_standard is not null");
            return (Criteria) this;
        }

        public Criteria andCartonStandardEqualTo(String value) {
            addCriterion("carton_standard =", value, "cartonStandard");
            return (Criteria) this;
        }

        public Criteria andCartonStandardNotEqualTo(String value) {
            addCriterion("carton_standard <>", value, "cartonStandard");
            return (Criteria) this;
        }

        public Criteria andCartonStandardGreaterThan(String value) {
            addCriterion("carton_standard >", value, "cartonStandard");
            return (Criteria) this;
        }

        public Criteria andCartonStandardGreaterThanOrEqualTo(String value) {
            addCriterion("carton_standard >=", value, "cartonStandard");
            return (Criteria) this;
        }

        public Criteria andCartonStandardLessThan(String value) {
            addCriterion("carton_standard <", value, "cartonStandard");
            return (Criteria) this;
        }

        public Criteria andCartonStandardLessThanOrEqualTo(String value) {
            addCriterion("carton_standard <=", value, "cartonStandard");
            return (Criteria) this;
        }

        public Criteria andCartonStandardLike(String value) {
            addCriterion("carton_standard like", value, "cartonStandard");
            return (Criteria) this;
        }

        public Criteria andCartonStandardNotLike(String value) {
            addCriterion("carton_standard not like", value, "cartonStandard");
            return (Criteria) this;
        }

        public Criteria andCartonStandardIn(List<String> values) {
            addCriterion("carton_standard in", values, "cartonStandard");
            return (Criteria) this;
        }

        public Criteria andCartonStandardNotIn(List<String> values) {
            addCriterion("carton_standard not in", values, "cartonStandard");
            return (Criteria) this;
        }

        public Criteria andCartonStandardBetween(String value1, String value2) {
            addCriterion("carton_standard between", value1, value2, "cartonStandard");
            return (Criteria) this;
        }

        public Criteria andCartonStandardNotBetween(String value1, String value2) {
            addCriterion("carton_standard not between", value1, value2, "cartonStandard");
            return (Criteria) this;
        }

        public Criteria andCriticalStandardIsNull() {
            addCriterion("critical_standard is null");
            return (Criteria) this;
        }

        public Criteria andCriticalStandardIsNotNull() {
            addCriterion("critical_standard is not null");
            return (Criteria) this;
        }

        public Criteria andCriticalStandardEqualTo(String value) {
            addCriterion("critical_standard =", value, "criticalStandard");
            return (Criteria) this;
        }

        public Criteria andCriticalStandardNotEqualTo(String value) {
            addCriterion("critical_standard <>", value, "criticalStandard");
            return (Criteria) this;
        }

        public Criteria andCriticalStandardGreaterThan(String value) {
            addCriterion("critical_standard >", value, "criticalStandard");
            return (Criteria) this;
        }

        public Criteria andCriticalStandardGreaterThanOrEqualTo(String value) {
            addCriterion("critical_standard >=", value, "criticalStandard");
            return (Criteria) this;
        }

        public Criteria andCriticalStandardLessThan(String value) {
            addCriterion("critical_standard <", value, "criticalStandard");
            return (Criteria) this;
        }

        public Criteria andCriticalStandardLessThanOrEqualTo(String value) {
            addCriterion("critical_standard <=", value, "criticalStandard");
            return (Criteria) this;
        }

        public Criteria andCriticalStandardLike(String value) {
            addCriterion("critical_standard like", value, "criticalStandard");
            return (Criteria) this;
        }

        public Criteria andCriticalStandardNotLike(String value) {
            addCriterion("critical_standard not like", value, "criticalStandard");
            return (Criteria) this;
        }

        public Criteria andCriticalStandardIn(List<String> values) {
            addCriterion("critical_standard in", values, "criticalStandard");
            return (Criteria) this;
        }

        public Criteria andCriticalStandardNotIn(List<String> values) {
            addCriterion("critical_standard not in", values, "criticalStandard");
            return (Criteria) this;
        }

        public Criteria andCriticalStandardBetween(String value1, String value2) {
            addCriterion("critical_standard between", value1, value2, "criticalStandard");
            return (Criteria) this;
        }

        public Criteria andCriticalStandardNotBetween(String value1, String value2) {
            addCriterion("critical_standard not between", value1, value2, "criticalStandard");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andValidIsNull() {
            addCriterion("valid is null");
            return (Criteria) this;
        }

        public Criteria andValidIsNotNull() {
            addCriterion("valid is not null");
            return (Criteria) this;
        }

        public Criteria andValidEqualTo(Integer value) {
            addCriterion("valid =", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotEqualTo(Integer value) {
            addCriterion("valid <>", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThan(Integer value) {
            addCriterion("valid >", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThanOrEqualTo(Integer value) {
            addCriterion("valid >=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThan(Integer value) {
            addCriterion("valid <", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThanOrEqualTo(Integer value) {
            addCriterion("valid <=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidIn(List<Integer> values) {
            addCriterion("valid in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotIn(List<Integer> values) {
            addCriterion("valid not in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidBetween(Integer value1, Integer value2) {
            addCriterion("valid between", value1, value2, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotBetween(Integer value1, Integer value2) {
            addCriterion("valid not between", value1, value2, "valid");
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