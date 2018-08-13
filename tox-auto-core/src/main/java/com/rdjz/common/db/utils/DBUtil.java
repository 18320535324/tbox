package com.rdjz.common.db.utils;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Beiden
 * @date 2011-11-14 下午7:42:47
 * @version 1.0
 */
public class DBUtil {

	public static Connection getConnection(String jdbcDriver, String jdbcUrl, String jdbcUser, String jdbcPasswd) {
		try {
			Class.forName(jdbcDriver);
			return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPasswd);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void run(Connection conn, String sqlFile) {
		try {
			ScriptRunner runner = new ScriptRunner(conn);
			runner.runScript(new InputStreamReader(new FileInputStream(new File(sqlFile)), "UTF-8"));
			conn.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			close(conn);
		}
	}

	public static void close(Connection conn) {
		if (conn == null) {
			return;
		}
		try {
			if (conn.isClosed()) {
				return;
			}
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void restore(String userName, String password, String dataBase, String sqlFile) {
		String restore = "cmd /c mysql -u" + userName + " -p" + password + " " + dataBase + " < " + sqlFile;
		try {
			Runtime.getRuntime().exec(restore);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void backup(String userName, String password, String serverIp, String dataBase, String sqlFile) {
		String command = "cmd /c mysqldump -u" + userName //
				+ " -p" + password //
				+ " -h" + serverIp //
				+ " " + dataBase //
				+ " >" + sqlFile //
				+ " --lock-all-tables";
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
