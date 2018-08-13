package com.rdjz.common.db.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {

	public static String templatePath = "";

	/**
	 * column to property
	 * 
	 * @param columnName
	 * @return
	 */
	public static String to(String columnName) {
		if (!columnName.contains("_")) {
			return columnName;
		}
		String pre = columnName.substring(0, columnName.indexOf("_"));
		String sub = columnName.substring(columnName.indexOf("_") + 2);
		String word = columnName.substring(columnName.indexOf("_") + 1, columnName.indexOf("_") + 2);
		return to(pre + word.toUpperCase() + sub);
	}
	/*
	public static String convertForUnderLine(String content) {
		if (content == null ) return null;
		content.indexOf()
	}*/

	public static String upperFirst(String columnName) {
		String sub = columnName.substring(1);
		String word = columnName.substring(0, 1);
		return to(word.toUpperCase() + sub);
	}

	public static String getSavePath(String rootPath,String packageName){
		String s = packageName.replaceAll("\\.", "/");
		return rootPath+"/"+s;
	}

	public static  String getTemplatePath(){
		return Util.templatePath;
	}
	
	public static void setTemplatePath(String templatePath){
		Util.templatePath = templatePath;
	}

	public static String convertSlashPath(String path){
		String newPath = "";
		int indexOf = path.indexOf("/");
		if (indexOf == 0)
			path = path.substring(1);
		newPath = path.replaceAll("/", "\\.");
		return newPath;
	}
	
	public static void fileWrite(String fileName, String content) throws Exception{   
		FileInputStream fs = null;
		InputStreamReader in = null;
		BufferedReader br = null;
		String str = "";
		StringBuffer sb = new StringBuffer();

		String textinLine;

		try {
			fs = new FileInputStream(fileName);
			in = new InputStreamReader(fs);
			br = new BufferedReader(in);

			while (true) {
				textinLine = br.readLine();
				if (textinLine == null)
					break;
				sb.append(textinLine);
				sb.append("\n");
			}
			int lastIndexOf = sb.lastIndexOf("}");
			  str = sb.substring(0, lastIndexOf);
			  str += content;
			  str += "}";
			fs.close();
			in.close();
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			FileWriter fstream = new FileWriter(fileName);
			BufferedWriter outobj = new BufferedWriter(fstream);
			outobj.write(str);
			outobj.close();

			System.out.println("Done");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
