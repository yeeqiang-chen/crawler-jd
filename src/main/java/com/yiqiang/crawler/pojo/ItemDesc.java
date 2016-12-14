package com.yiqiang.crawler.pojo;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/11 0011 0:53
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class ItemDesc extends BasePojo{

    /**
     * 商品ID
     */
    private Long itemId;

    /**
     * 商品描述
     */
    private String itemDesc;

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
