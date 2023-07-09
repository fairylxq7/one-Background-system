package com.gxan.service.impl;

import com.gxan.common.JsonResult;
import com.gxan.common.R;
import com.gxan.dao.yuangongDao;
import com.gxan.dao.impl.yuangongDaoImpl;
import com.gxan.pojo.yuangong;
import com.gxan.service.yuangongService;

import java.sql.SQLException;
import java.util.List;

//核心业务处理:分页查询 新增 删除 编辑/修改
public class yuangongServiceImpl implements yuangongService {

    private yuangongDao yuangongDao = new yuangongDaoImpl();

    @Override
    public JsonResult queryyuangongList(Integer currentPage, Integer pageSize) {
        //分页实体对象
        JsonResult jsonResult = new JsonResult();
        try {
            //1.调用dao查询总记录数
            Integer totalSize = yuangongDao.countyuangong();
            jsonResult.setCount(totalSize);
            //2.调用dao查询数据
            Integer param01 = (currentPage-1)*pageSize;//每页起始索引
            Integer param02 = pageSize;//每页显示条数
            List<yuangong> yuangongList = yuangongDao.queryyuangongList(param01, param02);
            jsonResult.setData(yuangongList);
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
    public R addyuangong(yuangong yuangong) {
        R r = new R();
        try {
            //调用dao完成新增
            int result = yuangongDao.addyuangong(yuangong);
            //逻辑处理
            if(result>0){
                //成功
                r.setCode(200);//新增、删除、修改成功都是200
                r.setMsg("添加员工成功");
            }else{
                //失败
                r.setCode(500);//新增、删除、修改失败都是500
                r.setMsg("添加员工失败");
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
    public R delyuangongById(String id) {
        R r = new R();
        try {
            //调用dao删除数据
            int result = yuangongDao.delyuangongById(id);
            //逻辑处理
            if(result>0){
                //成功
                r.setCode(200);//新增、删除、修改成功都是200
                r.setMsg("删除员工成功");
            }else{
                //失败
                r.setCode(500);//新增、删除、修改失败都是500
                r.setMsg("删除员工失败");
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
    public R updateyuangong(yuangong yuangong) {
        R r = new R();
        //调用dao层完成修改
        try {
            Integer result = yuangongDao.updateyuangong(yuangong);
            //逻辑处理
            if(result>0){
                //成功
                r.setCode(200);//新增、删除、修改成功都是200
                r.setMsg("修改员工成功");
            }else{
                //失败
                r.setCode(500);//新增、删除、修改失败都是500
                r.setMsg("修改员工失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //捕获异常
            r.setCode(501);
            r.setMsg("系统开小差，请联系管理员");
        }

        return r;
    }

    //按name查询
    @Override
    public JsonResult searchyuangongList(String currentName,Integer currentPage, Integer pageSize) {
        //分页实体对象
        JsonResult jsonResult = new JsonResult();
        try {
            //1.调用dao查询总记录数
            Integer totalSize = yuangongDao.countyuangong();
            jsonResult.setCount(totalSize);
            //2.调用dao查询数据
            Integer param01 = (currentPage-1)*pageSize;//每页起始索引
            Integer param02 = pageSize;//每页显示条数
            List<yuangong> yuangongList = yuangongDao.searchyuangongList(currentName,param01, param02);
            jsonResult.setData(yuangongList);
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
}
