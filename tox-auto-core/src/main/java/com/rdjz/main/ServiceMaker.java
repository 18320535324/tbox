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

public class ServiceMaker {

	private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

	public static void maker(String tableName, String servicePackage, String serviceFinalPath, String modelPackage, String mapperPackage) throws IOException {
		Map<String, String> param = new HashMap<String, String>();
		String className = Util.upperFirst(Util.to(tableName));
		param.put("tableName", tableName);
		param.put("className", Util.upperFirst(Util.to(tableName)));
		param.put("modelPackage", modelPackage);
		param.put("author", Main.author);
		param.put("nowTimeString", simpleDateFormat.format(new Date()));
		param.put("servicePackage", servicePackage);
		param.put("mapperPackage", mapperPackage);
		String content = FileUtil.getContent(Util.getTemplatePath()+"/ServiceDemo.java");
		content = TemplateUtil.merge(content, param);
		String fileName = serviceFinalPath + "/" + className + "Service.java";
		FileUtil.deleteFileIfExists(new File(fileName));
		if (!new File(serviceFinalPath).exists())
			new File(serviceFinalPath).mkdirs();
		FileUtil.writeOnce(fileName, content);
		
	}

}
