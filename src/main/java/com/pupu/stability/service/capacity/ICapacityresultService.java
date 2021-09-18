package com.pupu.stability.service.capacity;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pupu.stability.domain.capacity.CapacityResult;
/**
 * <p>
 * 容量巡检结果信息 服务类
 * </p>
 *
 * @author maqh
 * @since 2021-09-18
 */
public interface ICapacityresultService extends IService<CapacityResult> {

    /**
     * 查询容量巡检结果信息分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Capacityresult>
     */
    IPage<CapacityResult> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加容量巡检结果信息
     *
     * @param capacityresult 容量巡检结果信息
     * @return int
     */
    int add(CapacityResult capacityresult);

    /**
     * 删除容量巡检结果信息
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改容量巡检结果信息
     *
     * @param capacityresult 容量巡检结果信息
     * @return int
     */
    int updateData(CapacityResult capacityresult);

    /**
     * id查询数据
     *
     * @param id id
     * @return Capacityresult
     */
    CapacityResult findById(Long id);
}
