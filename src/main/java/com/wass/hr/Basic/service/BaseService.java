package com.wass.hr.Basic.service;

import com.wass.hr.util.QueryFilter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseService<E, PK extends Serializable> {

	/**
	 * 增加记录
	 * @param entity E 要增加的记录对象
	 * @return int 受影响的记录条数
	 */
	public int insert(E entity);

	/**
	 * 以主健删除记录
	 * @param id PK 要删除的记录主健
	 * @return int 受影响的记录条数
	 */
	public int delete(Long id);
	
	/**
	 * 以主健批量伤处记录
	 * @param primaryKeys List<PK> 要删除的记录主健列表
	 * @return int 受影响的记录条数
	 */
	public int batchDelete(List<Long> primaryKeys);

	/**
	 * 更新记录
	 * @param entity E 要更新的记录对象
	 * @return int 受影响的记录条数
	 */
	public int update(E entity);

	/**
	 * 根据主健查找记录
	 * @param primaryKey PK 主健值
	 * @return E 查找的记录对象
	 */
	public E get(Long primaryKey);
	
	/**
	 * 获取符合条件的所有记录
	 * @return List<E> 符合条件的记录列表
	 */
	public List<E> getList();
	
	/**
	 * 获取符合条件的所有记录
	 * @param conditions Map<String, Object> conditions 条件Map
	 * @return List<E> 符合条件的记录列表
	 */
	public List<E> getList(Map<String, Object> conditions);
	
	/**
	 * 按查询条件查询
	 * @Title: getList 
	 * @param @param queryFilter
	 * @param @return 
	 * @return List<E> 
	 * @throws
	 */
	public List<E> getList(QueryFilter queryFilter);
}
