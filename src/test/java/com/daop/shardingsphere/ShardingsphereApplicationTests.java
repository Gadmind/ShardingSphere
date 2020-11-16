package com.daop.shardingsphere;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.daop.shardingsphere.entity.Category;
import com.daop.shardingsphere.entity.Dict;
import com.daop.shardingsphere.entity.Product;
import com.daop.shardingsphere.mapper.CategoryMapper;
import com.daop.shardingsphere.mapper.DictMapper;
import com.daop.shardingsphere.mapper.ProductMapper;
import com.daop.shardingsphere.util.SnowFlakeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootTest
class ShardingsphereApplicationTests {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private DictMapper dictMapper;

    private AtomicLong atomic = new AtomicLong(0);
    private SnowFlakeUtil snowFlake = new SnowFlakeUtil(0, 0);

    //==============================公共字典操作==============================

    @Test
    void dictAdd() {
        Dict dict = new Dict();
        dict.setDictId(1L);
        dict.setDictCode("0");
        dict.setDictValue("库存充足");
        dictMapper.insert(dict);
    }

    @Test
    void dictDel() {
        QueryWrapper<Dict> wrapper = new QueryWrapper<>();
        //设置 id 值
        wrapper.eq("dict_id", 1328359402335371264L);
        dictMapper.delete(wrapper);
    }


    //==============================垂直分库操作==============================
    @Test
    void verticalLibraryAdd() {
        Category category = new Category();
        category.setCatId(10L);
        category.setCatName("技术类");
        category.setParentId(0L);
        category.setCatStatus(0);
        categoryMapper.insert(category);
    }

    @Test
    void verticalLibrarySelect() {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        //设置 id 值
        wrapper.eq("cat_id", 10L);
        Category category = categoryMapper.selectOne(wrapper);
        System.out.println(category);
    }

    //==============================水平分库测试==============================
    @Test
    void horizontalSubLibraryAdd() {
        Product product = new Product();
        product.setId(snowFlake.nextId());
        product.setProName("Java 从入门到精通");
        //根据CatId进行分库
        product.setCatId(111L);
        product.setProStatus(1);
        productMapper.insert(product);
    }

    @Test
    void horizontalSubLibrarySelect() {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        //设置 id 值
        wrapper.eq("id", 1328336445961666560L);
        //设置 cat_id 值
        wrapper.eq("cat_id", 1111L);
//        Product product = productMapper.selectOne(wrapper);
        List<Product> products = productMapper.selectList(null);
        for (Product product : products) {
            System.out.println(product);
        }
    }

    //==============================水平分表测试==============================
    @Test
    void levelScoreTableAdd() {
        for (int i = 1; i <= 10; i++) {
            Product product = new Product();
            product.setId(atomic.incrementAndGet());
            product.setProName("Java Learn" + i);
            product.setCatId(1L);
            product.setProStatus(1);
            productMapper.insert(product);

        }
    }

    @Test
    void levelScoreTableSelect() {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
//        wrapper.eq("id", 1);
        wrapper.eq("pro_name", "Java Learn2");
        Product product = productMapper.selectOne(wrapper);
//        List<Product> products = productMapper.selectList(null);
//        for (Product product : products) {

        System.out.println(product);
//        }
    }

}
