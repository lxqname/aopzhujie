package com.deepexi.response.controller;

import com.deepexi.response.domain.annotatioan.ResponseAnnotation;
import com.deepexi.response.domain.bo.Response;
import com.deepexi.service.IResponseService;
import com.deepexi.util.config.Payload;
import com.deepexi.util.constant.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import java.util.List;


/**
 * @description:
 * @program:
 * @author: LiuXinQuan
 * @mail: liuxinquan@deepexi.com
 * @date: 2019/10/12 14:33
 */
@Service
@Path(value = "/api/v1/response")
@Consumes({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class ResponseController {

    @Autowired
    IResponseService responseService;

//    @POST
//    @Path(value = "/")
//    public Payload registerResponseService(List<Response>responseList) {
//        return new Payload(responseService.save(responseList));
//    }

    @GET
    @Path("/")
    @ResponseAnnotation(registerCenterName = "b",name = "b",metaData = "b",projectName = "b",url = "b",parameters = "b")
    public Payload getAllByPage(@QueryParam("page") @DefaultValue("1") Integer page,
                                @QueryParam("size") @DefaultValue("10") Integer size){
        return new Payload(responseService.getAllByPage(page-1,size));
    }

}
