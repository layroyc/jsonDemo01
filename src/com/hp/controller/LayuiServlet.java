package com.hp.controller;

import com.alibaba.fastjson.JSON;
import com.hp.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LayuiServlet",urlPatterns = "/LayuiServlet")
public class LayuiServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.解决乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("utf-8");

        //创建三个学生
        ArrayList<Student> students = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(01);
        s1.setAge(20);
        s1.setName("王源");
        students.add(s1);

        Student s2 = new Student();
        s2.setId(02);
        s2.setAge(22);
        s2.setName("王小源");
        students.add(s2);

        Student s3 = new Student();
        s3.setId(03);
        s3.setAge(27);
        s3.setName("源源");
        students.add(s3);

        //去自己创建 一个layui后台的json格式
        Map map = new HashMap<>();
        map.put("code",0);//默认必须是0，不然  不显示
        map.put("msg","写啥都可");
        map.put("count",3);
        map.put("data",students);



        String s = JSON.toJSONString(map);//使用fastjson 的转换
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.close();
    }
}
