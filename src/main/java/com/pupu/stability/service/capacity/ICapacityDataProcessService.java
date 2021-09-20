package com.pupu.stability.service.capacity;

import com.pupu.stability.domain.entity.Data;
import com.pupu.stability.domain.entity.Result;
import com.pupu.stability.domain.vo.capacity.CapacityResultVo;

import java.util.List;

/**
 * @version 1.0
 * @author: LeoLam
 * @No: 183032
 **/
public interface ICapacityDataProcessService {
    /**
     * 处理容量巡检的数据(进行运算,取最大值)
     *
     * @param data 处理前数据
     * @param processType  处理方式 - 10 取最大值
     * @return CapacityResultVo
     */
    List<CapacityResultVo> processCapacityData(Data data, Integer processType);

    /**
     *
     * @param resultList
     * @param component
     * @param index
     * @return
     */
    List<CapacityResultVo> resultList2CapacityResultVoList(List<Result> resultList, String component, String index);
}
