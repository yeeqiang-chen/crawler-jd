package com.yiqiang.crawler.pojo;

import java.util.Date;

/**
 * Title:
 * Description: 商品基类
 * Create Time: 2016/12/11 0011 0:44
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public abstract class BasePojo {

    /**
     * 创建时间
     */
    protected Date createDate;

    /**
     * 更新时间
     */
    protected Date updateDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
