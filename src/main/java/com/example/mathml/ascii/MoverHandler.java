package com.example.mathml.ascii;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.stream.Stream;

public class MoverHandler extends ElementHandler implements Handler{

    public MoverHandler(HandlerRegistry handlerRegistry) {
        super(handlerRegistry);
    }

    @Override
    public StringBuffer handle(Node element, StringBuffer buffer) {


        var base = element.getFirstChild();
        var overscript = element.getLastChild();

        Stream<Node> nodeStream = Stream.of(overscript,base);

        handleAll(nodeStream, buffer);
        return null;
    }
}
