package com.wass.hr.Basic.service.impl;

import java.util.List;
import java.util.Map;

import com.wass.hr.Basic.persistence.GenericMapper;
import com.wass.hr.util.QueryFilter;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wass.hr.Basic.service.BaseService;

/**
 * <dl>
 * <dt>基础服务封装，包含基本的CRUD功能</dt>
 * <dd>Description:Service层泛型基类，对Service层通用方法进行统一封装</dd>
 * </dl>
 * @author wass
 */
public abstract class BaseServiceImpl<E> implements BaseService<E,Long> {
	protected Logger logger = null;

	public BaseServiceImpl() {
		logger = LoggerFactory.getLogger(getClass().getName());
	}

	/**
	 * 获取数层mapper接口对象，子类必须实现该方法
	 * @return GenericMapper<E, PK> 数据层mapper接口对象
	 */
	protected abstract GenericMapper<E, Long> getMapper();

	/**
	 * 增加记录
	 * @param entity E 要增加的记录对象
	 * @return 受影响的记录条数
	 */
	public int insert(E entity) {
		return getMapper().insert(entity);
	}

	/**
	 * 以主健删除记录
	 * @param id PK要删除的记录主健
	 * @return 受影响的记录条数
	 */
	public int delete(Long id) {
		return getMapper().delete(id);
	}

	/**
	 * 以主健批量伤处记录
	 * @param primaryKeys List<PK> 要删除的记录主健列表
	 * @return 受影响的记录条数
	 */
	public int batchDelete(List<Long> primaryKeys) {
		return getMapper().batchDelete(primaryKeys);
	}

	/**
	 * 更新记录
	 * @param entity E 要更新的记录对象
	 * @return 受影响的记录条数
	 */
	public int update(E entity)  {
		return getMapper().update(entity);
	}

	/**
	 * 根据主健查找记录
	 * @param primaryKey PK 主健值
	 * @return 查找的记录对象
	 */
	public E get(Long primaryKey) {
		return getMapper().get(primaryKey);
	}
	
	/**
	 * 获取符合条件的所有记录
	 * @return List<E> 符合条件的记录列表
	 */
	public List<E> getList() {
		return getMapper().getList();
	}
	
	/**
	 * 获取符合条件的所有记录
	 * @param conditions Map<String, Object> conditions 条件Map
	 * @return List<E> 符合条件的记录列表
	 */
	public List<E> getList(Map<String, Object> conditions) {
		return getMapper().getList(conditions);
	}

	/**
	 * 按查询条件查询
	 * @param queryFilter 条件对象
	 * @return
     */
	public List<E> getList(QueryFilter queryFilter) {
		RowBounds rowBounds = null;
		Map<String, Object> params = null;
		List<E> list = null;
		if(queryFilter!=null) {
			rowBounds = queryFilter.getRowBounds();
			params = queryFilter.getParams();
		}
		if(rowBounds!=null) {
			list = getMapper().getList(params,queryFilter.getRowBounds());
		} else {
			list = getMapper().getList(params);
		}
		
		return list;
	}

}
