package cn.edu.jlu.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/ServletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = request.getServletContext();
        //获取服务器路径
        String realPath = servletContext.getRealPath("b.txt");
        File file=new File(realPath);

        System.out.println(realPath);

        System.out.println(servletContext.getRealPath("/WEB-INF/c.txt"));

        System.out.println(servletContext.getRealPath("/WEB-INF/class/a.txt"));


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
