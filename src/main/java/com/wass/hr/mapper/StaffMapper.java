package com.wass.hr.mapper;

import com.wass.hr.Basic.persistence.LongPKBaseMapper;
import com.wass.hr.entity.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 员工信息持久层
 * @author wass
 */
@Mapper
@Component
public interface StaffMapper extends LongPKBaseMapper<Staff> {

}
