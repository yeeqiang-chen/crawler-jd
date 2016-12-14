package com.yiqiang.crawler.dao;

import com.yiqiang.crawler.pojo.Item;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/11 0011 1:11
 *
 * @author: YEEQiang
 * @version: 1.0
 */
@Repository
public interface ItemDao {

    /**
     * 新增商品
     * @param items
     * @return
     */
    Long insertItems(Collection<Item> items);
}
