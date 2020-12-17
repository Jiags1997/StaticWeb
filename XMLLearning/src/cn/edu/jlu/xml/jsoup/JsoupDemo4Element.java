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
public class JsoupDemo4Element {

    public static void main(String[] args) throws IOException {
        //获取文件路径
        String path = JsoupDemo4Element.class.getClassLoader().getResource("student.xml").getPath();
        //获取document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3获取元素对象
        //3.1获取所有student对象
        Elements elements = document.getElementsByTag("student");

        /*
        4. Element：元素对象
			1. 获取子元素对象
				* getElementById​(String id)：根据id属性值获取唯一的element对象
				* getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
				* getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
				* getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合

			2. 获取属性值
				* String attr(String key)：根据属性名称获取属性值
			3. 获取文本内容
				* String text():获取文本内容
				* String html():获取标签体的所有内容(包括字标签的字符串内容)
         */
        //获取第一个student element对象
        Element element_student = elements.get(0);
        Elements element_name = element_student.getElementsByTag("name");
        System.out.println(element_name.size());

        System.out.println("------");
        //获取student对象的属性值

        String number = element_student.attr("number");
        System.out.println(number);

        System.out.println("-----");

        //获取文本内容

        String name = element_name.text();

        String html = element_name.html();

        System.out.println(name+"+++++"+html);



    }

}
