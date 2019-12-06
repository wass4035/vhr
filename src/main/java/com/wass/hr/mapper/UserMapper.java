package com.wass.hr.mapper;

import com.wass.hr.Basic.persistence.LongPKBaseMapper;
import com.wass.hr.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户持久层
 */
@Mapper
@Component
public interface UserMapper extends LongPKBaseMapper<User> {
    //用户登录接口
    User userLogin(String uname) ;
    //根据条件查询用户信息
    List<User> getUserList(User user);
}
