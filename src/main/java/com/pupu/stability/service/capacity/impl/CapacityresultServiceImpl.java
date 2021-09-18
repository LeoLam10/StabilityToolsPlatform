package com.pupu.stability.service.capacity.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pupu.stability.dao.capacity.CapacityResultMapper;
import com.pupu.stability.domain.capacity.CapacityResult;
import com.pupu.stability.service.capacity.ICapacityresultService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 容量巡检结果信息 服务实现类
 * </p>
 *
 * @author maqh
 * @since 2021-09-18
 */
@Service
public class CapacityresultServiceImpl extends ServiceImpl<CapacityResultMapper, CapacityResult> implements ICapacityresultService {

    @Override
    public  IPage<CapacityResult> findListByPage(Integer page, Integer pageCount){
        IPage<CapacityResult> wherePage = new Page<>(page, pageCount);
        CapacityResult where = new CapacityResult();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(CapacityResult capacityresult){
        return baseMapper.insert(capacityresult);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(CapacityResult capacityresult){
        return baseMapper.updateById(capacityresult);
    }

    @Override
    public CapacityResult findById(Long id){
        return  baseMapper.selectById(id);
    }
}
