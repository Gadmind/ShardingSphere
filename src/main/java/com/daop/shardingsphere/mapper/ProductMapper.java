package com.daop.shardingsphere.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.daop.shardingsphere.entity.Product;
import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: ShardingSphere
 * @BelongsPackage: com.daop.shardingsphere.mapper
 * @Description:
 * @DATE: 2020-11-15 14:30
 * @AUTHOR: Daop
 **/
@Repository
public interface ProductMapper  extends BaseMapper<Product> {
}
