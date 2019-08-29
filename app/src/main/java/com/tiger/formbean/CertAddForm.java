 package com.tiger.formbean;
 
 import javax.validation.constraints.Min;
 import javax.validation.constraints.NotBlank;

 public class CertAddForm
 {
   @NotBlank
   private String certName;
   @Min(1L)
   private Integer maxNum;
   @Min(value=1L, message="请选择套餐类型")
   private Integer mealType;
   
   public String getCertName()
   {
/* 32 */     return this.certName;
   }
   
   public void setCertName(String certName) {
/* 36 */     this.certName = certName;
   }
   
   public Integer getMaxNum() {
/* 40 */     return this.maxNum;
   }
   
   public void setMaxNum(Integer maxNum) {
/* 44 */     this.maxNum = maxNum;
   }
   
   public Integer getMealType() {
/* 48 */     return this.mealType;
   }
   
   public void setMealType(Integer mealType) {
/* 52 */     this.mealType = mealType;
   }
 }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\formbean\CertAddForm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */