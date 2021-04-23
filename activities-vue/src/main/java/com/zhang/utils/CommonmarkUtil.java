package com.zhang.utils;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

/**
 * Created with IntelliJ IDEA.
 * Author: Distance
 * Date: 2020/10/21/15:43
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
