package com.example.mathml.ascii;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class MnHandler extends ElementHandler implements Handler{

    public MnHandler(HandlerRegistry handlerRegistry){
        super(handlerRegistry);
    }

    @Override
    public StringBuffer handle(Node element, StringBuffer buffer) {
        Node sibling = element.getNextSibling();
        buffer.append(element.getFirstChild().getNodeValue().trim());
        if (sibling!=null && (sibling.getNodeName().equalsIgnoreCase("mi") || sibling.getNodeName().equalsIgnoreCase("mfrac"))){
            buffer.append(" ");
        }
        return buffer;
    }
}
