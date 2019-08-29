 package com.tiger.formbean;
 
 import com.tiger.pojo.AutoSignApp;
 import java.util.Date;
 import javax.validation.constraints.Min;
 import org.springframework.format.annotation.DateTimeFormat;
 import org.springframework.stereotype.Component;

 @Component
 public class AutoSignAppForm
   extends AutoSignApp
 {
   @Min(1L)
   private Long id;
   private Integer mealId;
   private String bundleId;
   private String displayName;
   private String ccName;
   private Long userId;
   private Integer freeUpdateNum;
   private String mealDesc;
   private Integer appStatus;
   @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
   private Date expireTime;
   private Date createTime;
   private static final long serialVersionUID = 1L;
   
   public Long getId()
   {
/*  46 */     return this.id;
   }

 
   public void setId(Long id)
   {
/*  53 */     this.id = id;
   }
   
 
 
   public Integer getMealId()
   {
/*  60 */     return this.mealId;
   }
   
 
 
   public void setMealId(Integer mealId)
   {
/*  67 */     this.mealId = mealId;
   }
   
 
 
   public String getBundleId()
   {
/*  74 */     return this.bundleId;
   }
   
 
 
   public void setBundleId(String bundleId)
   {
/*  81 */     this.bundleId = (bundleId == null ? null : bundleId.trim());
   }
   
 
 
   public String getDisplayName()
   {
/*  88 */     return this.displayName;
   }
   
 
 
   public void setDisplayName(String displayName)
   {
/*  95 */     this.displayName = (displayName == null ? null : displayName.trim());
   }
   
 
 
   public String getCcName()
   {
/* 102 */     return this.ccName;
   }
   
 
 
   public void setCcName(String ccName)
   {
/* 109 */     this.ccName = (ccName == null ? null : ccName.trim());
   }
   
 
 
   public Long getUserId()
   {
/* 116 */     return this.userId;
   }
   
 
 
   public void setUserId(Long userId)
   {
/* 123 */     this.userId = userId;
   }
   
 
 
   public Integer getFreeUpdateNum()
   {
/* 130 */     return this.freeUpdateNum;
   }
   
 
 
   public void setFreeUpdateNum(Integer freeUpdateNum)
   {
/* 137 */     this.freeUpdateNum = freeUpdateNum;
   }
   
 
 
 
 
   public Date getExpireTime()
   {
/* 146 */     return this.expireTime;
   }
   
 
 
 
 
   public void setExpireTime(Date expireTime)
   {
/* 155 */     this.expireTime = expireTime;
   }
   
 
 
   public Date getCreateTime()
   {
/* 162 */     return this.createTime;
   }
   
 
 
   public void setCreateTime(Date createTime)
   {
/* 169 */     this.createTime = createTime;
   }
   
   public String getMealDesc() {
/* 173 */     return this.mealDesc;
   }
   
   public void setMealDesc(String mealDesc) {
/* 177 */     this.mealDesc = mealDesc;
   }
   
   public Integer getAppStatus() {
/* 181 */     return this.appStatus;
   }
   
   public void setAppStatus(Integer appStatus) {
/* 185 */     this.appStatus = appStatus;
   }
   
   public String toString()
   {
/* 190 */     StringBuilder sb = new StringBuilder();
/* 191 */     sb.append(getClass().getSimpleName());
/* 192 */     sb.append(" [");
/* 193 */     sb.append("Hash = ").append(hashCode());
/* 194 */     sb.append(", id=").append(this.id);
/* 195 */     sb.append(", mealId=").append(this.mealId);
/* 196 */     sb.append(", bundleId=").append(this.bundleId);
/* 197 */     sb.append(", displayName=").append(this.displayName);
/* 198 */     sb.append(", ccName=").append(this.ccName);
/* 199 */     sb.append(", userId=").append(this.userId);
/* 200 */     sb.append(", freeUpdateNum=").append(this.freeUpdateNum);
/* 201 */     sb.append(", expireTime=").append(this.expireTime);
/* 202 */     sb.append(", createTime=").append(this.createTime);
/* 203 */     sb.append(", serialVersionUID=").append(1L);
/* 204 */     sb.append("]");
/* 205 */     return sb.toString();
   }
 }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\formbean\AutoSignAppForm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */