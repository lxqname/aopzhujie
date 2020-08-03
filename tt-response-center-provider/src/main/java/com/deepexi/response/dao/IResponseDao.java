package com.deepexi.response.dao;

import com.deepexi.response.domain.bo.Response;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @description:
 * @program:
 * @author: LiuXinQuan
 * @mail: liuxinquan@deepexi.com
 * @date: 2019/10/12 14:13
 */
public interface IResponseDao {
    /**
     *  存储响应对象
     * @param response
     * @return
     */
    Response save(Response response);

    /**
     * 分页查询所有
     * @param pageable
     * @return
     */
    List<Response> getAllPage(Pageable pageable);

    /**
     * 根据注册到响应服务中心的其他服务中心名查询
     * @param registerCenterName
     * @return
     */
    List<Response> getAllByRegisterCenterName(String registerCenterName);



}
