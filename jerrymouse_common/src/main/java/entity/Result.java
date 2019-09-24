package entity;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private boolean flag; //是否成功
    private Integer code; //响应码
    private String message; //信息
    private T date; //数据

    public Result(boolean flag, Integer code, String message, T date) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.date = date;
    }

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result() {
    }

    public boolean isFlag() {
        return this.code==StatusCode.OK;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

}
