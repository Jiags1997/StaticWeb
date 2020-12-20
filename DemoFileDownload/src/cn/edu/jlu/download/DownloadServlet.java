package cn.edu.jlu.download;

import cn.edu.jlu.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //1.获取请求参数
        String filename = request.getParameter("filename");
        //2.使用字节流输入流加载图片进内存
        //2.1找到服务器路径
        //获取servletContext对象
        ServletContext servletContext = this.getServletContext();
        String realPath=servletContext.getRealPath("/image/"+filename);
        //2.字节流关联
        FileInputStream fis=new FileInputStream(realPath);
        //3.设置response响应头
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type",mimeType);
        //解决中文文件名问题
        String agent = request.getHeader("user-agent");
        filename=DownLoadUtils.getFileName(agent,filename);
        response.setHeader("content-disposition","attachment;filename="+filename);
        //4.将输入流数据写到输出流
        ServletOutputStream outputStream = response.getOutputStream();
        byte []buff=new byte[1024*8];
        int len=0;
        while((len=fis.read())!=-1)
        {
            outputStream.write(buff,0,len);
        }

        fis.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}
