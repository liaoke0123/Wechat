package com.wechat.friends.exception;

import com.wechat.friends.service.impl.ImagesServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class BusinessException extends Exception {

    private static final Logger logger = LoggerFactory.getLogger(BusinessException.class);

    private String msg;//业务msg
    private Integer code;//业务code
    private Integer notifyCode;//通知code

    public BusinessException() {
    }

    public BusinessException(String msg, Integer code, Integer notifyCode) {
        super(msg);
        this.msg = msg;
        this.code = code;
        this.notifyCode = notifyCode;

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getNotifyCode() {
        return notifyCode;
    }

    public void setNotifyCode(Integer notifyCode) {
        this.notifyCode = notifyCode;
    }
}
