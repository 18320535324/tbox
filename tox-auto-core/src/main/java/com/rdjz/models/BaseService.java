package com.rdjz.models;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.Triple;

/**
 * @author spark
 * @version 1.0.0
 * @since 2015-5-25
 */
public interface BaseService<Model extends BaseModel> {


	public int create(Model model);
	public void deleteBy(Model model);
	public void delete(Model model);	
	public void delete(int modelId);
	public void update(Model model);
	public Model getById(Model model);
	public Model getById(int modelId);
	public Model getBy(Model model);
	public int countAll();
	public int countAll(Model model);
	public List<Model> listByPage(DBPage page);
	public List<Model> listByPage(Model model);
	public List<Model> listByPage(Model model, DBPage page);
	public Map<Integer, Model> map(Model model, DBPage page);
	public Triple<Boolean, Annotation, Class> getReady(EnableCache.Method method);

	/**
	 * 记住对象关联的key，以便根据id删除和更新的时候，能够找回对象相关的缓存进行清除（evict）。
	 * @param modelClass
	 * @param key
	 */
	public void rememberKeys(Class modelClass, String key);
	public void evictKeys(Class modelClass, boolean flushList);
	public void setModelCacheKey(Triple<Boolean, Annotation, Class> ctx, String cacheKey, Model model);
}