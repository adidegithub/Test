package com.imooc.o2o.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	private static String basePath = Thread.currentThread().getContextClassLoader()
			.getResource("").getPath();
	//System.out.println(basePath);
	private static final SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random r =new Random();
	//String 自带的文件处理对象CommonsMultipartFile，图片的存储路径是targetAddr
	public static String generateThumbnail(CommonsMultipartFile thumbnail,String targetAddr){
		//图片名称为系统随机生成的 不重名的。
		String realFileName=getRandomFileName();
		//图片的扩展名比如说：jpg、png...
		String extension=getFileExtension(thumbnail);
		markDirPath(targetAddr);
		//获取图片的相对路径
		String relativeAddr=targetAddr+realFileName+extension;
		//组成新生成的文件的路径
		File dest=new File(PathUtil.getImgBasePath()+relativeAddr);
		try{
			Thumbnails.of(thumbnail.getInputStream()).size(200, 200)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath+"/watermark.jpg")), 0.25f)
			.outputQuality(0.8f).toFile(dest);
		}catch(IOException e){
			e.printStackTrace();
		}
		//新增部分；
		return relativeAddr;
		
	}
	/**
	 * 创建目标路径所涉及到的路径，即/home/work/adi/xxx.jpg
	 * 那么home work adi 这三个文件夹都自动创建
	 * @param targetAddr
	 */
	private static void markDirPath(String targetAddr) {
		String realFileParentPath=PathUtil.getImgBasePath()+targetAddr;
		File dirPath=new File(realFileParentPath);
		//如果路径不存在，就递归的创建出来
		if(!dirPath.exists()){
			dirPath.mkdirs();
		}
	}
	/**
	 * 获取输入文件的扩展名
	 * @param thumbnail
	 * @return
	 */
	private static String getFileExtension(CommonsMultipartFile cFile) {
		String originalFileName=cFile.getOriginalFilename();
		return originalFileName.substring(originalFileName.lastIndexOf("."));
	}
	/**
	 * 生成随机文件名，当前时间年月日时分秒+5位随机数
	 * @return
	 */
	private static String getRandomFileName() {
		// 获取随机的五位数9
		int rannum =r.nextInt(89999)+10000;
		String nowTimeStr=sDateFormat.format(new Date());
		return nowTimeStr+rannum;
	}

	public static void main(String[] args) throws IOException {
		Thumbnails
				.of(new File("/F:/tu/green.jpg"))
				//尺寸200X200
				.size(200, 200)
				.watermark(Positions.BOTTOM_RIGHT,
						ImageIO.read(new File(basePath + "/watermark.jpg")),
						//透明度0.25f，图片压缩到80%，即0.8f,将它输出到原来的路径，为了区分，改个新名字。
						0.25f).outputQuality(0.8f).toFile("/F:/tu/greennew.jpg");
	}
}
