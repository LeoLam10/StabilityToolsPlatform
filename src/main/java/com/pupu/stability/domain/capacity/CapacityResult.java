package com.pupu.stability.domain.capacity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@ApiModel(value="Capacityresult对象", description="容量巡检结果信息")
public class CapacityResult implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "组件id")
    private String componentId;

    @ApiModelProperty(value = "实例id")
    private String instanceId;

    @ApiModelProperty(value = "指标id")
    private String indexId;

    @ApiModelProperty(value = "是否超过警戒水位")
    private Boolean isCritical;

    @ApiModelProperty(value = "结论")
    private String conclusion;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    private Long timeCreate;

    @ApiModelProperty(value = "更新时间")
    private Long timeUpdate;

    @ApiModelProperty(value = "更新用户id")
    private String userIdUpdate;

    @ApiModelProperty(value = "创建用户id")
    private String userIdCreate;


}
