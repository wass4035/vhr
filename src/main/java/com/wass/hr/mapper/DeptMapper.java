package com.wass.hr.mapper;

import com.wass.hr.Basic.persistence.LongPKBaseMapper;
import com.wass.hr.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface DeptMapper extends LongPKBaseMapper<Department> {
    //查询部门信息
    public List<Department> getDeptList(Map<String, Object> map);
}
