 package com.tiger.websocket;
 
 
 public class Protocol
 {
   private String version;
   
   private int opt;
   private String token;
   private String message;
   
   public String getVersion()
   {
     return this.version;
   }
   
   public void setVersion(String version) {
     this.version = version;
   }
   
   public int getOpt() {
     return this.opt;
   }
   
   public void setOpt(int opt) {
    this.opt = opt;
   }
   
   public String getMessage() {
    return this.message;
   }
   
   public void setMessage(String message) {
    this.message = message;
   }
   
   public String getToken() {
    return this.token;
   }
   
   public void setToken(String token) {
    this.token = token;
   }
 }
