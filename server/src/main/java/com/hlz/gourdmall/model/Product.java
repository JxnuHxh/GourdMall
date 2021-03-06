package com.hlz.gourdmall.model;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.pid
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    private String pid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.pname
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    private String pname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.market_price
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    private Double marketPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.shop_price
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    private Double shopPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.pimg
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    private String pimg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.pdate
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    private Date pdate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.is_hot
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    private Integer isHot;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.pdesc
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    private String pdesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.pflag
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    private Integer pflag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.cid
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    private String cid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.pid
     *
     * @return the value of product.pid
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public String getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.pid
     *
     * @param pid the value for product.pid
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.pname
     *
     * @return the value of product.pname
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public String getPname() {
        return pname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.pname
     *
     * @param pname the value for product.pname
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.market_price
     *
     * @return the value of product.market_price
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public Double getMarketPrice() {
        return marketPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.market_price
     *
     * @param marketPrice the value for product.market_price
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.shop_price
     *
     * @return the value of product.shop_price
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public Double getShopPrice() {
        return shopPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.shop_price
     *
     * @param shopPrice the value for product.shop_price
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.pimg
     *
     * @return the value of product.pimg
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public String getPimg() {
        return pimg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.pimg
     *
     * @param pimg the value for product.pimg
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public void setPimg(String pimg) {
        this.pimg = pimg == null ? null : pimg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.pdate
     *
     * @return the value of product.pdate
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public Date getPdate() {
        return pdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.pdate
     *
     * @param pdate the value for product.pdate
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.is_hot
     *
     * @return the value of product.is_hot
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public Integer getIsHot() {
        return isHot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.is_hot
     *
     * @param isHot the value for product.is_hot
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.pdesc
     *
     * @return the value of product.pdesc
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public String getPdesc() {
        return pdesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.pdesc
     *
     * @param pdesc the value for product.pdesc
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public void setPdesc(String pdesc) {
        this.pdesc = pdesc == null ? null : pdesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.pflag
     *
     * @return the value of product.pflag
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public Integer getPflag() {
        return pflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.pflag
     *
     * @param pflag the value for product.pflag
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public void setPflag(Integer pflag) {
        this.pflag = pflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.cid
     *
     * @return the value of product.cid
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public String getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.cid
     *
     * @param cid the value for product.cid
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product
     *
     * @mbg.generated Tue Dec 03 11:10:57 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pid=").append(pid);
        sb.append(", pname=").append(pname);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", shopPrice=").append(shopPrice);
        sb.append(", pimg=").append(pimg);
        sb.append(", pdate=").append(pdate);
        sb.append(", isHot=").append(isHot);
        sb.append(", pdesc=").append(pdesc);
        sb.append(", pflag=").append(pflag);
        sb.append(", cid=").append(cid);
        sb.append("]");
        return sb.toString();
    }
}