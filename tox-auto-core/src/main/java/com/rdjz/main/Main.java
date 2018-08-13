package com.rdjz.main;

import static com.rdjz.common.db.utils.Util.convertSlashPath;

import com.rdjz.common.db.utils.DatabaseMetaDateApplication;
import com.rdjz.common.db.utils.Util;
/**
 * 
 * @author salted fish
 * @Date 2018年8月13日
 * 修改projectPath路径为项目路径
 * 修改
 */
public class Main {
	public final static String jdbcDriver = "com.mysql.jdbc.Driver";
	public final static String jdbcUrl = "jdbc:postgresql://127.0.0.1/tbox-dev";
	public final static String jdbcUser = "postgres";
	public final static String jdbcPasswd = "postgres";
	public final static String author = "salted fish";
	public final static String tableName = "tbl_temp_user";
	public final static String modelName = "temp_user";  //model有多词时，用_分开
	//常量
	public final static String projectName = "tox-auto-core";
	/**
	 * 默认微服务结构，这个项目路径要直接配置
	 */
	public final static String projectPath = "D:/saltedfish/work/git/repository-nf3-01/TBox";
	public final static String templateProjectPath = "D:/saltedfish/work/workspace/workspace-saltedfish-01";
	public final static String templatePath = "/tox-auto-core/src/main/resources/generator/demo";
	public final static String PACKAGE_PREFIX = "/src/main/java";
	
	
	public static String mapperProjectPath = "/tbox-base";
	public static String mapperPackage = "/com/jjfinder/tbox/base/dao/mapper";

	public static String modelProjectPath = "/tbox-common";
	public static String modelPackage = "/com/jjfinder/tbox/common/model";

	public static String serviceProjectPath = "/tbox-base";
	public static String servicePackage = "/com/jjfinder/tbox/base/service";

	public static String serviceImplProjectPath = "/tbox-base";
	public static String serviceImplPackage = "/com/jjfinder/tbox/base/service/impl";

	public static String controllerProjectPath = "/tbox-core";
	public static String controllerPackage = "/com/jjfinder/tbox/core/controller";

	public static String apiUrlProjectPath = "/tbox-common";
	public static String apiUrlPackage = "/com/jjfinder/tbox/common/constant";
	
	
	/**
	 * 默认的微服务结构
	 */
	public static String mapperFinalPath;
	
	public static String MODEL_FINAL_PATH;
	
	public static String serviceFinalPath;
	
	public static String serviceImplFinalPath;
	
	public static String controllerFinalPath;
	
	public static String apiUrl;
	public static void main(String[] args) throws Exception {

		Main.initPath();
		DatabaseMetaDateApplication.init(jdbcDriver,jdbcUrl,jdbcUser,jdbcPasswd);
		modelMaker();
		mapperMaker();
		modelMaker();
		serviceMaker();
		serviceImplMaker();
		controllerMakerMaker();
		
	}

	public static void initPath() {
		Util.setTemplatePath(templateProjectPath + templatePath);
		MODEL_FINAL_PATH = projectPath + modelProjectPath + PACKAGE_PREFIX + modelPackage;
		
		mapperFinalPath = projectPath + mapperProjectPath + PACKAGE_PREFIX + mapperPackage;
		serviceFinalPath = projectPath + serviceProjectPath + PACKAGE_PREFIX + servicePackage;
		serviceImplFinalPath = projectPath + serviceImplProjectPath + PACKAGE_PREFIX + serviceImplPackage;
		controllerFinalPath = projectPath + controllerProjectPath + PACKAGE_PREFIX + controllerPackage;
		apiUrl = projectPath + apiUrlProjectPath + PACKAGE_PREFIX + apiUrlPackage;
	
	}

	//生成Model
	public static void modelMaker() throws Exception {
		ModelMaker.maker(tableName, modelName, convertSlashPath(modelPackage), MODEL_FINAL_PATH);
	}

	//生成mapper类 
	public static void mapperMaker()  throws Exception {
        MapperMaker.maker(modelName, convertSlashPath(mapperPackage), mapperFinalPath, convertSlashPath(modelPackage));
	}

	 //生成service
	public static void serviceMaker() throws Exception {
        ServiceMaker.maker(modelName, convertSlashPath(servicePackage), serviceFinalPath, convertSlashPath(modelPackage), convertSlashPath(mapperPackage));
	}

	 //生成serviceImpl
	public static void serviceImplMaker() throws Exception {
        ServiceImplMaker.maker(modelName, convertSlashPath(serviceImplPackage), serviceImplFinalPath, convertSlashPath(modelPackage), convertSlashPath(mapperPackage), convertSlashPath(servicePackage));
	}

	 //生成Controller,只能生成一次
	public static void controllerMakerMaker() throws Exception {
		String content = "\tpublic static final String " + modelName.toUpperCase() +  " = \"/" + Util.to(modelName) + "\"" + ";\n";
		Util.fileWrite(apiUrl + "/" + "ApiCoreConstant.java", content);
        ControllerMaker.maker(modelName, convertSlashPath(controllerPackage), controllerFinalPath, convertSlashPath(modelPackage), convertSlashPath(servicePackage));
	}
	
}
