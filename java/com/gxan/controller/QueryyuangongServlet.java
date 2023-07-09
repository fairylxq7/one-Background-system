package com.gxan.controller;

import com.alibaba.fastjson.JSONObject;
import com.gxan.common.JsonResult;
import com.gxan.service.yuangongService;
import com.gxan.service.impl.yuangongServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/yuangong/queryListByPage")
public class QueryyuangongServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //前端给后端传当前页码page 每页显示条数limit
        Integer currentPage = Integer.parseInt(request.getParameter("page"));
        Integer pageSize = Integer.parseInt(request.getParameter("limit"));
        //调用service
        yuangongService yuangongService = new yuangongServiceImpl();
        JsonResult jsonResult = yuangongService.queryyuangongList(currentPage, pageSize);
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