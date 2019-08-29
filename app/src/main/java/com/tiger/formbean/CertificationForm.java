 package com.tiger.formbean;
 
 import javax.validation.constraints.Max;
 import javax.validation.constraints.Min;
 import javax.validation.constraints.NotNull;
 import org.springframework.web.multipart.MultipartFile;

 public class CertificationForm
 {
   @Min(1L)
   @Max(2L)
   @NotNull
   private Integer type;
   private MultipartFile idCardUpFile;
   private MultipartFile idCardDownFile;
   private MultipartFile companyLicenseFile;
   private MultipartFile financeLicenseFile;
   private MultipartFile networkCultureLicenseFile;
   
   public Integer getType()
   {
/* 49 */     return this.type;
   }
   
   public void setType(Integer type) {
/* 53 */     this.type = type;
   }
   
   public MultipartFile getIdCardUpFile() {
/* 57 */     return this.idCardUpFile;
   }
   
   public void setIdCardUpFile(MultipartFile idCardUpFile) {
/* 61 */     this.idCardUpFile = idCardUpFile;
   }
   
   public MultipartFile getIdCardDownFile() {
/* 65 */     return this.idCardDownFile;
   }
   
   public void setIdCardDownFile(MultipartFile idCardDownFile) {
/* 69 */     this.idCardDownFile = idCardDownFile;
   }
   
   public MultipartFile getCompanyLicenseFile() {
/* 73 */     return this.companyLicenseFile;
   }
   
   public void setCompanyLicenseFile(MultipartFile companyLicenseFile) {
/* 77 */     this.companyLicenseFile = companyLicenseFile;
   }
   
   public MultipartFile getFinanceLicenseFile() {
/* 81 */     return this.financeLicenseFile;
   }
   
   public void setFinanceLicenseFile(MultipartFile financeLicenseFile) {
/* 85 */     this.financeLicenseFile = financeLicenseFile;
   }
   
   public MultipartFile getNetworkCultureLicenseFile() {
/* 89 */     return this.networkCultureLicenseFile;
   }
   
   public void setNetworkCultureLicenseFile(MultipartFile networkCultureLicenseFile) {
/* 93 */     this.networkCultureLicenseFile = networkCultureLicenseFile;
   }
 }
