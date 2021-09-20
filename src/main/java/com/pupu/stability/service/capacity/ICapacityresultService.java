package com.pupu.stability.service.capacity;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pupu.stability.domain.ro.CapacityResultRo;
import com.pupu.stability.domain.vo.capacity.CapacityResultVo;

import java.util.List;

/**
 * <p>
 * 容量巡检结果信息 服务类
 * </p>
 *
 * @author maqh
 * @since 2021-09-18
 */
public interface ICapacityResultService extends IService<CapacityResultVo> {

    /**
     * 查询容量巡检结果信息分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Capacityresult>
     */
    IPage<CapacityResultVo> findListByPage(CapacityResultRo capacityResultRo,Integer page, Integer pageCount);

    /**
     * 查询容量巡检结果信息数据
     *
     * @return capacityResultRo
     * @return IPage<CapacityResult>
     */
    List<CapacityResultVo> findList(CapacityResultRo capacityResultRo);


    /**
     * 修改容量巡检结果信息
     *
     * @param capacityResultVo 容量巡检结果信息
     * @return int
     */
    int updateData(CapacityResultVo capacityResultVo);

    /**
     * id查询数据
     *
     * @param id id
     * @return CapacityResult
     */
    CapacityResultVo findById(String id);
}
