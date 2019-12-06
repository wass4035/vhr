package com.wass.hr.mapper;

import com.wass.hr.Basic.persistence.LongPKBaseMapper;
import com.wass.hr.entity.Salary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 工资表持久层接口
 *
 * @author wass
 */
@Mapper
@Component
public interface SalaryMapper extends LongPKBaseMapper<Salary> {

}
