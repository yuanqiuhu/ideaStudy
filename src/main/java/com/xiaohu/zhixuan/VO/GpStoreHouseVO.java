package com.xiaohu.zhixuan.VO;

public class GpStoreHouseVO {
    private long gpId;
    private long mineId;
    private String mineName;
    private long mineTotal;
    private float minePrice;

    public long getGpId() {
        return gpId;
    }

    public void setGpId(long gpId) {
        this.gpId = gpId;
    }

    public long getMineId() {
        return mineId;
    }

    public void setMineId(long mineId) {
        this.mineId = mineId;
    }

    public long getMineTotal() {
        return mineTotal;
    }

    public void setMineTotal(long mineTotal) {
        this.mineTotal = mineTotal;
    }

    public String getMineName() {
        return mineName;
    }

    public void setMineName(String mineName) {
        this.mineName = mineName;
    }

    public float getMinePrice() {
        return minePrice;
    }

    public void setMinePrice(float minePrice) {
        this.minePrice = minePrice;
    }
}
