package com.wass.hr.util;

import com.wass.hr.sequence.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;


/**
 * <dl>
 * <dt>AppUtil</dt>
 * <dd>Description:平台工具类</dd>
 * </dl>
 * @author wass
 */
public class AppUtil implements ApplicationContextAware{
	
	private static Logger logger = LoggerFactory.getLogger(AppUtil.class);
	
	private static ApplicationContext applicationContext;
	
	private static ServletContext servletContext;
	
	public static void setServletContext(ServletContext _servletContext) {
		servletContext = _servletContext;
	}

	public static ServletContext getServletContext() throws Exception {
		return servletContext;
	}
	
	/**
	 * 设置Spring上下文
	 * @param context
	 * @throws BeansException
	 */
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		applicationContext = context;
	}

	/**
	 * 获取Spring上下文
	 * @return
	 */
	public static ApplicationContext getContext() {
		return applicationContext;
	}
	
	public static String getAppAbsolutePath() {
		return servletContext.getRealPath("/");
	}

	public static String getRealPath(String path) {
		return servletContext.getRealPath(path);
	}
	
	public static String getClasspath() {
		String classPath = Thread.currentThread().getContextClassLoader()
				.getResource("").getPath();
		String rootPath = "";

		if ("\\".equals(File.separator)) {
			rootPath = classPath.substring(1);
			rootPath = rootPath.replace("/", "\\");
		}

		if ("/".equals(File.separator)) {
			rootPath = classPath.substring(1);
			rootPath = rootPath.replace("\\", "/");
		}
		return rootPath;
	}
	
	public static <T> T getBean(Class<T> cls) {
		return applicationContext.getBean(cls);
	}

	public static Object getBean(String beanId) {
		return applicationContext.getBean(beanId);
	}
	
	/**
	 * 获取实例
	 * 
	 * @param name
	 *            Bean名称
	 * @param type
	 *            Bean类型
	 * @return 实例
	 */
	public static <T> T getBean(String name, Class<T> type) {
		return applicationContext.getBean(name, type);
	}
	
	/**
	 * 获取系统String值参数
	 * @Title: getConfigString
	 * @param  key
	 * @return String
	 * @throws
	 */
	public static String getConfigString(String key) {
		Properties p = new Properties();
		String v= null;
		try{
			InputStream in = AppUtil.class.getClassLoader().getResourceAsStream("app.properties");
			p.load(in);
			in.close();
			v= p.getProperty(key);
		}catch(Exception e){
			logger.error("load appconfie error",e);
		}
		return v;
	}
	
	public static void setConfigString(String key,String value) {
		Properties p = new Properties();
		try{
			InputStream in = AppUtil.class.getClassLoader().getResourceAsStream("app.properties");
			p.load(in);
			p.setProperty(key, value);
			FileOutputStream fos = new FileOutputStream(getClasspath() + "/app.properties");
			p.store(fos, "");
			in.close();
			fos.close();
		}catch(Exception e){
			logger.error("set appconfie error",e);
		}
	}
	
	/**
	 * 获取系统Boolean值参数
	 * @Title: getConfigBoolean
	 * @param  key
	 * @return String
	 * @throws
	 */
	public static Boolean getConfigBoolean(String key) {
		Properties p = new Properties();
		Boolean v= null;
		try{
			InputStream in = AppUtil.class.getClassLoader().getResourceAsStream("app.properties");
			p.load(in);
			in.close();
			String s= p.getProperty(key);
			v = Boolean.valueOf(s);
		}catch(Exception e){
			logger.error("load config boolean error",e);
		}
		return v;
	}
	
	/**
	 * 获取软件唯一标识
	 * @return
	 */
//	public static String getAppId() {
//		String appId = getConfigString("appId");
//		if(StringUtils.isBlank(appId)) {
//			appId = Long.toHexString(AppUtil.generateId());
//			setConfigString("appId", appId);
//		}
//		return appId;
//	}

	/**
	 * 系统 生成主键
	 * @Title: generateId
	 * @param 
	 * @return long
	 * @throws
	 */
	public static long generateId() {
		long id = 0L;
		try {
			IdWorker idworker = null;
			idworker = (IdWorker)getBean("idWorker");
			id = idworker.getId();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return id;
	}
	
	/**
	 * 把以 , 分割的ID字符串转化为集合
	 * @param ids
	 * @return
	 */
	public static List<Long> convertIds(String ids) {
		List<Long> idList = new ArrayList<Long>();
		if(StringUtils.isNotBlank(ids)) {
			String[] idsArray = ids.trim().split(",");
			if(idsArray.length>0) {
				for(String i : idsArray) {
					try {
						long id = Long.valueOf(i);
						idList.add(id);
					} catch (NumberFormatException e) {
						logger.error("number format error",e);
					}
				}
			}
		}
		return idList;
	}
	
	/**
	 * 生成UUID
	 * @return
	 */
	public static String generateUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "");
	}

}
