package com.example.mathml.ascii;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.HashMap;

public class MiHandler extends ElementHandler implements Handler{

    HashMap<String, String> miHashMap = new HashMap<>();

    public MiHandler(HandlerRegistry handlerRegistry){
        super(handlerRegistry);
        miHashMap.put("&alpha;","alpha");
        miHashMap.put("&beta;","beta");
        miHashMap.put("&chi;","chi");
        miHashMap.put("&delta;","delta");
        miHashMap.put("&epsilon;","epsi");
        miHashMap.put("&eta;","eta");
        miHashMap.put("&gamma;","gamma");
        miHashMap.put("&iota;","iota");
        miHashMap.put("&kappa;","kappa");
        miHashMap.put("&lambda;","lambda");
        miHashMap.put("&mu;","mu");
        miHashMap.put("&nu;","nu");
        miHashMap.put("&omega;","omega");
        miHashMap.put("&phi;","phi");
        miHashMap.put("&pi;","pi");
        miHashMap.put("&psi;","psi");
        miHashMap.put("&rho;","rho");
        miHashMap.put("&sigma;","sigma");
        miHashMap.put("&tau;","tau");
        miHashMap.put("&theta;","theta");
        miHashMap.put("&upsilon;","upsilon");
        miHashMap.put("&xi;","xi");
        miHashMap.put("&zeta;","zeta");

    }

    @Override
    public StringBuffer handle(Node element, StringBuffer buffer) {
        var value = element.getFirstChild().getNodeValue().trim();
        Node sibling = element.getNextSibling();


        if (miHashMap.containsKey(value)){
            value = miHashMap.get(value);
        }
        if (sibling!=null && sibling.getNodeName().equalsIgnoreCase("mi")){
            value+=" ";
        }
        buffer.append(value);
        return buffer;
    }
}
