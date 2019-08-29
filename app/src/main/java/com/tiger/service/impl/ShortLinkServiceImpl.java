/*    */ package com.tiger.service.impl;
/*    */ 
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.tiger.dao.ShortLinkMapper;
/*    */ import com.tiger.pojo.ShortLink;
/*    */ import com.tiger.service.BaseServiceManager;
/*    */ import com.tiger.service.ShortLinkService;
/*    */ import com.yz.common.core.exception.HandlerException;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ import org.springframework.util.CollectionUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class ShortLinkServiceImpl
/*    */   extends BaseServiceManager<ShortLink, ShortLinkMapper>
/*    */   implements ShortLinkService
/*    */ {
/*    */   @Transactional(rollbackFor={HandlerException.class})
/*    */   public String getShortLink()
/*    */   {
/* 28 */     ShortLink shortLink = new ShortLink();
/* 29 */     shortLink.setSlStatus(Integer.valueOf(0));
/* 30 */     PageHelper.startPage(1, 1);
/* 31 */     List<ShortLink> shortLinks = ((ShortLinkMapper)this.dao).select(shortLink);
/* 32 */     if (CollectionUtils.isEmpty(shortLinks)) {
/* 33 */       return "";
/*    */     }
/* 35 */     shortLink = (ShortLink)shortLinks.get(0);
/* 36 */     ShortLink sl = new ShortLink();
/* 37 */     sl.setSlStatus(Integer.valueOf(1));
/* 38 */     sl.setId(shortLink.getId());
/* 39 */     boolean b = update(sl);
/* 40 */     if (!b) {
/* 41 */       return "";
/*    */     }
/* 43 */     return shortLink.getLinkValue();
/*    */   }
/*    */   
/*    */   @Autowired
/*    */   public void setDao(ShortLinkMapper dao)
/*    */   {
/* 49 */     this.dao = dao;
/*    */   }
/*    */   
/*    */   public List<ShortLink> selectPageList(ShortLink shortLink, int pageIndex, int pageSize)
/*    */   {
/* 54 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\impl\ShortLinkServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */