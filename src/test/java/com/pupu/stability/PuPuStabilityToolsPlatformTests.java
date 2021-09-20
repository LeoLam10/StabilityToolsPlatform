package com.pupu.stability;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.pupu.stability.common.utils.MapUtils;
import com.pupu.stability.domain.entity.CapacityResultEntity;
import com.pupu.stability.domain.entity.Data;
import com.pupu.stability.domain.vo.capacity.CapacityResultVo;
import com.pupu.stability.service.capacity.ICapacityDataProcessService;
import com.pupu.stability.service.capacity.mysql.IMySqlCapacityDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.*;

@SpringBootTest
class PuPuStabilityToolsPlatformTests {

    @Value("${baseComponent.mysql.qps:http://bj.prometheus.service.consul:9090/api/v1/query_range}")
    private String MySqlQpsQueryUrl;

    @Autowired
    private IMySqlCapacityDataService IMySqlCapacityDataService;

    @Autowired
    private ICapacityDataProcessService capacityDataProcessService;
    @Test
    void contextLoads() {
        //String url="http://bj.prometheus.service.consul:9090/api/v1/query_range";
        Object[] params=new Object[]{"qa","test","10"};
        String format = String.format("irate(mysql_global_status_queries{env=~%s,business_category=~%s}[%s])","qa","test","10m");
        System.out.println(format);



        String query2 = String.format("irate(mysql_global_status_queries{env=~\".*qa.*\",business_category=~\"qa\"}[1m])");
        String query = String.format("irate(mysql_global_status_queries{env=~\"%s\",business_category=~\"%s\"}[%s])",".*qa.*","qa","1m");
        //String query = MessageFormat.format("irate(mysql_global_status_queries{env=~{0}},business_category=~{1}}[{2}])","\".*qa.*\"","\"qa\"","1m");
        System.out.println(query);
        System.out.println(query2);
        HashMap<String, Object> body = MapUtils.build(builder -> builder
                .put("query",query)
                .put("start",1631974121.827)
                .put("end",1631977721.827)
                .put("dedup",true)
                .put("partial_response",true)
                .put("step",14));
        String result = HttpUtil.post(MySqlQpsQueryUrl, body);
        CapacityResultEntity capacityResultEntity = JSON.parseObject(result, CapacityResultEntity.class);
        System.out.println(capacityResultEntity.toString());
    }


    @Test
    void testMysqlCapacity(){
        Data mySqlQpsMax = IMySqlCapacityDataService.getMySqlQpsData("qa|qa-slave-0", 1631974121.827, 1631977721.827, "10m");
        List<CapacityResultVo> capacityResultVoList = capacityDataProcessService.processCapacityData(mySqlQpsMax, 10);
        System.out.println("List:"+capacityResultVoList);
    }

    @Test
    void test(){
        Map<String, Integer> map = new HashMap();
        map.put("1", 8);
        map.put("2", 12);
        map.put("3", 53);
        map.put("4", 33);
        map.put("5", 11);
        map.put("6", 3);
        map.put("7", 3);
        List<Map.Entry<String,Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (o1, o2) -> (o2.getValue() - o1.getValue()));//升序
        System.out.println(list.get(0).getKey());
        System.out.println(list.get(0).getValue());
    }

    @Test
    void testTimeStamp(){

    }
}
