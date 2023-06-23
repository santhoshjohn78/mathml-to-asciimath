package com.example.mathml.ascii;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class MfracHandler extends ElementHandler implements Handler{

    public MfracHandler(HandlerRegistry handlerRegistry) {
        super(handlerRegistry);
    }

    @Override
    public StringBuffer handle(Node element, StringBuffer buffer) {
        var firstChild = element.getFirstChild();
        var secondChild = element.getLastChild();
        Handler handler = handlerRegistry.getHandler(firstChild);


        buffer = handler.handle(firstChild, buffer);
        buffer.append(" / ");
        handler = handlerRegistry.getHandler(secondChild);
        buffer = handler.handle(secondChild, buffer);
        return buffer;
    }
}
