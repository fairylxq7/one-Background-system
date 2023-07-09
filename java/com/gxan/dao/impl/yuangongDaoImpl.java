package com.gxan.dao.impl;

import com.gxan.dao.yuangongDao;
import com.gxan.dbutils.JdbcBuild;
import com.gxan.pojo.yuangong;

import java.sql.SQLException;
import java.util.List;

public class yuangongDaoImpl extends JdbcBuild implements yuangongDao {
    @Override
    public Integer countyuangong() throws SQLException {
        String sql = "select count(*) from yuangong";
        return super.findAllForInt(sql,null);
    }

    @Override
    public List<yuangong> queryyuangongList(Integer param01, Integer param02) throws SQLException {
        String sql = "select * from yuangong limit ?,?";
        Object[] params = {param01,param02};
        return super.queryListEntity(yuangong.class,sql,params);
    }

    @Override
    public Integer addyuangong(yuangong yuangong) throws SQLException {
        String sql = "insert into yuangong(name,address,sex,tel,birthday,dept_name,education,zhiwei,age) values(?,?,?,?,?,?,?,?,?)";
        Object[] params = {yuangong.getName(),yuangong.getAddress(),yuangong.getSex(),yuangong.getTel(),yuangong.getBirthday(),yuangong.getDept_name(),yuangong.getEducation(),yuangong.getZhiwei(),yuangong.getAge()};
        return super.executeUpdate(sql,params);
    }

    @Override
    public Integer delyuangongById(String id) throws SQLException {
        /*
        也可以把需求改成假删除：页面真删、数据库修改status字段从1-正常 改0-删除
        update yuangong set status=0 where id =3;
        好处：员工数据假删，后面员工数据又需要加上，直接改status=1
         */
        String sql = "delete from yuangong where id=?";
        Object[] params = {id};
        return super.executeUpdate(sql,params);
    }

    @Override
    public Integer updateyuangong(yuangong yuangong) throws SQLException {
        String sql = "update yuangong set name=?,address=?,tel=?,sex=?,dept_name=?,education=?,age=?,zhiwei=?,birthday=? where id=?";
        Object[] params = {yuangong.getName(),yuangong.getAddress(),yuangong.getTel(),yuangong.getSex(),yuangong.getDept_name(),yuangong.getEducation(),yuangong.getAge(),yuangong.getZhiwei(),yuangong.getBirthday(),yuangong.getId()};
        return super.executeUpdate(sql,params);
    }

    @Override
    public List<yuangong> searchyuangongList(String currentName, Integer param01, Integer param02) throws SQLException {
        String sql = "select * from yuangong where name=? limit ?,?";
        Object[] params = {currentName,param01,param02};
        return super.queryListEntity(yuangong.class,sql,params);
    }


}
