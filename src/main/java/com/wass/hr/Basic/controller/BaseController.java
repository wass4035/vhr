package com.wass.hr.Basic.controller;

import com.wass.hr.entity.OperateLog;
import com.wass.hr.enums.OperateType;
import com.wass.hr.service.OperateLogService;
import com.wass.hr.util.AppUtil;
import com.wass.hr.util.LoginContext;
import com.wass.hr.util.QueryFilter;
import com.wass.hr.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * <dl>
 * <dt>BaseController </dt>
 * <dd>Description:控制层基类</dd>
 * </dl>
 *
 * @author wass
 */
@Controller
public class BaseController {
    @Autowired
    private Validator validator;
    @Autowired
    private OperateLogService operateLogService;

    /**
     * "验证结果"参数名称
     */
    private static final String CONSTRAINT_VIOLATIONS_ATTRIBUTE_NAME = "constraintViolations";

    public Logger logger = null;

    public BaseController() {
        logger = LoggerFactory.getLogger(getClass().getName());
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }

    /**
     * 获取Request
     *
     * @return HttpServletRequest
     */
    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public QueryFilter getQueryFilter() {
        return new QueryFilter(getRequest());
    }

    /**
     * 记录操作日志
     *
     * @param operateType 操作日志类型
     * @param contentKey  日志内容KEY
     * @param args        日志参数
     */
    public void log(OperateType operateType, String contentKey, Object... args) {
        OperateLog v = new OperateLog();
        LoginContext context = SessionUtil.getSessionNoRequre();
        v.setOperateLogId(AppUtil.generateId());
        v.setOperateDateTime(new Date());
        v.setOperateType(operateType);
        v.setOperateContent(contentKey);
        v.setOperatorName(context.getUserName());
        v.setOperatorId(context.getUserId());

        operateLogService.insert(v);
    }

    /**
     * 数据验证
     *
     * @param target 验证对象
     * @param groups 验证组
     * @return 验证结果
     */
    protected boolean isValid(Object target, Class<?>... groups) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(target, groups);
        if (constraintViolations.isEmpty()) {
            return true;
        } else {
            RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
            requestAttributes.setAttribute(CONSTRAINT_VIOLATIONS_ATTRIBUTE_NAME, constraintViolations, RequestAttributes.SCOPE_REQUEST);
            return false;
        }
    }

    /**
     * 数据验证
     *
     * @param type     类型
     * @param property 属性
     * @param value    值
     * @param groups   验证组
     * @return 验证结果
     */
    protected boolean isValid(Class<?> type, String property, Object value, Class<?>... groups) {
        Set<?> constraintViolations = validator.validateValue(type, property, value, groups);
        if (constraintViolations.isEmpty()) {
            return true;
        } else {
            RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
            requestAttributes.setAttribute(CONSTRAINT_VIOLATIONS_ATTRIBUTE_NAME, constraintViolations, RequestAttributes.SCOPE_REQUEST);
            return false;
        }
    }
}
