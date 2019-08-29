/*    */ package com.tiger.service;
/*    */ 
/*    */ import com.yz.common.core.service.BaseService;
/*    */ import java.util.List;
/*    */ import tk.mybatis.mapper.common.Mapper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class BaseServiceManager<E, DAO extends Mapper>
/*    */   implements BaseService<E>
/*    */ {
/*    */   public DAO dao;
/*    */   
/*    */   public DAO getDao()
/*    */   {
/* 18 */     return this.dao;
/*    */   }
/*    */   
/*    */   public abstract void setDao(DAO paramDAO);
/*    */   
/*    */   public boolean insert(E e)
/*    */   {
/* 25 */     return this.dao.insertSelective(e) > 0;
/*    */   }
/*    */   
/*    */   public boolean deleteById(Long id)
/*    */   {
/* 30 */     return this.dao.deleteByPrimaryKey(id) > 0;
/*    */   }
/*    */   
/*    */   public boolean deleteByIdList(Long[] ids)
/*    */   {
/* 35 */     return false;
/*    */   }
/*    */   
/*    */   public boolean update(E e)
/*    */   {
/* 40 */     return this.dao.updateByPrimaryKeySelective(e) > 0;
/*    */   }
/*    */   
/*    */   public E selectOne(E e)
/*    */   {
/* 45 */     return (E)this.dao.selectOne(e);
/*    */   }
/*    */   
/*    */   public E selectById(Long id)
/*    */   {
/* 50 */     return (E)this.dao.selectByPrimaryKey(id);
/*    */   }
/*    */   
/*    */   public List<E> selectPageList(E e, int pageIndex, int pageSize)
/*    */   {
/* 55 */     return null;
/*    */   }
/*    */   
/*    */   public List<E> selectList(E e)
/*    */   {
/* 60 */     return this.dao.select(e);
/*    */   }
/*    */   
/*    */   public boolean insertList(List<E> list)
/*    */   {
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public List<E> selectListByIdList(List<Long> idList)
/*    */   {
/* 70 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\service\BaseServiceManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */