package cn.edu.jlu.web.servlet;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * 重定向案例
 *
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("demo1...");
        //访问responsedemo1,会自动跳转responseDemo2
        //1.设置状态码302
        /*response.setStatus(302);
        //2.设置响应头location
        response.setHeader("location","/day15/responseDemo2");*/

        //一种简单的方式
        request.setAttribute("msg","response");
        response.sendRedirect("/day15/responseDemo2");

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
         this.doPost(request,response);
    }
}
