package com.example.mathml.ascii;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class MtextHandler implements Handler{

    @Override
    public StringBuffer handle(Node element, StringBuffer buffer) {

        var value = element.getFirstChild().getNodeValue().trim();
        buffer.append("text(" + value + ")");
        return buffer;
    }
}
