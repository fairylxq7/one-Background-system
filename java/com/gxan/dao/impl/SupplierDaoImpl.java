package com.gxan.dao.impl;

import com.gxan.dao.SupplierDao;
import com.gxan.dbutils.JdbcBuild;
import com.gxan.pojo.Supplier;

import java.sql.SQLException;
import java.util.List;

public class SupplierDaoImpl extends JdbcBuild implements SupplierDao {
    @Override
    public Integer countSupplier() throws SQLException {
        String sql = "select count(*) from supplier";
        return super.findAllForInt(sql,null);
    }

    @Override
    public List<Supplier> querySupplierList(Integer param01, Integer param02) throws SQLException {
        String sql = "select * from supplier limit ?,?";
        Object[] params = {param01,param02};
        return super.queryListEntity(Supplier.class,sql,params);
    }

    @Override
    public Integer addSupplier(Supplier supplier) throws SQLException {
        String sql = "insert into supplier(name,address,connection,tel) values(?,?,?,?)";
        Object[] params = {supplier.getName(),supplier.getAddress(),supplier.getConnection(),supplier.getTel()};
        return super.executeUpdate(sql,params);
    }

    @Override
    public Integer delSupplierById(String id) throws SQLException {
        /*
        也可以把需求改成假删除：页面真删、数据库修改status字段从1-正常 改0-删除
        update supplier set status=0 where id =3;
        好处：供应商数据假删，后面供应商数据又需要加上，直接改status=1
         */
        String sql = "delete from supplier where id=?";
        Object[] params = {id};
        return super.executeUpdate(sql,params);
    }

    @Override
    public Integer updateSupplier(Supplier supplier) throws SQLException {
        String sql = "update supplier set name=?,address=?,connection=?,tel=? where id=?";
        Object[] params = {supplier.getName(),supplier.getAddress(),supplier.getConnection(),supplier.getTel(),supplier.getId()};
        return super.executeUpdate(sql,params);
    }
}
