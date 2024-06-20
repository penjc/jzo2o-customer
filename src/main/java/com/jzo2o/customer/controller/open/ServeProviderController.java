package com.jzo2o.customer.controller.open;

import com.jzo2o.customer.model.dto.request.InstitutionRegisterReqDTO;
import com.jzo2o.customer.service.IServeProviderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * author peng
 * description 机构端 前端控制器
 * date 2024/6/21
 */
@RestController("openServeProviderController")
@RequestMapping("/open/serve-provider")
public class ServeProviderController {
    @Resource
    private IServeProviderService serveProviderService;
    /**
     * 机构注册
     */
    @PostMapping("/institution/register")
    @ApiOperation("机构注册接口")
    public void institutionRegister(@RequestBody InstitutionRegisterReqDTO institutionRegisterReqDTO){
        serveProviderService.registerInstitution(institutionRegisterReqDTO);
    }
}
