/*    */ package com.tiger.utils;
/*    */ 
/*    */ import com.google.zxing.BarcodeFormat;
/*    */ import com.google.zxing.EncodeHintType;
/*    */ import com.google.zxing.MultiFormatWriter;
/*    */ import com.google.zxing.common.BitMatrix;
/*    */ import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QRCodeUtil
/*    */ {
/*    */   private static final int BLACK = -16777216;
/*    */   private static final int WHITE = -1;
/*    */   private static final String FORMAT = "png";
/* 30 */   private int width = 300;
/*    */   
/* 32 */   private int height = 300;
/*    */   
/*    */   public void setWidth(int width) {
/* 35 */     this.width = width;
/*    */   }
/*    */   
/*    */   public void setHeight(int height) {
/* 39 */     this.height = height;
/*    */   }
/*    */   
/*    */   public static QRCodeUtil build() {
/* 43 */     return new QRCodeUtil();
/*    */   }
/*    */   
/*    */   public static QRCodeUtil build(int width, int height) {
/* 47 */     QRCodeUtil qrCodeUtil = new QRCodeUtil();
/* 48 */     qrCodeUtil.setHeight(height);
/* 49 */     qrCodeUtil.setWidth(width);
/* 50 */     return qrCodeUtil;
/*    */   }
/*    */   
/*    */   public BufferedImage toBufferedImage(BitMatrix matrix) {
/* 54 */     int width = matrix.getWidth();
/* 55 */     int height = matrix.getHeight();
/* 56 */     BufferedImage image = new BufferedImage(width, height, 1);
/*    */     
/* 58 */     for (int x = 0; x < width; x++) {
/* 59 */       for (int y = 0; y < height; y++) {
/* 60 */         image.setRGB(x, y, matrix.get(x, y) ? -16777216 : -1);
/*    */       }
/*    */     }
/* 63 */     return image;
/*    */   }
/*    */   
/*    */   public void writeToFile(BitMatrix matrix, String format, File file)
/*    */     throws IOException
/*    */   {
/* 69 */     BufferedImage image = toBufferedImage(matrix);
/* 70 */     if (!ImageIO.write(image, format, file)) {
/* 71 */       throw new IOException("Could not write an image of format " + format + " to " + file);
/*    */     }
/*    */   }
/*    */   
/*    */   public void createQRCode(String contents, String filePath) throws Exception
/*    */   {
/* 77 */     int width = 300;
/* 78 */     int height = 300;
/* 79 */     HashMap map = new HashMap();
/* 80 */     map.put(EncodeHintType.CHARACTER_SET, "utf-8");
/* 81 */     map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
/* 82 */     map.put(EncodeHintType.MARGIN, Integer.valueOf(0));
/* 83 */     BitMatrix bm = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height);
/* 84 */     writeToFile(bm, "png", new File(filePath));
/*    */   }
/*    */ }


/* Location:              D:\QQupload\web-app.jar!\BOOT-INF\classes\com\tige\\utils\QRCodeUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */