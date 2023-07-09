package com.gxan.service;

import com.gxan.common.JsonResult;
import com.gxan.common.R;
import com.gxan.pojo.yuangong;

public interface yuangongService {
    JsonResult queryyuangongList(Integer currentPage,Integer pageSize);

    R addyuangong(yuangong yuangong);

    R delyuangongById(String id);

    R updateyuangong(yuangong yuangong);

    JsonResult searchyuangongList(String currentName,Integer currentPage, Integer pageSize);
}
