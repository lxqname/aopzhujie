package com.deepexi.response.domain.annotatioan;

import java.lang.annotation.*;

/**
 * @description:
 * @program:
 * @author: LiuXinQuan
 * @mail: liuxinquan@deepexi.com
 * @date: 2019/10/14 10:59
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ResponseAnnotation {
    /**
     * 注册进来的服务中心名
     *
     * @return
     */
    String registerCenterName();

    /**
     * 响应节点名称
     *
     * @return
     */
    String name();

    /**
     * 元数据
     *
     * @return
     */
    String metaData();

    /**
     * 项目名称
     *
     * @return
     */
    String projectName();

    /**
     * 请求地址
     *
     * @return
     */
    String url();

    /**
     * 请求参数
     *
     * @return
     */
    String parameters();


}
