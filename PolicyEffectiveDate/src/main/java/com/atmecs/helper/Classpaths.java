package com.atmecs.helper;

import java.io.File;

public class Classpaths {

	public static String userDir = System.getProperty("user.dir");
	public static String resourcePath = userDir + File.separator + "src" + File.separator + "test" + File.separator
			+ "resources";
	public static String filePath = resourcePath + File.separator + "testdata" + File.separator
			+ "PolicyEffectiveDates.xlsx";
}
