package com.xiaohu.zhixuan.VO;

public class MinePriceVO {
    private Long mineId;
    private String mineName;
    private float minePrice;
    private int mineType;

    public Long getMineId() {
        return mineId;
    }

    public void setMineId(Long mineId) {
        this.mineId = mineId;
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

    public int getMineType() {
        return mineType;
    }

    public void setMineType(int mineType) {
        this.mineType = mineType;
    }
}
