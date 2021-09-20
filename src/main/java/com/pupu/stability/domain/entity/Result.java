package com.pupu.stability.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @version 1.0
 * @author: LeoLam
 * @No: 183032
 **/
@Data
public class Result implements Serializable {

    private Metric metric;

    private List<List<Double>> values;

    private String component;

    private String index;

}
