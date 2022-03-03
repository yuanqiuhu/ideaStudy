package com.xiaohu.zhixuan.entity;

import javax.persistence.*;

@Entity
@Table(name = "mine_type")
public class MineType {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private long mineTypeId;
    private String mineTypeName;

    public long getMineTypeId() {
        return mineTypeId;
    }

    public void setMineTypeId(long mineTypeId) {
        this.mineTypeId = mineTypeId;
    }

    public String getMineTypeName() {
        return mineTypeName;
    }

    public void setMineTypeName(String mineTypeName) {
        this.mineTypeName = mineTypeName;
    }
}
