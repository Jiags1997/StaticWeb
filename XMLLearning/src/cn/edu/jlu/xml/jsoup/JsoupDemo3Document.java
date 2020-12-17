package cn.edu.jlu.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 *Jsoup对象

 */
public class JsoupDemo3Document {

    public static void main(String[] args) throws IOException {
        //获取文件路径
        String path = JsoupDemo3Document.class.getClassLoader().getResource("student.xml").getPath();
        //获取document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3获取元素对象
        //3.1获取所有student对象
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);
        System.out.println("------");

        //3.2获取属性名为id的对象们
        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);

        System.out.println("--------");
        //3.3获取属性名为number  属性值为jlu_0001的对象

        Elements elements2 = document.getElementsByAttributeValue("number", "jlu_0001");
        System.out.println(elements2);
    }

}
