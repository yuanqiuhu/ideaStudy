package com.xiaohu.zhixuan.entity;

import javax.persistence.*;

@Entity
@Table(name = "gp")
public class Gp {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private long gpId;
    private String gpName;
    private int gpPerson;

    public long getGroupId() {
        return gpId;
    }

    public void setGroupId(long groupId) {
        this.gpId = groupId;
    }

    public String getGroupName() {
        return gpName;
    }

    public void setGroupName(String groupName) {
        this.gpName = groupName;
    }

    public int getGroupPerson() {
        return gpPerson;
    }

    public void setGroupPerson(int groupPerson) {
        this.gpPerson = groupPerson;
    }
}
