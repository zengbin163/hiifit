/*
 * @Project: GZJK
 * @Author: bin
 * @Date: 2015年6月1日
 * @Copyright: 2000-2015 CMCC . All rights reserved.
 */
package com.hiifit.haipay.util.qrcode;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/** 
* @ClassName: QRCode 
* @Description: 生成二维码
* @author zengbin
* @date 2015年6月1日 上午11:07:16 
*/
public class QRCode {
    
    private static final int IMAG_WIDTH = 300;// 二维码图片宽度
    private static final int IMAG_HEIGHT = 300;// 二维码图片高度
    private static final String IMAG_FORMAT = "jpg";// 二维码的图片格式
    private static final String FILE_NAME = "qrcode.jpg";// 二维码文件名
    private static final String FILE_NAME2= "qrcode2.jpg";// 二维码文件名
    
    public static final void main(String[] args) {
        QRCode qrcode = new QRCode();
        qrcode.makeQRcodeImage("D:", "刷码有奖");
        qrcode.makeLogoQRcodeImage("D:", "D:\\logo.png", "刷码有奖");
    }
    
    public void makeQRcodeImage(String path, String qrcodeContent) {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(qrcodeContent, BarcodeFormat.QR_CODE, IMAG_WIDTH, IMAG_HEIGHT, getDecodeHintType());
            // 生成二维码
            File outputFile = new File(path + File.separator + FILE_NAME);
            MatrixToImageWriter.writeToQRCodeFile(bitMatrix, IMAG_FORMAT, outputFile);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    
    public void makeLogoQRcodeImage(String qcodePath, String logoPath, String qrcodeContent) {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(qrcodeContent, BarcodeFormat.QR_CODE, IMAG_WIDTH, IMAG_HEIGHT, getDecodeHintType());
            // 生成二维码
            File outputFile = new File(qcodePath + File.separator + FILE_NAME2);
            MatrixToImageWriter.writeToLogoQRCodeFile(bitMatrix, IMAG_FORMAT, outputFile , new File(logoPath));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    
    /**
     * 设置二维码的格式参数
     * 
     * @return
     */
    private Map<EncodeHintType, Object> getDecodeHintType() {
        // 用于设置QR二维码参数
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        // 设置QR二维码的纠错级别（H为最高级别）具体级别信息
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        // 设置编码方式
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MAX_SIZE, 350);
        hints.put(EncodeHintType.MIN_SIZE, 100);
        
        return hints;
    }
}
