package com.pupu.stability.domain.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @version 1.0
 * @author: LeoLam
 * @No: 183032
 **/
@lombok.Data
public class Data implements Serializable {
    private String resultType;

    private List<Result> result;

    private String component;

    private String index;
}
