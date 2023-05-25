package com.douding.server.enums;
import lombok.Getter;
@Getter
public enum ResultCodeEnum {

    SUCCESS("200","成功"),
    FAIL("201", "失败"),
    DATA_ERROR("204", "数据异常")
    ;

    private String code;

    private String message;

    private ResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
