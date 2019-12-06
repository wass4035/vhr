package com.wass.hr.mapper;


import com.wass.hr.Basic.persistence.LongPKBaseMapper;
import com.wass.hr.entity.OperateLog;
import org.springframework.stereotype.Repository;

/**
 * 操作日志持久层
 *
 * @author wass
 */
@Repository
public interface OperateLogMapper extends LongPKBaseMapper<OperateLog> {

}
