package com.gxan.controller;

import com.alibaba.fastjson.JSONObject;
import com.gxan.common.JsonResult;
import com.gxan.service.SupplierService;
import com.gxan.service.impl.SupplierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//接收请求参数，做出响应
//分页查询供应商信息
@WebServlet("/supplier/queryListByPage")
public class QuerySupplierServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收请求参数
        request.setCharacterEncoding("utf-8");
        //请求参数接收 LayUI规定：数据表格开启分页，那么前端一定给后端传递了 page当前页码 limit每页显示条数
        Integer currentPage = Integer.parseInt(request.getParameter("page"));
        Integer pageSize = Integer.parseInt(request.getParameter("limit"));
        //调用service
        SupplierService supplierService = new SupplierServiceImpl();
        JsonResult jsonResult = supplierService.querySupplierList(currentPage, pageSize);
        //响应
        response.setContentType("application/json;charset=utf-8");
        //使用fastjson技术把r转成json格式数据
        //1.导入fastjson依赖=jar包=封装好直接调用的代码
        PrintWriter pw = response.getWriter();
        pw.write(JSONObject.toJSONString(jsonResult));
        pw.flush();
        pw.close();

    }
}
