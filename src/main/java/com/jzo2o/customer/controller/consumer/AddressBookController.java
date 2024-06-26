package com.jzo2o.customer.controller.consumer;

import com.jzo2o.api.customer.dto.response.AddressBookResDTO;
import com.jzo2o.common.model.PageResult;
import com.jzo2o.common.utils.BeanUtils;
import com.jzo2o.customer.model.domain.AddressBook;
import com.jzo2o.customer.model.dto.request.AddressBookPageQueryReqDTO;
import com.jzo2o.customer.model.dto.request.AddressBookUpsertReqDTO;
import com.jzo2o.customer.service.IAddressBookService;
import com.jzo2o.mvc.utils.UserContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.checkerframework.checker.units.qual.A;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    @GetMapping("/page")
    @ApiOperation("地址簿分页查询")
    public PageResult<AddressBookResDTO> page(AddressBookPageQueryReqDTO addressBookPageQueryReqDTO){
        return addressBookService.page(addressBookPageQueryReqDTO);
    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查询地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "地址薄id", required = true, dataTypeClass = Long.class)
    })
    public AddressBookResDTO detail(@PathVariable Long id){
        AddressBook byId = addressBookService.getById(id);
        return BeanUtils.toBean(byId, AddressBookResDTO.class);
    }

    @PutMapping("/{id}")
    @ApiOperation("地址簿修改")
    public void update(@PathVariable Long id, @RequestBody AddressBookUpsertReqDTO addressBookUpsertReqDTO){
        addressBookService.update(id, addressBookUpsertReqDTO);
    }

    @DeleteMapping("/batch")
    @ApiOperation("地址簿批量删除")
    public void logicallyDelete(@RequestBody List<Long> ids){
        addressBookService.removeByIds(ids);
    }

    @PutMapping("/default")
    @ApiOperation("设置默认地址")
    public void updateDefaultStatus(@NotNull(message = "id不能为空") @RequestParam("id") Long id,
                                    @NotNull(message = "状态值不能为空") @RequestParam("flag") Integer flag) {
        //当前登录用户id
        Long userId = UserContext.currentUserId();
        addressBookService.updateDefaultStatus(userId, id, flag);
    }

    @GetMapping("/default")
    @ApiOperation("获取默认地址")
    public AddressBookResDTO defaultAddress() {
        return addressBookService.defaultAddress();
    }
}
