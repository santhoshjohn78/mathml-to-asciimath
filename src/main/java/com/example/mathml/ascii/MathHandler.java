package com.example.mathml.ascii;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MathHandler extends ElementHandler implements Handler{


    public MathHandler(HandlerRegistry handlerRegistry){
        super(handlerRegistry);
    }

    @Override
    public StringBuffer handle(Node element, StringBuffer buffer) {
        NodeList nodeList = element.getChildNodes();
        Stream<Node> nodeStream = IntStream.range(0, nodeList.getLength())
                .mapToObj(nodeList::item);
        handleAll(nodeStream,buffer);
        return buffer;
    }
}
