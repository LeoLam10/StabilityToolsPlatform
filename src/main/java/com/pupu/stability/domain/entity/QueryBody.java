package com.pupu.stability.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @version 1.0
 * @author: LeoLam
 * @No: 183032
 **/
@Data
public class QueryBody implements Serializable {

    private String query;

    private Boolean dedup;

    private Boolean partial_response;

    private Long start;

    private Long end;

    private Integer step;

}
