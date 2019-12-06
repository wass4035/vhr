package com.wass.hr.service;

import com.wass.hr.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务接口
 */
public interface UserService {
    /**
     * 用户登录接口
     * @param uname
     * @param passwd
     * @return
     */
    public User userLogin(String uname, String passwd);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> getUserList(User user);

    /**
     * 新增用户信息
     * @param user 用户实体
     * @return
     */
    public int addUser(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public int modifyUser(User user);

    /**
     * 删除用户信息
     * @param userId
     * @return
     */
    public int delUser(Long userId);
}
