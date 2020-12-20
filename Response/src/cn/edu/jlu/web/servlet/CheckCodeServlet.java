package cn.edu.jlu.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collections;
import java.util.Random;

/**
 * 重定向案例
 *
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        int width=100;
        int height=50;

        //创建一个对象，在内存中中图片（验证码对象图片）
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);

        //2美化图片
        //2.1填充背景色
        Graphics graphics = image.getGraphics();//画笔对象
        graphics.setColor(Color.pink);//设置画笔颜色
        graphics.fillRect(0,0,width,height);

        //2.2画边框
        graphics.setColor(Color.blue);
        graphics.drawRect(0,0,width-1,height-1);
        //2.3写验证码
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random=new Random();

        for (int i = 1; i <=4; i++) {
            int index = random.nextInt(str.length());
            char ch=str.charAt(index);

            graphics.drawString(ch+"",width/5*i,height/2);
        }
       //2.4画干扰线
        graphics.setColor(Color.GREEN);
        //随机生成坐标点
        for (int i = 0; i < 10; i++) {
            int x1=random.nextInt(width);
            int x2=random.nextInt(width);

            int y1=random.nextInt(height);
            int y2=random.nextInt(height);

            graphics.drawLine(x1,x2,y1,y2);
        }



        //3.将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
         this.doPost(request,response);
    }
}
