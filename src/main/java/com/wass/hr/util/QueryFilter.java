package com.wass.hr.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;

/**
 * 
 * @ClassName: QueryFilter
 * @author wass
 *
 */
public class QueryFilter implements Serializable {
	private static final long serialVersionUID = -3894266496237763631L;
	private Integer pageNumber;// 页码
	private Integer pageSize;// 每页大小
	private String field;// 排序字段
	private String direction;// ASC/DESC
	private Map<String, Object> params = new HashMap<String, Object>(); //查询条件
	
	public QueryFilter(HttpServletRequest request) {
		pageNumber = RequestUtil.getInteger(request, "pageNumber");
		pageSize = RequestUtil.getInteger(request, "pageSize");
		field = RequestUtil.getString(request, "field");
		direction = RequestUtil.getString(request, "direction");
		//排序这符串
		String orderStr = gendirectionStr(field,direction);
		params.put("orderField", orderStr);
		Map<String, String[]> p = request.getParameterMap();
		Object[] keys = p.keySet().toArray();
		for(int i=0;i<keys.length;i++) {
			String key = keys[i].toString();
			if("page".equals(key) || "rows".equals(key) 
					|| "field".equals(key) || "direction".equals(key)) {
				continue;
			}
			String[] vs = p.get(key);
			if(vs != null && vs.length != 0) {
				String value = vs[0];
				if(StringUtils.isNotBlank(value)) {
					params.put(key, value);
				}
			}
		}
	}

	/**
	 * 存储参数
	 * @param key
	 * @param value
	 */
	public void addParam(String key,Object value) {
		params.put(key, value);
	}
	
	public RowBounds getRowBounds() {
		if(pageNumber==null && pageSize == null) {
			return null;
		}
		if(pageNumber==null) {
			pageNumber = 1;
		}
		if(pageSize==null) {
			pageSize = 10;
		}
		int index = pageNumber > 0 ? (pageNumber - 1) * pageSize : 0;
		RowBounds rowBounds = new RowBounds(index,pageSize);
		return rowBounds;
	}
	
	/**
	 * 生成排序段
	 * @Title: gendirectionStr 
	 * @param  fields
	 * @param  directions
	 * @return String 
	 * @throws
	 */
	private String gendirectionStr(String fields,String directions) {
		if(StringUtils.isNotBlank(fields) && StringUtils.isNotBlank(directions)) {
			String[] fieldArray = fields.split(",");
			String[] directionArray = directions.split(",");
			if(fieldArray.length == directionArray.length) {
				StringBuffer sb = new StringBuffer("");
				for(int i=0;i<fieldArray.length;i++) {
					String field =fieldArray[i];
					String direction =directionArray[i];
					if(i==0) {
						sb.append(field)
						  .append(" ")
						  .append(direction);
					} else {
						sb.append(",")
						  .append(field)
						  .append(" ")
						  .append(direction);
					}
				}
				return sb.toString();
			} else {
				return null;
			}
		}
		return null;
	}
	
	public String getfield() {
		return field;
	}
	public void setfield(String field) {
		this.field = field;
	}
	public String getdirection() {
		return direction;
	}
	public void setdirection(String direction) {
		this.direction = direction;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
