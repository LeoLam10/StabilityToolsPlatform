package com.pupu.stability.service.capacity.mysql;

import com.pupu.stability.domain.entity.Data;

/**
 * @version 1.0
 * @author: LeoLam
 * @No: 183032
 **/
public interface IMySqlCapacityDataService {

    /**
     * 查询容量巡检结果信息分页数据
     *
     * @param businessCategory 业务类别-多条用 | 隔开
     * @param start            开始时间
     * @param end              结束时间
     * @param interval         采样间隔 格式示例：1m
     * @return CapacityResultEntity
     */
    Data getMySqlQpsData(String businessCategory, Double start, Double end, String interval);
}
