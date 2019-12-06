package com.wass.hr.mapper;

import com.wass.hr.Basic.persistence.LongPKBaseMapper;
import com.wass.hr.entity.StaffRemove;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 员工调动信息持久层接口
 *
 * @author wass
 */

@Mapper
@Component
public interface StaffRemoveMapper extends LongPKBaseMapper<StaffRemove> {
}
