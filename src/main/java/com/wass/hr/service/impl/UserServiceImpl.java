package com.wass.hr.service.impl;

import com.wass.hr.Basic.persistence.GenericMapper;
import com.wass.hr.Basic.service.impl.BaseServiceImpl;
import com.wass.hr.entity.User;
import com.wass.hr.mapper.UserMapper;
import com.wass.hr.service.UserService;
import com.wass.hr.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现类
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    protected GenericMapper<User, Long> getMapper() {
        return userMapper;
    }

    /**
     * 用户登录
     * @param uname
     * @param passwd
     * @return
     */
    public User userLogin(String uname,String passwd) {
        User user = userMapper.userLogin(uname);
        if(user == null){
            return null ;
        }else{
            if(passwd.equals(user.getUserPasswd())){
                return user;
            }else {
                return null;
            }
        }
    }

    /**
     * 获取用户信息
     * @param user  用户信息
     * @return
     */
    public List<User> getUserList(User user) {
        List<User> userList = userMapper.getUserList(user);
        return userList;
    }

    /**
     * 新增用户
     * @param user 用户实体
     * @return
     */
    public int addUser(User user) {
        //获取主键ID
        Long uid = AppUtil.generateId();
        user.setUserId(uid);
        return userMapper.insert(user);
    }

    /**
     * 修改用户信息
     * @param user 用户信息
     * @return
     */
    public int modifyUser(User user) {
        int modNum = userMapper.update(user);
        return modNum;
    }

    /**
     * 删除用户信息
     * @param userId  用户ID
     * @return
     */
    public int delUser(Long userId) {
        int delNum = userMapper.delete(userId);
        return delNum;
    }
}
