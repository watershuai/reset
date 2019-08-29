/*    */ package com.tiger.enums;

/*    */ public enum AutoSignTaskStatusEnum
/*    */ {
/* 10 */   WAIT_SIGN, 
/*    */   
/* 12 */   SIGN_FINISH, 
/*    */   
/* 14 */   UPDATE_SIGN, 
/*    */   
/* 16 */   WAIT_SUPPLEMENT_SIGN, 
/*    */   
/* 18 */   SUPPLEMENT_SIGN_FINISH;
/*    */   
/*    */   private AutoSignTaskStatusEnum() {}
/*    */   
/* 22 */   public static AutoSignTaskStatusEnum get(int ordinal) {
           /*    for (AutoSignTaskStatusEnum autoSignTaskStatusEnum : ) {
*//* 23 *//*       if (autoSignTaskStatusEnum.ordinal() == ordinal) {
*//* 24 *//*         return autoSignTaskStatusEnum;
*//*    *//*       }
*//*    *//*     }*/
/* 27 */     return null;
/*    */   }
/*    */ }
