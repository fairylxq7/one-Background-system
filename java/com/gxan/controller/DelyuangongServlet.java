package com.gxan.controller;

import com.alibaba.fastjson.JSONObject;
import com.gxan.common.R;
import com.gxan.service.yuangongService;
import com.gxan.service.impl.yuangongServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//删除供应商
@WebServlet("/delyuangong")
public class DelyuangongServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收请求参数
        String id = request.getParameter("id");
        //2.调用service
        yuangongService yuangongService = new yuangongServiceImpl();
        R r = yuangongService.delyuangongById(id);
        //3.响应
        response.setContentType("application/json;charset=utf-8");
        //使用fastjson技术把r转成json格式数据
        //1.导入fastjson依赖=jar包=封装好直接调用的代码
        PrintWriter pw = response.getWriter();
        pw.write(JSONObject.toJSONString(r));
        pw.flush();
        pw.close();
    }
}
