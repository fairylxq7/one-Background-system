package com.gxan.service.impl;

import com.gxan.common.JsonResult;
import com.gxan.common.R;
import com.gxan.dao.SupplierDao;
import com.gxan.dao.impl.SupplierDaoImpl;
import com.gxan.pojo.Supplier;
import com.gxan.service.SupplierService;

import java.sql.SQLException;
import java.util.List;

//核心业务处理:分页查询 新增 删除 编辑/修改
public class SupplierServiceImpl implements SupplierService {

    private SupplierDao supplierDao = new SupplierDaoImpl();

    @Override
    public JsonResult querySupplierList(Integer currentPage, Integer pageSize) {
        //分页实体对象
        JsonResult jsonResult = new JsonResult();
        try {
            //1.调用dao查询总记录数
            Integer totalSize = supplierDao.countSupplier();
            jsonResult.setCount(totalSize);
            //2.调用dao查询数据
            Integer param01 = (currentPage-1)*pageSize;//每页起始索引
            Integer param02 = pageSize;//每页显示条数
            List<Supplier> supplierList = supplierDao.querySupplierList(param01, param02);
            jsonResult.setData(supplierList);
            //3.逻辑处理响应分页实体类
            if(jsonResult!=null){
                //0 LayUI规定数据表格要想成功展示数据必须是0
                jsonResult.setCode(0);
                jsonResult.setMsg("查询成功");
            }else{
                jsonResult.setCode(500);
                jsonResult.setMsg("查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setCode(501);
            jsonResult.setMsg("系统开小差，请联系管理员");
        }

        return jsonResult;
    }

    @Override
    public R addSupplier(Supplier supplier) {
        R r = new R();
        try {
            //调用dao完成新增
            int result = supplierDao.addSupplier(supplier);
            //逻辑处理
            if(result>0){
                //成功
                r.setCode(200);//新增、删除、修改成功都是200
                r.setMsg("添加供应商成功");
            }else{
                //失败
                r.setCode(500);//新增、删除、修改失败都是500
                r.setMsg("添加供应商失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //捕获异常
            r.setCode(501);
            r.setMsg("系统开小差，请联系管理员");
        }
        return r;
    }

    @Override
    public R delSupplierById(String id) {
        R r = new R();
        try {
            //调用dao删除数据
            int result = supplierDao.delSupplierById(id);
            //逻辑处理
            if(result>0){
                //成功
                r.setCode(200);//新增、删除、修改成功都是200
                r.setMsg("删除供应商成功");
            }else{
                //失败
                r.setCode(500);//新增、删除、修改失败都是500
                r.setMsg("删除供应商失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //捕获异常
            r.setCode(501);
            r.setMsg("系统开小差，请联系管理员");
        }

        return r;
    }

    @Override
    public R updateSupplier(Supplier supplier) {
        R r = new R();
        //调用dao层完成修改
        try {
            Integer result = supplierDao.updateSupplier(supplier);
            //逻辑处理
            if(result>0){
                //成功
                r.setCode(200);//新增、删除、修改成功都是200
                r.setMsg("修改供应商成功");
            }else{
                //失败
                r.setCode(500);//新增、删除、修改失败都是500
                r.setMsg("修改供应商失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //捕获异常
            r.setCode(501);
            r.setMsg("系统开小差，请联系管理员");
        }

        return r;
    }
}
