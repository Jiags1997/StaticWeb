package cn.edu.jlu.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 *Jsoup快速入门
 * 步骤：
 * * 步骤：
 * 				1. 导入jar包
 * 				2. 获取Document对象
 * 				3. 获取对应的标签Element对象
 * 				4. 获取数据
 */
public class JsoupDemo1 {

    public static void main(String[] args) throws IOException {
        //2.获取document对象
        //2.1获取student.xml的path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载到内存，获取dom树
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.获取元素对象ELement
        Elements elements = document.getElementsByTag("name");
        //
        System.out.println(elements.size());


        Element element = elements.get(0);

        String name = element.text();

        System.out.println(name);



    }

}
