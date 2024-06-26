package com.jzo2o.customer.service;

import com.jzo2o.customer.model.domain.BankAccount;
import com.jzo2o.customer.model.dto.request.BankAccountUpsertReqDTO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 银行账户 服务类
 * </p>
 *
 * @author peng
 * @since 2024-06-26
 */
public interface IBankAccountService extends IService<BankAccount> {

    /**
     * 新增或更新银行账号信息
     * @param bankAccountUpsertReqDTO
     */
    void upsert(BankAccountUpsertReqDTO bankAccountUpsertReqDTO);

}
