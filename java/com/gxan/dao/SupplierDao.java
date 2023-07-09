package com.gxan.dao;

import com.gxan.pojo.Supplier;

import java.sql.SQLException;
import java.util.List;

public interface SupplierDao {
        //查询总记录数
        Integer countSupplier() throws SQLException;

        //查询表中所有供应商信息数据
        List<Supplier> querySupplierList(Integer param01,Integer param02) throws SQLException;

        //新增供应商信息
        Integer addSupplier(Supplier supplier) throws SQLException;

        //删除供应商信息
        Integer delSupplierById(String id) throws SQLException;

        //修改供应商信息
        Integer updateSupplier(Supplier supplier) throws SQLException;

}
