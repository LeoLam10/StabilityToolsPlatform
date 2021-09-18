package com.pupu.stability.controller.capacity;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pupu.stability.domain.capacity.CapacityResult;
import com.pupu.stability.service.capacity.ICapacityresultService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
@RequestMapping("/capacityresult")
public class CapacityResultController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ICapacityresultService capacityresultService;


    @ApiOperation(value = "新增容量巡检结果信息")
    @PostMapping()
    public int add(@RequestBody CapacityResult capacityresult){
        return capacityresultService.add(capacityresult);
    }

    @ApiOperation(value = "删除容量巡检结果信息")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return capacityresultService.delete(id);
    }

    @ApiOperation(value = "更新容量巡检结果信息")
    @PutMapping()
    public int update(@RequestBody CapacityResult capacityresult){
        return capacityresultService.updateData(capacityresult);
    }

    @ApiOperation(value = "查询容量巡检结果信息分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<CapacityResult> findListByPage(@RequestParam Integer page,
                                                @RequestParam Integer pageCount){
        return capacityresultService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询容量巡检结果信息")
    @GetMapping("{id}")
    public CapacityResult findById(@PathVariable Long id){
        return capacityresultService.findById(id);
    }

}
