package cn.edu.jlu.web.servlet;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * 动态获取虚拟路径
 */
@WebServlet("/responseDemo3")
public class ResponseDemo3 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Object msg = request.getAttribute("msg");
        //System.out.println(msg);
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/responseDemo2");

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
         this.doPost(request,response);
    }
}
