package cn.edu.jlu.web.servlet;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * 重定向案例
 */
@WebServlet("/responseDemo2")
public class ResponseDemo2 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Object msg = request.getAttribute("msg");
        //System.out.println(msg);

        System.out.println("demo2...");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
         this.doPost(request,response);
    }
}
