package com.deepexi.response.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.deepexi.common.util.UuidUtils;
import com.deepexi.response.dao.IResponseDao;
import com.deepexi.response.domain.annotatioan.ResponseAnnotation;
import com.deepexi.response.domain.bo.Response;
import com.deepexi.service.IResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @description:
 * @program:
 * @author: LiuXinQuan
 * @mail: liuxinquan@deepexi.com
 * @date: 2019/10/12 14:25
 */
@Component
@Service(version = "${demo.service.version}")
public class ResponseServiceImpl implements IResponseService {

    @Autowired
    IResponseDao responseDao;

    @Override
    public boolean save(Response response) {
        if (!ObjectUtils.isEmpty(response)) {
            List<Response> responseList = responseDao.getAllByRegisterCenterName(response.getRegisterCenterName());
            //进行去重处理
            //将该中心服务的所有dr状态改变
            this.compare(response, responseList);
            return true;
        }
        return false;
    }

    /**
     * 存储时进行去重处理
     * @param response
     * @param responseList
     */
    public void compare(Response response, List<Response> responseList) {
      responseList.forEach(t->{
          if (!ObjectUtils.isEmpty(t.getUrl())&&t.getUrl().equals(response.getUrl())){
              System.out.println(t.getId());
              response.setId(t.getId());
              responseDao.save(response);
              return;
          }
          if (t==responseList.get(responseList.size()-1)){
              responseDao.save(response);
          }
      });
    }



    @Override
    public List<Response> getAllByPage(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return responseDao.getAllPage(pageable);
    }

}
