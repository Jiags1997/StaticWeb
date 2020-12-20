package cn.edu.jlu.web.servlet;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 重定向案例
 *
 */
@WebServlet("/responseDemo4")
public class ResponseDemo4 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //获取流之前设置复娶妻编码
       // response.setCharacterEncoding("utf-8");
        //告诉浏览器，服务器发送的消息体数据编码，建议浏览器使用该编码解码
       // response.setHeader("content-type","text/html;charset=utf-8");

        response.setContentType("text/html;charset=utf-8");

        //1.获取字符输出流
        PrintWriter pw = response.getWriter();
        //2.输出数据
       /* pw.write("HelloResponse");
        pw.print("hello");*/

        pw.write("<h1>你好，response</h1>");
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
         this.doPost(request,response);
    }
}
