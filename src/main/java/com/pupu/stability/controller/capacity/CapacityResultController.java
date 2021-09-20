package com.pupu.stability.controller.capacity;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pupu.stability.domain.ro.CapacityResultRo;
import com.pupu.stability.service.capacity.ICapacityResultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.pupu.stability.domain.vo.capacity.CapacityResultVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 容量巡检结果信息 前端控制器
 * </p>
 *
 * @author maqh
 * @since 2021-09-18
 */
@Api(tags = {"容量巡检结果信息"})
@RestController
@RequestMapping("/capacityResult")
public class CapacityResultController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ICapacityResultService capacityResultService;

    @ApiOperation(value = "更新容量巡检结果信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id"),
            @ApiImplicitParam(name = "remark", value = "备注"),
            @ApiImplicitParam(name = "conclusion", value = "结论")
    })
    @PutMapping("/addInformation/one")
    public CapacityResultVo update(@RequestParam String id,
                      @RequestParam String remark,
                    @RequestParam String conclusion) {
        CapacityResultVo resultVo = capacityResultService.findById(id);
        resultVo.setConclusion(conclusion);
        resultVo.setRemark(remark);
        capacityResultService.updateData(resultVo);
        return resultVo;
    }
    @ApiOperation(value = "批量更新容量巡检结果信息(只对conclusion和remark的修改有效)")
    @PutMapping("/addInformation/batch")
    public List<CapacityResultVo> update(@RequestBody List<CapacityResultVo> capacityResultVoList) {
       return capacityResultVoList;
    }


    @ApiOperation(value = "查询容量巡检结果信息分页数据")
    @PostMapping("/getCapacityResult/pager")
    public IPage<CapacityResultVo> findListByPage(@RequestBody CapacityResultRo capacityResultRo,
                                                  @RequestParam Integer page,
                                                  @RequestParam Integer pageCount) {
        return capacityResultService.findListByPage(capacityResultRo,page, pageCount);
    }


    @ApiOperation(value = "查询容量巡检结果信息数据")
    @PostMapping("/getCapacityResult/online")
    public List<CapacityResultVo> findList(@RequestBody CapacityResultRo capacityResultRo) {
        return capacityResultService.findList(capacityResultRo);
    }

    @ApiOperation(value = "查询容量巡检结果信息数据并导出为Excel文件")

    @PostMapping("/getCapacityResult/excel")
    public String findListExportByExcel(@RequestBody CapacityResultRo capacityResultRo) {
        capacityResultService.findList(capacityResultRo);
        return "Excel.file";
    }

    @ApiOperation(value = "id查询容量巡检结果信息")
    @GetMapping("/getCapacityResult/{id}")
    public CapacityResultVo findById(@PathVariable String id) {
        return capacityResultService.findById(id);
    }

}
