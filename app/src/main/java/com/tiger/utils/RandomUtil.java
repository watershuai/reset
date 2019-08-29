/*    */ package com.tiger.utils;
/*    */ 
/*    */ import java.util.Random;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RandomUtil
/*    */ {
/*    */   public static String randomNumAndChar(int length)
/*    */   {
/* 13 */     StringBuilder builder = new StringBuilder();
/* 14 */     Random rand = new Random();
/* 15 */     for (int i = 0; i < length; i++) {
/* 16 */       int choice = rand.nextInt(3);
/* 17 */       switch (choice) {
/*    */       case 0: 
/* 19 */         int num = rand.nextInt(9);
/* 20 */         builder.append(num);
/* 21 */         break;
/*    */       case 1: 
/* 23 */         int num2 = rand.nextInt(25) + 65;
/* 24 */         char low = (char)num2;
/* 25 */         builder.append(low);
/* 26 */         break;
/*    */       case 2: 
/* 28 */         int num3 = rand.nextInt(25) + 97;
/* 29 */         char high = (char)num3;
/* 30 */         builder.append(high);
/*    */       }
/*    */       
/*    */     }
/*    */     
/*    */ 
/* 36 */     return builder.toString();
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tige\\utils\RandomUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */