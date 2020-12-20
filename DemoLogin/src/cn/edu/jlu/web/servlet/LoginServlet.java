package cn.edu.jlu.web.servlet;

import cn.edu.jlu.dao.Userdao;
import cn.edu.jlu.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取请求参数
        /*String username = req.getParameter("username");
        String password = req.getParameter("password");

        //3.封装User对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);*/

        Map<String, String[]> parameterMap = req.getParameterMap();

        User loginUser=new User();

        try {
            BeanUtils.populate(loginUser,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //4.调用UserDao的login()方法
        User user = new Userdao().login(loginUser);

        //5.判断user

        if(user==null)
        {
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else
        {
            //登陆成功先封装数据在转发
            req.setAttribute("user",user);

            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
