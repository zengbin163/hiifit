package com.hiifit.haipay.util.image;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ImagePathUtil {
	
	public final static String PATH_USER_ROOT = "/share/data/";
	public final static String PATH_USER_HEAD_PHOTO = "/head";
	public final static String PATH_USER_WEIBO = "/fire";
	   /**
     * 用户上传头像
     */
    public final static int USER_HEAD_PHOTO = 1;
    /**
     * 用户上传心情贴图片
     */
    public final static int USER_PIC_WEIBO = 2;

	/**
	 * 根据type获取图片保存地址
	 * @param type 1：用户头像保存地址; 2:用户上传图片地址
	 * @return
	 */
	public static String getSavePath(int type){
		String path =null;
		switch (type) {
		case 1: path = PATH_USER_HEAD_PHOTO;
			break;
		case 2: path = PATH_USER_WEIBO;
			break;
		default:
			break;
		}
		return path;
	}
	
   public static String getImageName() {
       Date currentTime = new Date();
       SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss_SSS");
       String dateString = formatter.format(currentTime);
       return dateString;
    }

}
