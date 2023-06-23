package com.example.mathml.ascii;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MrowHandler extends ElementHandler implements Handler{

    OperatorUtils operatorUtils;
    public MrowHandler(OperatorUtils operatorUtils,HandlerRegistry handlerRegistry){
        super(handlerRegistry);
        this.operatorUtils = operatorUtils;
    }

    public boolean needsGrouping(Node element) {
        Node firstChild = element.getFirstChild();
        var lastChild = element.getLastChild();

        // already has grouping operators
        if (firstChild.getNodeName().equalsIgnoreCase("mo") &&
                operatorUtils.isOpenOperator(firstChild.getTextContent()) &&
                lastChild.getNodeName().equalsIgnoreCase("mo") &&
                operatorUtils.isCloseOperator(lastChild.getTextContent())) {

            return false;
        }

        // just mtext by itself -- ASCIIMathML does this when given text(foo)
        if (element.getChildNodes().getLength() == 1 && firstChild.getNodeName().equalsIgnoreCase("mtext")) {
            return false;
        }

        return true;
    }

    @Override
    public StringBuffer handle(Node element, StringBuffer buffer) {
        var addParens = needsGrouping(element);

        if (addParens) {
            buffer.append("( ");
        }

        NodeList nodeList = element.getChildNodes();
        Stream<Node> nodeStream = IntStream.range(0, nodeList.getLength())
                .mapToObj(nodeList::item);
        handleAll(nodeStream,buffer);



        if (addParens) {
            buffer.append(" )");
        }
        return buffer;
    }
}
