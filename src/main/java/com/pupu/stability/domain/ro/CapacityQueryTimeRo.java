package com.pupu.stability.domain.ro;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 容量巡检结果信息
 * </p>
 *
 * @author maqh
 * @since 2021-09-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CapacityQueryTimeRo", description="容量巡检时间查询入参")
public class CapacityQueryTimeRo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "容量巡检开始时间")
    private Double timeStart;

    @ApiModelProperty(value = "容量巡检结束时间")
    private Double timeEnd;







}
