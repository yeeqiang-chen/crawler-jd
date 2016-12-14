package com.yiqiang.crawler.pojo;

import com.yiqiang.crawler.util.LuceneUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.Field.Store;

import java.awt.*;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/11 0011 0:47
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Item extends BasePojo {

    /**
     * 商品ID,同时也是商品编号
     */
    private Long id;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品卖点
     */
    private String sellPoint;

    /**
     * 商品价格,单位为:分
     */
    private Long price;

    /**
     * 库存数量
     */
    private Long num;

    /**
     * 商品条形码
     */
    private String barcode;

    /**
     * 商品图片
     */
    private String image;

    /**
     * 所属类目,叶子类目
     */
    private Long cid;

    /**
     * 商品状态:1(正常),2(下架),3(删除)
     */
    private Integer status;

    private ItemDesc itemDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ItemDesc getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(ItemDesc itemDesc) {
        this.itemDesc = itemDesc;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public Document toDocument(){
        Document document = new Document();
        TextField titleTextField = new TextField("title", getTitle(), Store.YES);
        if(StringUtils.contains(getTitle(), "苹果")){ //包含“苹果”的调整得分因子
            titleTextField.setBoost(10);
        }
        document.add(titleTextField);//索引、分词、存储
        document.add(new TextField("sellPoint", getSellPoint(), Store.YES));//索引、分词、存储
        document.add(new LongField("id", getId(), LuceneUtils.FIELD_TYPE_LONG_STORE_NO_INDEX));//不索引、不分词、存储
        document.add(new LongField("price", getPrice(), LuceneUtils.FIELD_TYPE_LONG_STORE_NO_INDEX));//不索引、不分词、存储
        document.add(new Field("image", getImage(), LuceneUtils.FIELD_TYPE_STORE_NO_INDEX));//不索引、不分词、存储
        document.add(new IntField("status", getStatus(), LuceneUtils.FIELD_TYPE_INTEGER_STORE_NO_INDEX));//不索引、不分词、存储
        return document;
    }
}
