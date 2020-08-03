package com.deepexi.service;

import com.deepexi.response.domain.bo.Response;

import java.util.List;

/**
 * @description:
 * @program:
 * @author: LiuXinQuan
 * @mail: liuxinquan@deepexi.com
 * @date: 2019/10/12 14:26
 */
public interface IResponseService {
    /**
     * 存储响应对象
     * @param response
     * @return
     */
    boolean save(Response response);

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    List<Response> getAllByPage(Integer page,Integer size);
}
