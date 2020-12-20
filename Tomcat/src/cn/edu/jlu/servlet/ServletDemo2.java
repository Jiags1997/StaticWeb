package cn.edu.jlu.servlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo2  implements Servlet {
    /**
     * 初始化方法
     * 在servlet被创建时，被执行，只会执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init....");
    }

    /**
     * 获取ServletConfig对象
     * ServletConfig：Servlet配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务方法
     * 每次访问servlet，都执行
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service.... ");
    }

    /**
     * 获取Servlet信息，版本作者等
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在服务器正常关闭时，执行，执行一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy....");
    }
}
