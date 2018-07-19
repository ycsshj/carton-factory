package com.carton.model;

import com.carton.model.base.BaseEntity;

public class Lov extends BaseEntity{

    private String category;

    private String lovCode;

    private String lovValue;

    private String parentCode;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getLovCode() {
        return lovCode;
    }

    public void setLovCode(String lovCode) {
        this.lovCode = lovCode == null ? null : lovCode.trim();
    }

    public String getLovValue() {
        return lovValue;
    }

    public void setLovValue(String lovValue) {
        this.lovValue = lovValue == null ? null : lovValue.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }
}