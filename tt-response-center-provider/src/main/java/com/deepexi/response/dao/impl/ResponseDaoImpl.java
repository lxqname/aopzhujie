package com.deepexi.response.dao.impl;

import com.deepexi.response.dao.IResponseDao;
import com.deepexi.response.domain.bo.Response;
import com.deepexi.response.domain.eo.ResponseDo;
import com.deepexi.response.mapper.ResponseMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @program:
 * @author: LiuXinQuan
 * @mail: liuxinquan@deepexi.com
 * @date: 2019/10/12 14:13
 */
@Service
public class ResponseDaoImpl implements IResponseDao {

    @Autowired
    ResponseMapper responseMapper;

    @Override
    public Response save(Response response) {
        if (!ObjectUtils.isEmpty(response)){
            ResponseDo responseDo = new ResponseDo();
            BeanUtils.copyProperties(response,responseDo);
            responseDo.setDr(0);
            responseMapper.save(responseDo);
            BeanUtils.copyProperties(responseDo,response);
        }
        return response;
    }

    @Override
    public List<Response> getAllPage(Pageable pageable) {
        ResponseDo responseDo = new ResponseDo();
        responseDo.setDr(0);
        Example<ResponseDo> example = Example.of(responseDo);
        return responseMapper.findAll(example,pageable).stream().map(t->{
            Response response = new Response();
            BeanUtils.copyProperties(t,response);
            return response;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Response> getAllByRegisterCenterName(String registerCenterName) {
        return responseMapper.getAllByRegisterCenterNameAndDr(registerCenterName,0).stream().map(t->{
             Response response = new Response();
             BeanUtils.copyProperties(t,response);
             return response;
         }).collect(Collectors.toList());
    }


}
