package com.company.project.core;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Service 层基础接口，其他 Service 接口 请继承该接口
 *
 * @author hongying
 */
public interface Service<T> {

    /**
     * 持久化
     *
     * @param model
     */
    void save(T model);

    /**
     * 批量持久化
     *
     * @param models
     */
    void save(List<T> models);

    /**
     * 通过主鍵刪除
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 批量刪除 eg：ids -> “1,2,3,4”
     *
     * @param ids
     */
    void deleteByIds(String ids);

    /**
     * 更新
     *
     * @param model
     */
    void update(T model);

    /**
     * 通过ID查找
     *
     * @param id
     * @return
     */
    T findById(Integer id);

    /**
     * 通过 Model 中某个成员变量名称（非数据表中 column 的名称）查找
     * value 需符合 unique 约束
     *
     * @param fieldName
     * @param value
     * @return
     * @throws TooManyResultsException
     */
    T findBy(String fieldName, Object value) throws TooManyResultsException;

    /**
     * 通过多个 ID 查找 eg：ids -> “1,2,3,4”
     *
     * @param ids
     * @return
     */
    List<T> findByIds(String ids);

    /**
     * 根据条件查找
     *
     * @param condition
     * @return
     */
    List<T> findByCondition(Condition condition);

    /**
     * 获取所有
     *
     * @return
     */
    List<T> findAll();

}
