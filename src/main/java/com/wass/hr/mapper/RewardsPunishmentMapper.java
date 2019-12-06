package com.wass.hr.mapper;

import com.wass.hr.Basic.persistence.LongPKBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 奖惩制度持久层
 * @author wass
 */
@Mapper
@Component
public interface RewardsPunishmentMapper extends LongPKBaseMapper {

}
