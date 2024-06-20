package com.jzo2o.customer.controller.consumer;

import com.jzo2o.customer.model.domain.AddressBook;
import com.jzo2o.customer.model.dto.request.AddressBookUpsertReqDTO;
import com.jzo2o.customer.service.IAddressBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * author peng
 * description
 * date 2024/6/21
 */
@RestController("consumerAddressBookController")
@RequestMapping("/consumer/address-book")
@Api(tags = "用户端 - 地址簿相关接口")
public class AddressBookController {

    @Resource
    private IAddressBookService addressBookService;

    @PostMapping
    @ApiOperation("地址簿新增")
    public void add(@RequestBody AddressBookUpsertReqDTO addressBookUpsertReqDTO){
        addressBookService.add(addressBookUpsertReqDTO);
    }
}
