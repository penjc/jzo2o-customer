package com.jzo2o.customer.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 银行账户
 * </p>
 *
 * @author peng
 * @since 2024-06-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("bank_account")
@ApiModel(value="BankAccount对象", description="银行账户")
public class BankAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "服务人员/机构id")
    private Long id;

    @ApiModelProperty(value = "类型，2：服务人员，3：服务机构")
    private Integer type;

    @ApiModelProperty(value = "户名")
    private String name;

    @ApiModelProperty(value = "银行名称")
    private String bankName;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "区")
    private String district;

    @ApiModelProperty(value = "网点")
    private String branch;

    @ApiModelProperty(value = "银行账号")
    private String account;

    @ApiModelProperty(value = "开户证明")
    private String accountCertification;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
