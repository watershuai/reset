/*    */ package com.tiger.configuration;
/*    */ 
/*    */ import com.github.pagehelper.PageInterceptor;
/*    */ import java.util.Properties;
/*    */ import javax.annotation.Resource;
/*    */ import javax.sql.DataSource;
/*    */ import org.apache.ibatis.plugin.Interceptor;
/*    */ import org.apache.ibatis.session.SqlSessionFactory;
/*    */ import org.mybatis.spring.SqlSessionFactoryBean;
/*    */ import org.mybatis.spring.SqlSessionTemplate;
/*    */ import org.springframework.beans.factory.annotation.Value;
/*    */ import org.springframework.boot.context.properties.ConfigurationProperties;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.ComponentScan;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.context.annotation.Primary;
/*    */ import org.springframework.context.annotation.PropertySource;
/*    */ import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
/*    */ import org.springframework.jdbc.datasource.DataSourceTransactionManager;
/*    */ import tk.mybatis.spring.annotation.MapperScan;
/*    */ 
/*    */ 
/*    */ @Configuration
/*    */ @ComponentScan
/*    */ @PropertySource(value={"classpath:mybatis.properties"}, ignoreResourceNotFound=true)
/*    */ @MapperScan(basePackages={"com.tiger.dao"})
/*    */ public class MybatisConfig
/*    */ {
/*    */   @Resource
/*    */   private DataSource dataSource;
/*    */   @Value("${mybatis.type-aliases-package}")
/*    */   private String typeAliasesPackage;
/*    */   @Value("${mybatis.mapper-locations}")
/*    */   private String mapperLocations;
/*    */   
/*    */   @Bean
/*    */   @ConfigurationProperties(prefix="mybatis")
/*    */   public SqlSessionFactory sqlSessionFactory()
/*    */     throws Exception
/*    */   {
/* 41 */     SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
/* 42 */     factoryBean.setDataSource(this.dataSource);
/* 43 */     PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
/* 44 */     factoryBean.setMapperLocations(resolver.getResources(this.mapperLocations));
/* 45 */     factoryBean.setTypeAliasesPackage(this.typeAliasesPackage);
/*    */     
/* 47 */     Properties properties = new Properties();
/* 48 */     properties.setProperty("helperDialect", "mysql");
/* 49 */     properties.setProperty("offsetAsPageNum", "true");
/* 50 */     properties.setProperty("rowBoundsWithCount", "true");
/* 51 */     properties.setProperty("reasonable", "true");
/* 52 */     Interceptor interceptor = new PageInterceptor();
/* 53 */     interceptor.setProperties(properties);
/* 54 */     factoryBean.setPlugins(new Interceptor[] { interceptor });
/* 55 */     return factoryBean.getObject();
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public SqlSessionTemplate sqlSessionTemplate() throws Exception {
/* 60 */     SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory());
/* 61 */     return template;
/*    */   }
/*    */   
/*    */ 
/*    */   @Bean(name={"transactionManager"})
/*    */   @Primary
/*    */   public DataSourceTransactionManager transactionManager()
/*    */     throws Exception
/*    */   {
/* 70 */     return new DataSourceTransactionManager(this.dataSource);
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tiger\configuration\MybatisConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */