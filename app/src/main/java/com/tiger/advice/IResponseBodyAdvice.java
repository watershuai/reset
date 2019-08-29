/*    */ package com.tiger.advice;
/*    */ 
/*    */ import com.alibaba.fastjson.JSON;
/*    */ import com.tiger.utils.ResponseMessage;
/*    */ import com.yz.common.core.exception.HandlerException;
/*    */ import java.sql.SQLException;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import javax.validation.ConstraintViolation;
/*    */ import javax.validation.ConstraintViolationException;
/*    */ import org.apache.tomcat.util.http.fileupload.FileUploadException;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.core.MethodParameter;
/*    */ import org.springframework.core.annotation.Order;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.MediaType;
/*    */ import org.springframework.http.server.ServerHttpRequest;
/*    */ import org.springframework.http.server.ServerHttpResponse;
/*    */ import org.springframework.validation.BindException;
/*    */ import org.springframework.validation.FieldError;
/*    */ import org.springframework.web.bind.MissingServletRequestParameterException;
/*    */ import org.springframework.web.bind.annotation.ControllerAdvice;
/*    */ import org.springframework.web.bind.annotation.ExceptionHandler;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ import org.springframework.web.bind.annotation.ResponseStatus;
/*    */ import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Order(1)
/*    */ @ControllerAdvice(basePackages={"com.tiger.controller"})
/*    */ public class IResponseBodyAdvice
/*    */   implements ResponseBodyAdvice
/*    */ {
/* 39 */   private final Logger logger = LoggerFactory.getLogger(IResponseBodyAdvice.class);
/*    */   
/*    */   public boolean supports(MethodParameter methodParameter, Class aClass)
/*    */   {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse)
/*    */   {
/* 48 */     ResponseMessage message = ResponseMessage.success(o);
/* 49 */     String responseData = JSON.toJSONString(message);
/* 50 */     this.logger.info("返回客户端数据：" + responseData);
/* 51 */     return message;
/*    */   }
/*    */   
/*    */   @ExceptionHandler
/*    */   @ResponseBody
/*    */   @ResponseStatus(HttpStatus.OK)
/* 57 */   public Object handle(Exception exception) { this.logger.error("错误信息  ====  " + exception.getMessage());
/* 58 */     Iterator localIterator; if ((exception instanceof BindException)) {
/* 59 */       BindException bindException = (BindException)exception;
/* 60 */       List<FieldError> fieldErrors = bindException.getFieldErrors();
/* 61 */       localIterator = fieldErrors.iterator(); if (localIterator.hasNext()) { FieldError fieldError = (FieldError)localIterator.next();
/* 62 */         return ResponseMessage.error(10010, fieldError.getField() + fieldError.getDefaultMessage());
/*    */       }
/*    */     }
/*    */     
/* 66 */     if ((exception instanceof ConstraintViolationException)) {
/* 67 */       ConstraintViolationException exs = (ConstraintViolationException)exception;
/*    */       
/* 69 */       Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
/* 70 */       localIterator = violations.iterator(); if (localIterator.hasNext()) { ConstraintViolation<?> violation = (ConstraintViolation)localIterator.next();
/* 71 */         return ResponseMessage.error(10010, violation.getPropertyPath() + violation.getMessage());
/*    */       }
/*    */     }
/* 74 */     if ((exception instanceof HandlerException)) {
/* 75 */       HandlerException handlerException = (HandlerException)exception;
/* 76 */       return new ResponseMessage(handlerException.getCode(), handlerException.getErrorInfo());
/*    */     }
/* 78 */     if ((exception instanceof MissingServletRequestParameterException)) {
/* 79 */       MissingServletRequestParameterException missingServletRequestParameterException = (MissingServletRequestParameterException)exception;
/* 80 */       return ResponseMessage.error(10010, "请求参数" + missingServletRequestParameterException.getParameterName() + "不能为空");
/*    */     }
/* 82 */     if ((exception instanceof FileUploadException)) {
/* 83 */       FileUploadException fileUploadException = (FileUploadException)exception;
/* 84 */       return ResponseMessage.error(10010, fileUploadException.getMessage());
/*    */     }
/* 86 */     if ((exception instanceof SQLException)) {
/* 87 */       return ResponseMessage.error(10010, "数据操作失败");
/*    */     }
/* 89 */     return ResponseMessage.error(-1, exception.getMessage());
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\advice\IResponseBodyAdvice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */