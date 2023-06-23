package com.example.mathml.ascii;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class MoHandler extends ElementHandler implements Handler{

    OperatorUtils operatorUtils;
    public MoHandler(OperatorUtils operatorUtils,HandlerRegistry handlerRegistry){
        super(handlerRegistry);
        this.operatorUtils = operatorUtils;
    }

    @Override
    public StringBuffer handle(Node element, StringBuffer buffer) {
        var value = element.getFirstChild().getNodeValue().trim();
        var asciiMathSymbol = operatorUtils.toAsciiMath(value);

        if (asciiMathSymbol == null) {
            throw new Error("Unsupported operator: " + value);
        }

        buffer.append(asciiMathSymbol);
        return buffer;
    }
}
