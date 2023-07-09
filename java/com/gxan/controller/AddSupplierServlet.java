package com.gxan.controller;

import com.alibaba.fastjson.JSONObject;
import com.gxan.common.R;
import com.gxan.pojo.Supplier;
import com.gxan.service.SupplierService;
import com.gxan.service.impl.SupplierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//新增供应商
@WebServlet("/supplier/addSupplier")
public class AddSupplierServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收请求参数
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String connection = request.getParameter("connection");
        String tel = request.getParameter("tel");
        //2.把前端传递得参数值封装到Supplier对象
        Supplier supplier = new Supplier();
        supplier.setName(name);
        supplier.setAddress(address);
        supplier.setConnection(connection);
        supplier.setTel(tel);
        //3.调用service
        SupplierService supplierService = new SupplierServiceImpl();
        R r = supplierService.addSupplier(supplier);
        //4.响应
        response.setContentType("application/json;charset=utf-8");
        //使用fastjson技术把r转成json格式数据
        //1.导入fastjson依赖=jar包=封装好直接调用的代码
        PrintWriter pw = response.getWriter();
        pw.write(JSONObject.toJSONString(r));
        pw.flush();
        pw.close();



    }
}
