package com.wechat.friends.handler;


import com.wechat.friends.exception.BusinessException;
import com.wechat.friends.reps.ErrorResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler({Exception.class})
	@ResponseBody
	public ErrorResult ExcepitonHandler(Exception e){
		logger.error("捕获到Exception异常:",e);
		return new ErrorResult(e.getMessage());
	}
	
	@ExceptionHandler({BusinessException.class})
	@ResponseBody
	public ErrorResult BusinessExcepitonHandler(BusinessException be, HttpServletResponse httpServletResponse){
		logger.error("捕获到BusinessException异常:",be);
		httpServletResponse.setStatus(be.getNotifyCode());
		return new ErrorResult(be.getMsg(),be.getCode(),be.getNotifyCode());
	}
	
}
