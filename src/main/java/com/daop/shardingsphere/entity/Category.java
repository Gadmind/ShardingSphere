package com.daop.shardingsphere.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @BelongsProject: ShardingSphere
 * @BelongsPackage: com.daop.shardingsphere.entity
 * @Description: 分类实体类
 * @DATE: 2020-11-16 22:31
 * @AUTHOR: Daop
 **/
@Data
public class Category implements Serializable {
    private long catId;
    private String catName;
    private long parentId;
    private int catStatus;
}
