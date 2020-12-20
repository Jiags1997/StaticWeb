package cn.edu.jlu.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/RequestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 演示请求头数据
        String header = request.getHeader("user-agent");
        if(header.contains("Chrome")){
            System.out.println("谷歌来了");
    }else if(header.contains("Firefox")){
            System.out.println("火狐来了。。。");
        }

    }
}
