package com.rdjz.models;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author saltedifsh
 *
 */
public interface BaseMapper<Model extends BaseModel> {
    int create(Model model);

    int delete(int modelId);

    int deleteBy(Model model);

    int update(Model model);

    Model getById(int modelId);

    Model getBy(Model model);

    int countAll(Model model);

    List<Model> listByPage(@Param("model") Model model, @Param("startRow") int startRow, @Param("pageSize") int pageSize);

    List<Integer> listIdByPage(@Param("model") Model model, @Param("startRow") int startRow, @Param("pageSize") int pageSize);
}
