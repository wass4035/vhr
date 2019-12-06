package com.wass.hr.mapper;

import com.wass.hr.Basic.persistence.LongPKBaseMapper;
import com.wass.hr.entity.AjustSalary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author wass
 */
@Mapper
@Component
public interface AjustSalaryMapper extends LongPKBaseMapper<AjustSalary> {
}
