package cn.edu.jlu.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 *
 */
@WebServlet("/RequestDemo6")
public class RequestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post获取请求参数
        /*
        1. String getParameter(String name):根据参数名称获取参数值    username=zs&password=123
		2. String[] getParameterValues(String name):根据参数名称获取参数值的数组  hobby=xx&hobby=game
		3. Enumeration<String> getParameterNames():获取所有请求的参数名称
		4. Map<String,String[]> getParameterMap():获取所有参数的map集合
         */


        request.setCharacterEncoding("utf-8");
        //1.根据参数名称获取参数值    username=zs&password=123


        String username = request.getParameter("username");
//        System.out.println("post");
//        System.out.println(username);

        //String[] hobbies = request.getParameterValues("hobby");
     /*   for(String hobby:hobbies){
            System.out.println(hobby);
        }*/


        Enumeration<String> parameterNames = request.getParameterNames();
//
//        while(parameterNames.hasMoreElements()){
//            String name = parameterNames.nextElement();
//            String value = request.getParameter(name);
//            System.out.println(name+"="+value);
//
//        }

        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keySet=parameterMap.keySet();

        for(String name:keySet){
            System.out.println(name);
            String [] values=parameterMap.get(name);
            for(String value:values){
                System.out.println(value);
            }
            System.out.println("-------");
        }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get获取请求参数
        //根据参数名称获取参数值    username=zs&password=123
        String username = request.getParameter("username");
        System.out.println("get");
        System.out.println(username);
    }
}
