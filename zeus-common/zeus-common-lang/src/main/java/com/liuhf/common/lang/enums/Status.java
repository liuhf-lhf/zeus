package com.liuhf.common.lang.enums;

public enum Status {
    SUCCESS("200", "请求成功"),
    /**
     * 外部数据数据源返回错误状态码
     */
    OK("201", "数据源请求失败"),
    NO_DATA("201", "无数据"),
    FAILED("500", "服务器异常"),

    NULL("406", "缺少必填参数"),

    UN_LOGIN("401", "未登录"),

    SAVE_ERROR("501", "添加失败"),

    MODIFY_ERROR("502", "修改失败"),

    DELETE_ERROR("503", "删除失败"),

    UNIQUE_ERROR("407", "违背唯一索引");


    private final String code;
    private final String message;

    Status(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
