package com.gxan.controller;

import com.alibaba.fastjson.JSONObject;
import com.gxan.common.R;
import com.gxan.pojo.yuangong;
import com.gxan.service.yuangongService;
import com.gxan.service.impl.yuangongServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateyuangong")
public class updateyuangongServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收请求参数
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String dept_name = request.getParameter("dept_name");
        String address = request.getParameter("address");
        String tel = request.getParameter("tel");
        String age = request.getParameter("age");
        String zhiwei = request.getParameter("zhiwei");
        String education = request.getParameter("education");
        String birthday = request.getParameter("birthday");

        //2.把前端传递得参数值封装到yuangong对象
        yuangong yuangong = new yuangong();
        yuangong.setId(Integer.parseInt(id));
        yuangong.setName(name);
        yuangong.setSex(sex);
        yuangong.setDept_name(dept_name);
        yuangong.setAddress(address);
        yuangong.setTel(tel);
        yuangong.setAge(age);
        yuangong.setZhiwei(zhiwei);
        yuangong.setEducation(education);
        yuangong.setBirthday(birthday);
        //2.调用service
        yuangongService yuangongService = new yuangongServiceImpl();
        R r = yuangongService.updateyuangong(yuangong);
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
