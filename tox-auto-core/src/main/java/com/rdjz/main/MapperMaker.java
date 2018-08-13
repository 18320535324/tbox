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


public class MapperMaker {

	private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

	public static void maker(String tableName, String mapperPackage, String mapperFinalPath, String modelPackage) throws IOException {
		String className = Util.upperFirst(Util.to(tableName));
		Map<String, String> param = new HashMap<String, String>();
		param.put("className", className);
		param.put("author", Main.author);
		param.put("nowTimeString", simpleDateFormat.format(new Date()));
		param.put("modelPackage",modelPackage);
		param.put("mapperPackage", mapperPackage);
		String content = FileUtil.getContent(Util.getTemplatePath()+"/MapperDemo.java");
		content = TemplateUtil.merge(content, param);
		
		String fileName = mapperFinalPath + "/" + className + "Mapper.java";
		FileUtil.deleteFileIfExists(new File(fileName));
		if (!new File(mapperFinalPath).exists())
			new File(mapperFinalPath).mkdirs();
		FileUtil.writeOnce(fileName, content);
	}

}
