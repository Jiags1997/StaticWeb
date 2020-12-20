package cn.edu.jlu.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 演示请求头数据
        String referer = request.getHeader("referer");
        System.out.println(referer);
        if(referer!=null){
            if(referer.contains("/SR")){
                System.out.println("播放电影");
            }
            else
            System.out.println("想看电影吗？ 来优酷吧");
        }
    }
}
