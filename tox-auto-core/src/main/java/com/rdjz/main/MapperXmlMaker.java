package com.rdjz.main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.rdjz.common.db.utils.DatabaseMetaDateApplication;
import com.rdjz.common.db.utils.FileUtil;
import com.rdjz.common.db.utils.Util;


public class MapperXmlMaker {

	private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

	public static void maker(String tableName, String classPackage, String mapperPackage,String mapperXmlSavePath) throws IOException {

		//生成mapper.xml文件
		String fileName = mapperXmlSavePath +"/" + Util.upperFirst(Util.to(tableName)) + "Mapper.xml";
		String className = classPackage + "." + Util.upperFirst(Util.to(tableName));
		String content = make(tableName, className,mapperPackage);
		FileUtil.deleteFileIfExists(new File(fileName));
		FileUtil.writeOnce(fileName, content);

	}

	private static String make(String tableName, String className,String mapperPackage) {
		List<String> columns = new ArrayList<String>();
		DatabaseMetaDateApplication metaData = DatabaseMetaDateApplication.get();
		DatabaseMetaDateApplication.Table table = metaData.getTableColumns(null, tableName);
		for (DatabaseMetaDateApplication.Column col : table.columns) {
			if (col.name.equals("id")) {
				continue;
			}
			if (col.name.equals("create_time")) {
				continue;
			}
			if (col.name.equals("update_time")) {
				continue;
			}
			if (col.name.equals("status")) {
				continue;
			}
			columns.add(col.name);
		}
		return make(tableName, className, columns,mapperPackage);
	}

	private static String make(String tableName, String className, List<String> columns,String mapperPackage) {
		Map<String, String> columnsMap = new LinkedHashMap<String, String>();
		for (String column : columns) {
			columnsMap.put(column, Util.to(column));
		}

		String resultMapObjColumns = "";
		String insertNames = "";
		String insertValues = "";
		String updateSets = "";
		String selectWheres = "";
		String selectWheresPage = "";
		for (String column : columnsMap.keySet()) {
			resultMapObjColumns += "\n\t\t<result property=\"" + columnsMap.get(column) + "\" column=\"" + column + "\"/> ";
			insertNames += " " + column + " ,";
			insertValues += " #{" + columnsMap.get(column) + "} ,";

			String tmpUpdateSets = "\n\t\t\t<if test=\"{columnValue} != null\">  " + //
					"\n\t\t\t\t{column} = #{{columnValue}} , " + //
					"\n\t\t\t</if> ";
			tmpUpdateSets = tmpUpdateSets.replace("{column}", column);
			tmpUpdateSets = tmpUpdateSets.replace("{columnValue}", columnsMap.get(column));
			updateSets += tmpUpdateSets;

			String tmpSelectWheres = "\n\t\t\t<if test=\"{columnValue} != null\">  " + //
					"\n\t\t\t\tand {column} = #{{columnValue}} " + //
					"\n\t\t\t</if>  ";
			tmpSelectWheres = tmpSelectWheres.replace("{column}", column);
			tmpSelectWheres = tmpSelectWheres.replace("{columnValue}", columnsMap.get(column));
			selectWheres += tmpSelectWheres;


			String tmpSelectWheresPage = "\n\t\t\t<if test=\"model !=null and model.{columnValue} != null\">  " + //
					"\n\t\t\t\tand {column} = #{model.{columnValue}} " + //
					"\n\t\t\t</if>  ";
			tmpSelectWheresPage = tmpSelectWheresPage.replace("{column}", column);
			tmpSelectWheresPage = tmpSelectWheresPage.replace("{columnValue}", columnsMap.get(column));
			selectWheresPage += tmpSelectWheresPage;

		}

		Map<String, String> param = new HashMap<String, String>();
		String namespace=mapperPackage+"."+Util.upperFirst(Util.to(tableName))+"Mapper";
		param.put("{namespace}", namespace);
		param.put("{className}", className);
		param.put("{tableName}", tableName);
		param.put("{resultMapObjColumns}", resultMapObjColumns);
		param.put("{insertNames}", insertNames);
		param.put("{insertValues}", insertValues);
		param.put("{updateSets}", updateSets);
		param.put("{selectWheres}", selectWheres);
		param.put("{selectWheresPage}", selectWheresPage);
		String content = FileUtil.getContent( Util.getTemplatePath()+"/MapperDemo.xml");
		for (String key : param.keySet()) {
			content = content.replace(key, param.get(key));
		}
		return content;
	}

}
