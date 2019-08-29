/*    */ package com.tiger.model;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Page<T>
/*    */ {
/*    */   private int index;
/*    */   private int pageSize;
/*    */   private long totalPage;
/*    */   private List<T> dataList;
/*    */   
/*    */   public Page() {}
/*    */   
/*    */   public Page(int index, int pageSize)
/*    */   {
/* 22 */     this.index = index;
/* 23 */     this.pageSize = pageSize;
/*    */   }
/*    */   
/*    */   public int getIndex() {
/* 27 */     return this.index;
/*    */   }
/*    */   
/*    */   public void setIndex(int index) {
/* 31 */     this.index = index;
/*    */   }
/*    */   
/*    */   public int getPageSize() {
/* 35 */     return this.pageSize;
/*    */   }
/*    */   
/*    */   public void setPageSize(int pageSize) {
/* 39 */     this.pageSize = pageSize;
/*    */   }
/*    */   
/*    */   public long getTotalPage() {
/* 43 */     return this.totalPage;
/*    */   }
/*    */   
/*    */   public void setTotalPage(long totalPage) {
/* 47 */     this.totalPage = totalPage;
/*    */   }
/*    */   
/*    */   public List<T> getDataList() {
/* 51 */     return this.dataList;
/*    */   }
/*    */   
/*    */   public void setDataList(List<T> dataList) {
/* 55 */     this.dataList = dataList;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\model\Page.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */