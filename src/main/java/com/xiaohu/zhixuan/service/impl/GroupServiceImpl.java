package com.xiaohu.zhixuan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xiaohu.zhixuan.VO.GPVO;
import com.xiaohu.zhixuan.VO.ResultVO;
import com.xiaohu.zhixuan.dao.GpDao;
import com.xiaohu.zhixuan.entity.Gp;
import com.xiaohu.zhixuan.service.GroupService;
import com.xiaohu.zhixuan.utils.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GpDao groupDao;

    @Override
    public ResultVO findByGroupId(long id) {
        ResultVO resultVO = new ResultVO();
        if (id <= 0){
            resultVO.setCode(Code.GROUP_IS_NULL);
            resultVO.setError(Code.getError(Code.GROUP_IS_NULL));
            return resultVO;
        }

        Gp group = groupDao.findByGpId(id);

        if (group == null){
            resultVO.setCode(Code.GROUP_IS_NULL);
            resultVO.setError(Code.getError(Code.GROUP_IS_NULL));
            return resultVO;
        }

        GPVO gpvo = new GPVO();
        gpvo.setGroupId(group.getGroupId());
        gpvo.setGroupName(group.getGroupName());
        gpvo.setGroupPerson(group.getGroupPerson());

        resultVO.setCode(Code.SUCCESS);
        resultVO.setData(JSONObject.toJSONString(gpvo));
        return resultVO;
    }
}
