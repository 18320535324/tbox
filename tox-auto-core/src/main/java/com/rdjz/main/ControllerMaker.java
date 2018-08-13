package com.rdjz.main;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.rdjz.common.db.utils.FileUtil;
import com.rdjz.common.db.utils.TemplateUtil;
import com.rdjz.common.db.utils.Util;

public class ControllerMaker {

	private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

	public static void maker(String tableName, String controllerPackage, String controllerFinalPath, String modelPackage, String servicePackage) throws Exception {
		String className = Util.upperFirst(Util.to(tableName));
		System.out.println(className);
		Map<String, String> param = new HashMap<String, String>();
		param.put("tableName", tableName);
		param.put("classNameProperty", Util.to(tableName));
		param.put("className", className);
		param.put("author", Main.author);
		param.put("nowTimeString", simpleDateFormat.format(new Date()));
		param.put("capitalClassName", tableName.toUpperCase());
		param.put("controllerPackage", controllerPackage);
		param.put("modelPackage", modelPackage);
		param.put("servicePackage", servicePackage);
		
		String content = FileUtil.getContent(Util.getTemplatePath()+ "/ControllerDemo.java");//"/ControllerDemo.java");
		content = TemplateUtil.merge(content, param);
		
		String fileName = controllerFinalPath + "/" + className + "Controller.java";
		FileUtil.deleteFileIfExists(new File(fileName));
		if (!new File(controllerFinalPath).exists())
			new File(controllerFinalPath).mkdirs();
		FileUtil.writeOnce(fileName, content);
	}

}
