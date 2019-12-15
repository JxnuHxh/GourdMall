package com.hlz.gourdmall.model;

public class OrderItem {

    private String itemid;


    private Integer quantity;


    private Double total;


    private String pid;

    private String oid;

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid == null ? null : itemid.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public Double getTotal() {
        return total;
    }


    public void setTotal(Double total) {
        this.total = total;
    }

    public String getPid() {
        return pid;
    }


    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }


    public String getOid() {
        return oid;
    }


    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", itemid=").append(itemid);
        sb.append(", quantity=").append(quantity);
        sb.append(", total=").append(total);
        sb.append(", pid=").append(pid);
        sb.append(", oid=").append(oid);
        sb.append("]");
        return sb.toString();
    }
}