/*    */ package com.tiger.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.tiger.dao.IconDataMapper;
/*    */ import com.tiger.pojo.IconData;
/*    */ import com.tiger.service.BaseServiceManager;
/*    */ import com.tiger.service.IconDataService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.util.CollectionUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class IconDataServiceImpl
/*    */   extends BaseServiceManager<IconData, IconDataMapper>
/*    */   implements IconDataService
/*    */ {
/*    */   @Autowired
/*    */   public void setDao(IconDataMapper dao)
/*    */   {
/* 24 */     this.dao = dao;
/*    */   }
/*    */   
/*    */   public List<IconData> selectPageList(IconData iconData, int pageIndex, int pageSize)
/*    */   {
/* 29 */     return null;
/*    */   }
/*    */   
/*    */   public IconData getLastVersionIconData(String bundleId)
/*    */   {
/* 34 */     PageHelper.orderBy("create_time desc");
/* 35 */     PageHelper.startPage(1, 1);
/* 36 */     IconData iconData = new IconData();
/* 37 */     iconData.setBundleId(bundleId);
/* 38 */     List<IconData> iconDataList = ((IconDataMapper)this.dao).select(iconData);
/* 39 */     if (CollectionUtils.isEmpty(iconDataList)) {
/* 40 */       return null;
/*    */     }
/* 42 */     return (IconData)iconDataList.get(0);
/*    */   }
/*    */   
/*    */   public List<IconData> selectListByIdList(List<Long> idList)
/*    */   {
/* 47 */     return ((IconDataMapper)this.dao).selectByIdList(idList);
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\impl\IconDataServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */