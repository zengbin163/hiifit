/*
 * @Project: GZJK
 * @Author: ysh
 * @Date: 2015年3月30日
 * @Copyright: 2000-2015 CMCC . All rights reserved.
 */
package com.hiifit.haipay.util.math;


public class RandomUtil {
	
	/**
	 * 获取一个在min和max之间的随机数
	 * @param min 最小值
	 * @param max 最大值
	 * @return num
	 */
	public static int getAreaNum(int min , int max){
	    int num = 0;
	    num = min + (int)(Math.random() * ((max - min) + 1));
	    return num;
	}
	
}
