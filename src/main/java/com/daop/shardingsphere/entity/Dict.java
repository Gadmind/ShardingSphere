package com.daop.shardingsphere.entity;

import lombok.Data;

/**
 * @BelongsProject: ShardingSphere
 * @BelongsPackage: com.daop.shardingsphere.entity
 * @Description:
 * @DATE: 2020-11-16 23:11
 * @AUTHOR: Daop
 **/
@Data
public class Dict {
    private long dictId;
    private String dictCode;
    private String dictValue;
}
