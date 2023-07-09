package com.gxan.service;

import com.gxan.common.JsonResult;
import com.gxan.common.R;
import com.gxan.pojo.Supplier;

//核心业务处理
public interface SupplierService {

    //分页查询供应商信息
    JsonResult querySupplierList(Integer currentPage, Integer pageSize);

    //添加供应商信息
    R addSupplier(Supplier supplier);

    //删除供应商信息方法
    R delSupplierById(String id);

    //修改供应商信息
    R updateSupplier(Supplier supplier);
}
