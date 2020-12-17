package cn.edu.jlu.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

/**
 *Jsoup对象

 */
public class JsoupDemo2Jsoup {

    public static void main(String[] args) throws IOException {

        String path = JsoupDemo2Jsoup.class.getClassLoader().getResource("student.xml").getPath();

       // Document document = Jsoup.parse(new File(path), "utf-8");

        String content="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<!--引入dtd约束-->\n" +
                "<!--格式：<!DOCTYPE students（跟标签名称） SYSTEM \"student.dtd\"（文件位置）>-->\n" +
                "\n" +
                "\n" +
                "<students>\n" +
                "\t<student number=\"jlu_0001\">\n" +
                "\t\t<name>tom</name>\n" +
                "\t\t<age>18</age>\n" +
                "\t\t<sex>male</sex>\n" +
                "\t</student>\n" +
                "\t<student number=\"jlu_0002\">\n" +
                "\t\t<name>jack</name>\n" +
                "\t\t<age>18</age>\n" +
                "\t\t<sex>female</sex>\n" +
                "\t</student>\n" +
                "</students>";
        Document document = Jsoup.parse(content);
        System.out.println(document);



        URL url=new URL("https://www.bilibili.com/");


        Document document1 = Jsoup.parse(url, 10000);
        System.out.println(document1);

    }

}
