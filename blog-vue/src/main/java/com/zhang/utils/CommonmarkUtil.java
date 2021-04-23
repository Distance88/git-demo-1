package com.zhang.utils;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;


/**
 * Created with IntelliJ IDEA.
 * Auther: Distance
 * Date: 2020/09/24/21:26
 */
public class CommonmarkUtil {

    public String transferMarkDownToHtml (String content){
        System.out.println(content);
        Parser parser = Parser.builder().build();
        Node document = parser.parse(content);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String htmlContent = renderer.render(document);
        return htmlContent;
    }
}
