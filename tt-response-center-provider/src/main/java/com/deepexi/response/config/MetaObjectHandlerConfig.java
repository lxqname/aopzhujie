package com.deepexi.response.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.deepexi.response.extension.AppRuntimeEnv;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {

    public static final String CREATED_AT = "createdAt";
    public static final String TENANT_CODE = "tenantCode";
    public static final String UPDATED_AT = "updatedAt";
    public static final String CREATED_BY = "createdBy";
    public static final String UPDATED_BY = "updatedBy";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Reference(version = "${response.service.version}",check = false)
//    private UcAccountService ucAccountService;

    @Autowired
    private AppRuntimeEnv appRuntimeEnv;

    // mybatis-plus公共字段自动填充，https:// baomidou.oschina.io/mybatis-plus-doc/#/auto-fill
    @Override
    public void insertFill(MetaObject metaObject) {
//        System.out.println("插入方法实体填充");
        setFieldValByName(CREATED_AT, new Date(), metaObject);
        setFieldValByName(TENANT_CODE, appRuntimeEnv.getTenantId(), metaObject);
//        String token = appRuntimeEnv.getToken();
//        if (!StringUtils.isBlank(token)) {
//            try {
//                setFieldValByName(CREATED_BY, ucAccountService.getLoginAccountId(), metaObject);
//            } catch (Exception e) {
//                e.printStackTrace();
//                logger.error("Token格式不正确" + e.getMessage());
//            }
//        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
//        System.out.println("更新方法实体填充");
        setFieldValByName(UPDATED_AT, new Date(), metaObject);
//        String token = appRuntimeEnv.getToken();
//        if (!StringUtils.isBlank(token)) {
//            try {
//                setFieldValByName(UPDATED_BY,ucAccountService.getLoginAccountId(), metaObject);
//            } catch (Exception e) {
//                e.printStackTrace();
//                logger.error("Token格式不正确" + e.getMessage());
//            }
//        }
    }
}