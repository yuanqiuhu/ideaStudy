package com.xiaohu.zhixuan.entity;

import javax.persistence.*;

@Entity
@Table(name = "gp_store_house")
public class GpStoreHouse {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private long houseId;
    private long gpId;
    private long mineId;
    private long mineTotal;

    public long getHouseId() {
        return houseId;
    }

    public void setHouseId(long houseId) {
        this.houseId = houseId;
    }

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
}
