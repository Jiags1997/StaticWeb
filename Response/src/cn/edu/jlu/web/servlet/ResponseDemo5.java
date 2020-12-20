package cn.edu.jlu.web.servlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 *
 */
@WebServlet("/responseDemo5")
public class ResponseDemo5 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //告诉浏览器使用什么编码方式解码
        response.setContentType("text/html;charset=utf-8");
        //获取字节输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //输出数据，设置输出数据的编码格式
        outputStream.write("你好".getBytes("utf-8"));


    }
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
         this.doPost(request,response);
    }
}
