package com.deepexi.response.aop;

import com.deepexi.response.domain.annotatioan.ResponseAnnotation;
import com.deepexi.response.domain.bo.Response;
import com.deepexi.service.IResponseService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * @description:
 * @program:
 * @author: LiuXinQuan
 * @mail: liuxinquan@deepexi.com
 * @date: 2019/10/14 15:02
 */
@Component
@Aspect
public class ResponseAnnotationAop {

    @Resource
    IResponseService responseService;

    private static Logger logger = LoggerFactory.getLogger(ResponseAnnotationAop.class);

    @Around("@annotation(responseAnnotation)")
    public void run(ProceedingJoinPoint pjp, ResponseAnnotation responseAnnotation) {
        try {
            pjp.proceed();
            Response response = new Response();
            response.setRegisterCenterName(responseAnnotation.registerCenterName());
            response.setName(responseAnnotation.name());
            response.setMetaData(responseAnnotation.metaData());
            response.setProjectName(responseAnnotation.projectName());
            response.setUrl(responseAnnotation.url());
            response.setParameters(responseAnnotation.parameters());
            responseService.save(response);
            logger.info(responseAnnotation.parameters());
            logger.info("其他服务注册成功");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}

