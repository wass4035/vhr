package com.wass.hr.service.impl;

import com.wass.hr.Basic.persistence.GenericMapper;
import com.wass.hr.Basic.service.impl.BaseServiceImpl;
import com.wass.hr.entity.OperateLog;
import com.wass.hr.service.OperateLogService;
import org.springframework.stereotype.Service;

@Service
public class OperateLogServiceImpl extends BaseServiceImpl<OperateLog> implements OperateLogService {
    @Override
    protected GenericMapper<OperateLog, Long> getMapper() {
        return null;
    }
}
