package com.pupu.stability.service.capacity.impl;

import com.google.common.collect.Lists;
import com.pupu.stability.domain.entity.Data;
import com.pupu.stability.domain.entity.Result;
import com.pupu.stability.domain.vo.capacity.CapacityResultVo;
import com.pupu.stability.service.capacity.ICapacityDataProcessService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version 1.0
 * @author: LeoLam
 * @No: 183032
 **/
@Service
public class CapacityDataProcessServiceImpl implements ICapacityDataProcessService {

    @Override
    public List<CapacityResultVo> processCapacityData(Data data, Integer processType) {
        List<Result> resultList = data.getResult();
        String index = data.getIndex();
        String component = data.getComponent();
        List<CapacityResultVo> capacityResultVoList = resultList2CapacityResultVoList(resultList, component, index);
        return capacityResultVoList;
    }


    @Override
    public List<CapacityResultVo> resultList2CapacityResultVoList(List<Result> resultList, String component, String index) {
        List<CapacityResultVo> capacityResultVoList = Lists.newArrayList();
        Map<Double, Double> resultMap = new HashMap<>();
        Map<List<Double>, List<Double>> listListMap = resultList.stream()
                .collect(Collectors.toMap(a -> a.getValues()
                                .stream()
                                .map(b -> b.get(1))
                                .collect(Collectors.toList())
                        , a -> a.getValues()
                                .stream()
                                .map(b ->b.get(0))
                                .collect(Collectors.toList())));
        Iterator<Map.Entry<List<Double>, List<Double>>> entries = listListMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<List<Double>, List<Double>> entry = entries.next();
            List<Double> keys = entry.getKey();
            List<Double> values = entry.getValue();
            Map<Double, Double> collect = values.stream().
                    collect(Collectors.toMap(k -> k, k -> keys.get(values.indexOf(k))));
            List<Map.Entry<Double, Double>> arrayList = new ArrayList(collect.entrySet());
            Collections.sort(arrayList, (o1, o2) -> (int) (o2.getValue() - o1.getValue()));
            resultMap.put(arrayList.get(0).getKey(), arrayList.get(0).getValue());
            CapacityResultVo capacityResultVo = new CapacityResultVo();
            capacityResultVo.setId(UUID.randomUUID().toString());
            capacityResultVo.setTimeHappened(arrayList.get(0).getKey());
            capacityResultVo.setContext(arrayList.get(0).getValue().toString());
            capacityResultVo.setComponentId(component);
            capacityResultVo.setIndexId(index);
            capacityResultVoList.add(capacityResultVo);
        }
        return capacityResultVoList;
    }
}
