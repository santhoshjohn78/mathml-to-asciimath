package com.example.mathml.ascii;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.stream.Stream;


@Slf4j
public class ElementHandler {

    HandlerRegistry handlerRegistry;

    public ElementHandler(HandlerRegistry handlerRegistry){
        this.handlerRegistry = handlerRegistry;
    }
    public StringBuffer handleAll(Stream<Node> elements, StringBuffer buff){
        elements.forEach(node -> {
            log.info(node.getNodeName());
            Handler handler = handlerRegistry.getHandler(node);
            handler.handle(node,buff);
        });
        return buff;
    }


}
