package com.pupu.stability.domain.entity;

/**
 * @version 1.0
 * @author: LeoLam
 * @No: 183032
 **/

import lombok.Data;

import java.io.Serializable;

/**
 * Copyright 2021 bejson.com
 */

@Data
public class Metric implements Serializable {

    private String business_category;
    private String env;
    private String instance;
    private String job;
    private String service;

}