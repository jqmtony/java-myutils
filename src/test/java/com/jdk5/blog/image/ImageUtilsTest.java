package com.jdk5.blog.image;

import java.awt.Color;
import java.io.File;

import junit.framework.TestCase;


public class ImageUtilsTest extends TestCase {

	public void test() {
		try {
			String str = ImageUtilsTest.class.getResource("/images/org.jpg").getPath();
			File orgJpg = new File(str);
			
			ImageUtils.fromFile(orgJpg)
				.quality(0.7f)
				.fixedGivenSize(true)
				.keepRatio(true)
				.size(400, 100)
				.toFile(new File("d:\\image\\400_100_not_ratio.jpg"));
			
			ImageUtils.fromFile(orgJpg)
				.quality(0.7f)
				.fixedGivenSize(true)
				.keepRatio(true)
				.size(200, 200)
				.toFile(new File("d:\\image\\200_200_not_ratio.jpg"));
						
			ImageUtils.fromFile(orgJpg)
				.quality(0.7f)
				.keepRatio(true)
				.size(400, 100)
				.toFile(new File("d:\\image\\400_100_ratio.jpg"));
			
			ImageUtils.fromFile(orgJpg)
				.quality(0.7f)
				.keepRatio(true)
				.size(200, 200)
				.toFile(new File("d:\\image\\200_200_ratio.jpg"));
			
			ImageUtils.fromFile(orgJpg)
				.quality(0.7f)
				.width(700)
				.toFile(new File("d:\\image\\test.jpg"));
			
			str = ImageUtilsTest.class.getResource("/images/org.png").getPath();
			File orgPng = new File(str);
			
			ImageUtils.fromFile(orgJpg)
				//.width(200)
				//.height(200)
				.scale(1)
				//.size(200, 22)
				.rotate(150)
				.quality(0.6f)
				.bgcolor(Color.BLUE)
				.toFile(new File("d:\\image\\test.jpg"));
			
			ImageUtils.fromFile(orgPng)
				.scale(1)
				.rotate(34)		//旋转角度
				.quality(0.6f)
				.bgcolor(null)	//透明背景
				.toFile(new File("d:\\image\\test.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}