package com.imooc.o2o.util;

/**
 * 主要提供两类的路径， 1:根据执行环境的不同，提供根路径（项目所需所有图片，提供的路径）
 * 
 * @author Administrator
 * 
 */
public class PathUtil {
	// 获取文件的分割符
	private static String seperator = System.getProperty("file.seperator");

	public static String getImgBasePath() {
		// 获取操作系统的名称
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "F:/tu";
		} else {
			basePath = "/home/adi/image/";

		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}

	public static String getShopImagePath(long shopId) {
		String imagePath = "/upload/item/shop/" + shopId + "/";
		return imagePath.replace("/", seperator);
	}
}
