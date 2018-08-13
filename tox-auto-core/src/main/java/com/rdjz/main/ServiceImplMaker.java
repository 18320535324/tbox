package com.rdjz.main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.rdjz.common.db.utils.FileUtil;
import com.rdjz.common.db.utils.TemplateUtil;
import com.rdjz.common.db.utils.Util;

public class ServiceImplMaker {

	private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

	public static void maker(String tableName, String serviceImplPackage,String serviceImplFinalPath, String modelPackage, String mapperPackage, String servicePackage) throws IOException {
		Map<String, String> param = new HashMap<String, String>();
		String className = Util.upperFirst(Util.to(tableName));
		param.put("tableName", tableName);
		param.put("serviceImplPackage", serviceImplPackage);
		param.put("modelPackage", modelPackage);
		param.put("className", Util.upperFirst(Util.to(tableName)));
		param.put("author", Main.author);
		param.put("mapperPackage", mapperPackage);
		param.put("servicePackage", servicePackage);
		param.put("servceName", Util.to(tableName) + "Service");
		param.put("nowTimeString", simpleDateFormat.format(new Date()));
		String content = FileUtil.getContent(Util.getTemplatePath()+"/ServiceImplDemo.java");
		content = TemplateUtil.merge(content, param);
		String fileName = serviceImplFinalPath + "/" + className + "ServiceImpl.java";
		FileUtil.deleteFileIfExists(new File(fileName));
		if (!new File(serviceImplFinalPath).exists())
			new File(serviceImplFinalPath).mkdirs();
		FileUtil.writeOnce(fileName, content);
		
		
	}

}
