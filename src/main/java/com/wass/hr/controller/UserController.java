package com.wass.hr.controller;

import com.wass.hr.Basic.controller.BaseController;
import com.wass.hr.entity.Message;
import com.wass.hr.entity.User;
import com.wass.hr.enums.OperateType;
import com.wass.hr.service.UserService;
import com.wass.hr.util.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 用户控制层
 * @author wass
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	/**
	 *
	 * 用户登录
	 * @param uname
	 * @param passwd
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Message login(String uname, String passwd, HttpServletRequest request, HttpServletResponse response){
		Message msg = null;
		if(StringUtil.isEmpty(uname)|| StringUtil.isEmpty(passwd)){
			msg = Message.error("用户名或者密码为空！");
			return msg;
		}
		try{
			User currentUser=userService.userLogin(uname,passwd);
			if(currentUser==null){
				msg = Message.error("用户名或者密码错误！");
				return msg;
			}else{
				String token = AppUtil.generateUUID();
				LoginContext context = new LoginContext();
				context.setAccount(currentUser.getUserLoginName());
				context.setUserId(currentUser.getUserId());
				context.setUserName(currentUser.getUserName());
				context.setUserPhone(currentUser.getUserPhone());
				SessionUtil.setSession(token, context);
				CookieUtil.addCookie(response, "login_cookie", token, null);

				msg = Message.success("登录成功！");
				msg.putBody("token",token);
				msg.putBody("currentUser",currentUser);
				return msg;
			}
		}catch (Exception e) {
			e.printStackTrace();
			msg = Message.error("用户名或者密码错误！");
			return msg;
		}
	}

	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public Message addUser(User user){
		Message msg  = null;
		int num = userService.addUser(user);
		if(num == 0){
			msg = Message.error("添加用户失败！");
			return msg ;
		}
		msg = Message.success("添加用户成功！");
		return msg;
	}

	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/modifyUser")
	public Message modifyUser(User user){
		Message msg = null;
		int modNum = userService.modifyUser(user);
		if(modNum == 0){
			msg = Message.error("修改用户失败！");
			return msg ;
		}
		msg = Message.success("修改用户成功！");
		return msg;
	}

	/**
	 * 删除用户信息
	 * @param userId
	 * @return
	 */
	@RequestMapping("/delUser")
	@ResponseBody
	public Message delUser(Long userId){
		Message msg = null;
		int delNum = userService.delUser(userId);
		if(delNum == 0){
			msg = Message.error("删除用户失败！");
			return msg ;
		}
		msg = Message.success("删除用户成功！");
		return msg;
	}

	/**
	 * 用户退出
	 * @param token
	 * @return
	 */
	@RequestMapping("/userLogOut")
	@ResponseBody
	public Message userLogOut(String token){
		if (StringUtils.isBlank(token)) {
			token = SessionUtil.getToken();
		}
		LoginContext context = SessionUtil.getSessionNoRequre();
		if(context!=null) {
			log(OperateType.logout, "用户退出");
			SessionUtil.removeSession(token);
		}
		return Message.success("退出成功");
	}
}
