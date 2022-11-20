package com.example.passport.model;

import lombok.Data;

import java.util.Map;

@Data
public class RestResp implements java.io.Serializable{
    public static final Integer OK = 0;

    private Integer code = OK;
    private String message = "";
    private Object data ;
    private String trace_id ="";

    private void RetResp() {}

    private RestResp(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private RestResp(Object data) {
        this.data = data;
    }

    public static RestResp ok() {
        return new RestResp(OK,"");
    }

    public static RestResp success(Object data) {
        return new RestResp(data);
    }

    public static RestResp error(Integer code, String message) {
        return new RestResp(code, message);
    }
}
