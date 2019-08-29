/*     */ package com.tiger.utils;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ResponseMessage
/*     */ {
/*     */   public ResponseMessage() {}
/*     */   
/*     */ 
/*     */   public ResponseMessage(int code, int errorCode, Object data, String errorMessage)
/*     */   {
/*  12 */     this.code = code;
/*  13 */     this.errorCode = errorCode;
/*  14 */     this.data = data;
/*  15 */     this.errorMessage = errorMessage;
/*     */   }
/*     */   
/*     */   public ResponseMessage(int code) {
/*  19 */     this.code = code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ResponseMessage(Object data)
/*     */   {
/*  27 */     this.data = data;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ResponseMessage(int errorCode, String errorMessage)
/*     */   {
/*  36 */     this.errorCode = errorCode;
/*  37 */     this.errorMessage = errorMessage;
/*     */   }
/*     */   
/*  40 */   private int code = 10000;
/*     */   
/*     */   private int errorCode;
/*     */   
/*     */   private Object data;
/*     */   private String errorMessage;
/*     */   
/*     */   public void setCode(int code)
/*     */   {
/*  49 */     this.code = code;
/*     */   }
/*     */   
/*     */   public int getCode() {
/*  53 */     return this.code;
/*     */   }
/*     */   
/*     */   public int getErrorCode() {
/*  57 */     return this.errorCode;
/*     */   }
/*     */   
/*     */   public void setErrorCode(int errorCode) {
/*  61 */     this.errorCode = errorCode;
/*     */   }
/*     */   
/*     */   public Object getData() {
/*  65 */     return this.data;
/*     */   }
/*     */   
/*     */   public void setData(Object data) {
/*  69 */     this.data = data;
/*     */   }
/*     */   
/*     */   public String getErrorMessage() {
/*  73 */     return this.errorMessage;
/*     */   }
/*     */   
/*     */   public void setErrorMessage(String errorMessage) {
/*  77 */     this.errorMessage = errorMessage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ResponseMessage success()
/*     */   {
/*  85 */     return new ResponseMessage();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ResponseMessage success(Object data)
/*     */   {
/*  94 */     return new ResponseMessage(data);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ResponseMessage error(int code, int errorCode, String errorMessage)
/*     */   {
/* 104 */     ResponseMessage responseMessage = new ResponseMessage();
/* 105 */     responseMessage.setCode(code);
/* 106 */     responseMessage.setErrorCode(errorCode);
/* 107 */     responseMessage.setErrorMessage(errorMessage);
/* 108 */     return responseMessage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ResponseMessage error(int errorCode, String errorInfo)
/*     */   {
/* 117 */     return new ResponseMessage(errorCode, errorInfo);
/*     */   }
/*     */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tige\\utils\ResponseMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */