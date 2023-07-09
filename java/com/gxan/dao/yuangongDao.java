package com.gxan.dao;

import com.gxan.pojo.yuangong;

import java.sql.SQLException;
import java.util.List;

public interface yuangongDao {
    //查询总记录数
    Integer countyuangong() throws SQLException;

    //查询表中所有员工信息数据
    List<yuangong> queryyuangongList(Integer param01,Integer param02) throws SQLException;

    //新增员工信息
    Integer addyuangong(yuangong yuangong) throws SQLException;

    //删除员工信息
    Integer delyuangongById(String id) throws SQLException;

    //修改员工信息
    Integer updateyuangong(yuangong yuangong) throws SQLException;

    List<yuangong> searchyuangongList(String currentName,Integer param01,Integer param02) throws SQLException;
}
