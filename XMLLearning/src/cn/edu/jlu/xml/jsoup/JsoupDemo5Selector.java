package cn.edu.jlu.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 *Jsoup对象

 */
public class JsoupDemo5Selector {

    public static void main(String[] args) throws IOException {
        //获取文件路径
        String path = JsoupDemo5Selector.class.getClassLoader().getResource("student.xml").getPath();
        //获取document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3查询name标签
        Elements name = document.select("name");

        System.out.println(name);


    }

}
