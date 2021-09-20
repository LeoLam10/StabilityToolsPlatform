package com.pupu.stability.service.capacity.mysql.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.pupu.stability.common.utils.MapUtils;
import com.pupu.stability.domain.entity.CapacityResultEntity;
import com.pupu.stability.domain.entity.Data;
import com.pupu.stability.service.capacity.mysql.IMySqlCapacityDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @version 1.0
 * @author: LeoLam
 * @No: 183032
 **/
@Service
public class IMySqlCapacityDataServiceImpl implements IMySqlCapacityDataService {

    @Value("${baseComponent.mysql.qps.queryUrl:http://bj.prometheus.service.consul:9090/api/v1/query_range}")
    private String MySqlQpsQueryUrl;

    @Value("${baseComponent.mysql.env:.*qa.*}")
    private String environment;

    @Override
    public Data getMySqlQpsData(String businessCategory, Double start, Double end,String interval) {
        String query = String.format("irate(mysql_global_status_queries{env=~\"%s\",business_category=~\"%s\"}[%s])",environment,businessCategory,interval);
        HashMap<String, Object> body = MapUtils.build(builder -> builder
                .put("query",query)
                .put("start",start)
                .put("end",end)
        .put("dedup",true)
        .put("partial_response",true)
        .put("step",60));
        String result = HttpUtil.post(MySqlQpsQueryUrl, body);
        CapacityResultEntity capacityResultEntity = JSON.parseObject(result, CapacityResultEntity.class);
        Data capacityResultEntityData = capacityResultEntity.getData();
        capacityResultEntityData.setComponent("Mysql");
        capacityResultEntityData.setIndex("Qps");
        return capacityResultEntityData;
    }
}
