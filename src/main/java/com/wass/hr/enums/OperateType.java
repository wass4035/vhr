package com.wass.hr.enums;

/**
 * @author wass
 */
public enum OperateType {
    login("operatetype_login"),
    logout("operatetype_logout"),

    add("operatetype_add"),
    update("operatetype_update"),
    delete("operatetype_delete");

    private String text;

    OperateType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
