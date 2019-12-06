package com.wass.hr.entity;

import java.util.Date;

import com.wass.hr.enums.OperateType;
import com.wass.hr.util.JsonTimeSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 操作日志类
 *
 * @author wass
 */
public class OperateLog {
    /**
     * 主键
     */
    private Long operateLogId;
    /**
     * 操作者ID
     */
    private Long operatorId;
    /**
     * 操作类型
     */
    private OperateType operateType;
    /**
     * 操作时间
     */
    @JsonSerialize(using = JsonTimeSerializer.class)
    private Date operateDateTime;
    /**
     * 日志内容
     */
    private String operateContent;

    //-------------临时变量-----------------
    private String operatorName; //操作者名字

    public String getOperateTypeName() {
        if (operateType != null) {
            return operateType.getText();
        }
        return null;
    }

    public Long getOperateLogId() {
        return operateLogId;
    }

    public void setOperateLogId(Long operateLogId) {
        this.operateLogId = operateLogId;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public OperateType getOperateType() {
        return operateType;
    }

    public void setOperateType(OperateType operateType) {
        this.operateType = operateType;
    }

    public Date getOperateDateTime() {
        return operateDateTime;
    }

    public void setOperateDateTime(Date operateDateTime) {
        this.operateDateTime = operateDateTime;
    }

    public String getOperateContent() {
        return operateContent;
    }

    public void setOperateContent(String operateContent) {
        this.operateContent = operateContent;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}
