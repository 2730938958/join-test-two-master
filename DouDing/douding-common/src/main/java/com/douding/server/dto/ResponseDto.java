package com.douding.server.dto;

import com.douding.server.enums.ResultCodeEnum;

public class ResponseDto<T> {

    /**
     * 业务上的成功或失败
     */
    private boolean success = true;

    /**
     * 返回码
     */
    private String code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回泛型数据，自定义类型
     */
    private T content;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public static <T> ResponseDto<T> build(T content){
        ResponseDto<T> res = new ResponseDto<T>();
        if(content!=null){
            res.setContent(content);
        }
        return res;
    }

    public static <T> ResponseDto<T> build(T content,String code,String message){
        ResponseDto<T> result= build(content);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> ResponseDto<T> build(T body, ResultCodeEnum resultCodeEnum) {
        ResponseDto<T> result = build(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    public static<T> ResponseDto<T> ok(){
        return ResponseDto.ok(null);
    }

    public static<T> ResponseDto<T> fail(){
        return ResponseDto.fail(null);
    }

    public static<T> ResponseDto<T> fail(T data){
        ResponseDto<T> result = build(data);
        return build(data, ResultCodeEnum.FAIL);
    }

    public static<T> ResponseDto<T> ok(T data){
        ResponseDto<T> result = build(data);
        return build(data, ResultCodeEnum.SUCCESS);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ResponseDto{");
        sb.append("success=").append(success);
        sb.append(", code='").append(code).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", content=").append(content);
        sb.append('}');
        return sb.toString();
    }



}
