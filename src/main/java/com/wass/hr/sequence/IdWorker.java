package com.wass.hr.sequence;

/**
 * <dl>
 * <dt>IdWorker</dt>
 * <dd>Description:数字主键生成策略</dd>
 * </dl>
 * @author wass
 */
public interface IdWorker {
	/**
	 * 获取随即数字主键
	 * @return id
	 */
	public long getId();
}
