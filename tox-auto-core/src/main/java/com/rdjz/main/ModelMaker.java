package com.rdjz.main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.groups.Default;

import com.rdjz.common.db.utils.DatabaseMetaDateApplication;
import com.rdjz.common.db.utils.FileUtil;
import com.rdjz.common.db.utils.TemplateUtil;
import com.rdjz.common.db.utils.Util;

public class ModelMaker {


	private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
	public static void main(String[] args) throws Exception{
	}

	public static void maker(String tableName, String modelName, String classPackage,String modelFinalPath) throws IOException {
		String className = Util.upperFirst(Util.to(tableName));
		modelName = Util.upperFirst(Util.to(modelName));
		String property = makeMapper(tableName);
		Map<String, String> param = new HashMap<String, String>();
//		param.put("author", System.getProperty("user.name") );
		param.put("author", Main.author);
		param.put("nowTimeString",simpleDateFormat.format(new Date()));
		param.put("tableName", tableName);
		param.put("property", property);
		param.put("className", modelName);
		param.put("package", classPackage);
		String content = FileUtil.getContent(Util.getTemplatePath() + "/ModelDemo.java");
		content = TemplateUtil.merge(content, param);
		String fileName = modelFinalPath + "/" + modelName + ".java";
		FileUtil.deleteFileIfExists(new File(fileName));
		if (!new File(modelFinalPath).exists())
			new File(modelFinalPath).mkdirs();
		FileUtil.writeOnce(fileName, content);
	}

	private static String makeMapper(String tableName) {
		DatabaseMetaDateApplication metaData = DatabaseMetaDateApplication.get();
		DatabaseMetaDateApplication.Table table = metaData.getTableColumns(null, tableName);
		return make(tableName, table);
	}

	private static String make(String tableName, DatabaseMetaDateApplication.Table table) {
		String string = "";
		String getSeter = "";
		for (DatabaseMetaDateApplication.Column column : table.columns) {
			StringBuffer sb = new StringBuffer();
			if (column.name.equals("id")) {
				sb.append("\n\t@Id");
			}
			sb.append("\n\t@ApiModelProperty(value = \""+ column.desc + "\")\n\t");
			if (!column.wasNull) {
				sb.append("{notNullNote}(message = \"" + column.desc + "不能为空" + "\", groups = Default.class)");
				sb.append("\n\t");
			}
			sb.append("private {type} {columnValue};\n");
			String tmpPropertys = sb.toString();
			String type = "";
			String notNullNote = "@NotEmpty";
			if ("text".equalsIgnoreCase(column.type) || "varchar".equalsIgnoreCase(column.type)) {
				type = "String";
				notNullNote = "@NotBlank";
			} else if ("datetime".equalsIgnoreCase(column.type) || "date".equalsIgnoreCase(column.type) || "timestamp".equalsIgnoreCase(column.type)) {
				type = "Date";
				notNullNote = "@NotEmpty";
			} else if ( column.type.startsWith("int") ||"TINYINT".equalsIgnoreCase(column.type)) {
				type = "Integer";
				notNullNote = "@NotNull";
			} else if ("bigint".equalsIgnoreCase(column.type)) {
				type = "Long";
				notNullNote = "@NotNull";
			} else if ("double".equalsIgnoreCase(column.type)) {
				type = "Double";
				notNullNote = "@NotNull";
			} else if (column.type.startsWith("float")) {
				type = "Float";
				notNullNote = "@NotNull";
			} else if("numeric".equalsIgnoreCase(column.type)) {
				type = "BigDecimal";
				notNullNote = "@NotNull";
			} else {
				type = "Long";
				notNullNote = "@NotNull";
			}
			tmpPropertys = tmpPropertys.replace("{type}", type);
			tmpPropertys = tmpPropertys.replace("{columnValue}", Util.to(column.name));
			
			if (tmpPropertys.contains("{notNullNote}")) {
				tmpPropertys = tmpPropertys.replace("{notNullNote}", notNullNote);
			}
			string += tmpPropertys;
			String tmpGetSeter = "\n\tpublic {type} get{upperName}() {" + //
					"\n\t\treturn {name};" + //
					"\n\t}" + //
					"\n\n\tpublic void set{upperName}({type} {name}) {" + //
					"\n\t\tthis.{name} = {name};" + //
					"\n\t}\n";
			tmpGetSeter = tmpGetSeter.replace("{type}", type);
			tmpGetSeter = tmpGetSeter.replace("{name}", Util.to(column.name));
			tmpGetSeter = tmpGetSeter.replace("{upperName}", Util.upperFirst(Util.to(column.name)));
			getSeter += tmpGetSeter;
		}
		return string + getSeter;
	}

}
