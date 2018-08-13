package com.rdjz.common.db.utils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Beiden
 * @date 2016-5-24 下午12:00:38
 * @version 1.0
 */
public class TemplateUtil {

	public static Set<String> getKeys(String content) {
		Set<String> keys = new HashSet<String>();
		Pattern p = Pattern.compile("\\{\\{([a-zA-Z0-9]*)\\}\\}");
		Matcher m = p.matcher(content);
		while (m.find()) {
			keys.add(m.group());
		}
		return keys;
	}

	public static String merge(String content, Map<String, String> param) {
		Set<String> keys = getKeys(content);
		for (String key : keys) {
			String tmpKey = key.substring(2, key.length() - 2);
			if (param.containsKey(tmpKey)) {
				content = content.replace(key, param.get(tmpKey));
			}
		}
		return content;
	}

}
