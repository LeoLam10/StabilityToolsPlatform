package com.pupu.stability.domain.ro;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
@ApiModel(value="CapacityResultRo", description="容量巡检查询入参")
public class CapacityResultRo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "组件id")
    private String componentId;

    @ApiModelProperty(value = "实例选择类型-10全选 20 选择部分实例 30无需选择则实例 ")
    private Integer instanceChooseType;

    @ApiModelProperty(value = "实例id列表")
    private List<String> instanceIdList;

    @ApiModelProperty(value = "指标选择类型-10全选 20选择部分指标")
    private Integer indexChooseType;

    @ApiModelProperty(value = "指标id列表")
    private List<String> indexIdList;

    @ApiModelProperty(value = "容量巡检查询时间类型 - 10 24小时 20 7天 30 12小时 40 6小时 50 3小时 60 1小时 70自定义时间范围")
    private Integer timeType;

    @ApiModelProperty(value = "容量巡检查询时间列表")
    private List<CapacityQueryTimeRo> timeList;

    @ApiModelProperty(value = "容量巡检变量")
    private Map<String,Object> variables;





}
