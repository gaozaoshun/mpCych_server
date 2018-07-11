package com.mtty.igood.dto;

/**
 * @Desp
 * @Date 2018/1/31
 * @Author mtty
 */
public class ResponseData {

    public static final transient String CODE_SUCCESS = "000";
    public static final transient String CODE_ERROR = "999";
    public static final transient String CODE_EXCEPTION = "555";
    public static final transient String CODE_EMPTY = "666";

    private String code;
    private String msg;
    private Object data;

    public static ResponseData empty(String msg){
        ResponseData responseData = new ResponseData();
        responseData.setCode(CODE_EMPTY);
        responseData.setMsg(msg);
        return responseData;
    }
    public static ResponseData success(Object data){
        ResponseData responseData = new ResponseData();
        responseData.setCode(CODE_SUCCESS);
        responseData.setMsg("success");
        responseData.setData(data);
        return responseData;
    }
    public static ResponseData error(String errMsg){
        ResponseData responseData = new ResponseData();
        responseData.setCode(CODE_ERROR);
        responseData.setMsg(errMsg);
        return responseData;
    }
    public static ResponseData exception(String errMsg){
        ResponseData responseData = new ResponseData();
        responseData.setCode(CODE_EXCEPTION);
        responseData.setMsg(errMsg);
        return responseData;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
