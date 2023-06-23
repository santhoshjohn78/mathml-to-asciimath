package com.example.mathml.ascii;


import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.HashMap;

@Service
@Slf4j
public class HandlerRegistry {

    HashMap<String, Handler> handlerHashMap = new HashMap<>();

    @Autowired
    OperatorUtils operatorUtils;

    @PostConstruct
    public void init(){
        handlerHashMap.put("math",new MathHandler(this));
        handlerHashMap.put("mfrac",new MfracHandler(this));
        handlerHashMap.put("mi",new MiHandler(this));
        handlerHashMap.put("mo",new MoHandler(operatorUtils,this));
        handlerHashMap.put("mn",new MnHandler(this));
        handlerHashMap.put("msup",new MsupHandler(this));
        handlerHashMap.put("msub",new MsubHandler(this));
        handlerHashMap.put("mrow",new MrowHandler(operatorUtils,this));
        handlerHashMap.put("msqrt",new MsqrtHandler(this));
        handlerHashMap.put("mover",new MoverHandler(this));
        handlerHashMap.put("mstyle",new MstyleHandler(this));
        handlerHashMap.put("mtext",new MtextHandler());
    }

    public Handler getHandler(Node element) throws Error {
        if (element==null || element.getNodeName()==null || !handlerHashMap.containsKey(element.getNodeName().toLowerCase()))
            throw new Error("No handler found");

        return handlerHashMap.get(element.getNodeName().toLowerCase());
    }
}
