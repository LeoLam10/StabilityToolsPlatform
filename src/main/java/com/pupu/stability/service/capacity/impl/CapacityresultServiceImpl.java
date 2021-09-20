package com.pupu.stability.service.capacity.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pupu.stability.dao.capacity.CapacityResultMapper;
import com.pupu.stability.domain.entity.Data;
import com.pupu.stability.domain.ro.CapacityResultRo;
import com.pupu.stability.service.capacity.ICapacityDataProcessService;
import com.pupu.stability.service.capacity.ICapacityResultService;
import com.pupu.stability.service.capacity.mysql.IMySqlCapacityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pupu.stability.domain.vo.capacity.CapacityResultVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 容量巡检结果信息 服务实现类
 * </p>
 *
 * @author maqh
 * @since 2021-09-18
 */
@Service
public class CapacityResultServiceImpl extends ServiceImpl<CapacityResultMapper, CapacityResultVo> implements ICapacityResultService {

    @Autowired
    private IMySqlCapacityDataService mySqlCapacityDataService;

    @Autowired
    private ICapacityDataProcessService capacityDataProcessService;

    @Override
    public  IPage<CapacityResultVo> findListByPage(CapacityResultRo capacityResultRo, Integer page, Integer pageCount){
        IPage<CapacityResultVo> wherePage = new Page<>(page, pageCount);
        CapacityResultVo where = new CapacityResultVo();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public List<CapacityResultVo> findList(CapacityResultRo capacityResultRo) {
        Map<String, Object> variables = capacityResultRo.getVariables();
        Double timeStart = capacityResultRo.getTimeList().get(0).getTimeStart();
        Double timeEnd = capacityResultRo.getTimeList().get(0).getTimeEnd();
        Data businessCategory = mySqlCapacityDataService.getMySqlQpsData((String) variables.get("businessCategory"), timeStart, timeEnd, "10m");
        List<CapacityResultVo> capacityResultVoList = capacityDataProcessService.processCapacityData(businessCategory, 10);
        return capacityResultVoList;
    }

    @Override
    public int updateData(CapacityResultVo capacityResult){
        return baseMapper.updateById(capacityResult);
    }

    @Override
    public CapacityResultVo findById(String id){
        return  baseMapper.selectById(id);
    }
}
