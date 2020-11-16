package com.daop.shardingsphere.entity;

import lombok.Data;

/**
 * @BelongsProject: ShardingSphere
 * @BelongsPackage: com.daop.shardingsphere.entity
 * @Description:
 * @DATE: 2020-11-15 14:27
 * @AUTHOR: Daop
 **/
@Data
public class Product {
    /**
     * 商品ID编号
     */
    private long id;
    /**
     * 商品名称
     */
    private String proName;
    /**
     * 类别ID
     */
    private long catId;
    /**
     * 商品状态
     */
    private int proStatus;
}
