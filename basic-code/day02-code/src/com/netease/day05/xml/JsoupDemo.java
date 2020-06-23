package com.netease.day05.xml;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import com.netease.util.printUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.util.List;

public class JsoupDemo {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
//        Elements();
//        Element();

        XPath();

    }

    static void Elements() throws IOException {
        String path = JsoupDemo.class.getClassLoader().getResource("student.xml").getPath();
        Document parse = Jsoup.parse(new File(path), "utf-8");
        Elements name = parse.getElementsByTag("name");
        System.out.println(name);

        printUtils.print("=", 50);

        Elements it = parse.getElementsByAttribute("id");
        System.out.println(it);

        printUtils.print("=", 50);

        Elements number = parse.getElementsByAttributeValue("number", "1");
        System.out.println(number);

        printUtils.print("=", 50);

        Element it1 = parse.getElementById("IT");
        System.out.println(it1);
    }

    static void Element() throws IOException {
        String path = JsoupDemo.class.getClassLoader().getResource("student.xml").getPath();
        Document parse = Jsoup.parse(new File(path), "utf-8");
        Element student = parse.getElementsByTag("student").get(0);

        String number = student.attr("number");
        System.out.println(number);

        printUtils.print("=", 50);

        String text = student.text();
        System.out.println(text);

        printUtils.print("=", 50);

        String html = student.html();
        System.out.println(html);

        printUtils.print("=", 50);

        Elements name = parse.select("name");
        System.out.println(name);


        printUtils.print("=", 50);

        Elements it = parse.select("#IT");
        System.out.println(it);

        printUtils.print("=", 50);

        Elements select = parse.select("student[number='1'] > age");
        System.out.println(select);
    }

    static void XPath () throws IOException, XpathSyntaxErrorException {
        String path = JsoupDemo.class.getClassLoader().getResource("student.xml").getPath();
        Document parse = Jsoup.parse(new File(path), "utf-8");
        JXDocument jxDocument = new JXDocument(parse);
        List<JXNode> jxNodes = jxDocument.selN("//student");
        System.out.println(jxNodes);

        printUtils.print("=", 50);

        List<JXNode> jxNodes1 = jxDocument.selN("//student/name");
        System.out.println(jxNodes1);

        printUtils.print("=", 50);

        List<JXNode> jxNodes2 = jxDocument.selN("//student/name[@id='IT']");
        System.out.println(jxNodes2);
    }
}
