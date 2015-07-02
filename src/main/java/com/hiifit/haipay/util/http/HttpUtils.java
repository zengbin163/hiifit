package com.hiifit.haipay.util.http;

import javax.servlet.http.HttpServletRequest;

public class HttpUtils {
	/**
		 * 得到请求的根目录
		 * 
		 * @param request
		 * @return
		 */
		public static String getBasePath(HttpServletRequest request) {
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName()
					+ ":" + request.getServerPort() + path;
			return basePath;
		}
		/**
		 * 获取服务器的路径(tomcat/webapp)
		 * @param request
		 * @return
		 */
		public static String getServerPath(HttpServletRequest request) {
			String basePath = request.getScheme() + "://" + request.getServerName()
					+ ":" + request.getServerPort();
			return basePath;
		}
}

