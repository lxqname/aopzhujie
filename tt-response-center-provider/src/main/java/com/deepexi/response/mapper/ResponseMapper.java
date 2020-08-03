package com.deepexi.response.mapper;

import com.deepexi.response.domain.eo.ResponseDo;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/**
 * @description:
 * @program:
 * @author: LiuXinQuan
 * @mail: liuxinquan@deepexi.com
 * @date: 2019/10/12 14:10
 */
public interface ResponseMapper extends JpaRepository<ResponseDo,String> {

    /**
     * 根据注册到响应服务中心的其他服务中心名查询
     * @param registerCenterName dr
     * @return
     */
    List<ResponseDo> getAllByRegisterCenterNameAndDr(String registerCenterName,Integer dr);


}
