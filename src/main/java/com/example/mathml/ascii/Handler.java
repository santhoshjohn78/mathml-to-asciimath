package com.example.mathml.ascii;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public interface Handler {

    public StringBuffer handle(Node element, StringBuffer buffer);
}
