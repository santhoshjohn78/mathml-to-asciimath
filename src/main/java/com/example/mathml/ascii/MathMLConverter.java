package com.example.mathml.ascii;


import lombok.extern.slf4j.Slf4j;
import net.sourceforge.jeuclid.*;
import net.sourceforge.jeuclid.converter.Converter;

import net.sourceforge.jeuclid.converter.ConverterPlugin;
import net.sourceforge.jeuclid.elements.generic.JEuclidDOMImplementation;
import net.sourceforge.jeuclid.elements.support.text.TextContent;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
@Slf4j
public class MathMLConverter extends ElementHandler{

    public MathMLConverter(HandlerRegistry handlerRegistry) {
        super(handlerRegistry);
    }


    @Override
    public StringBuffer handleAll(Stream<Node> elements, StringBuffer buff){
        elements.forEach(node -> {
            log.info(node.getNodeName());
            Node firstChild = node.getFirstChild();
            if (firstChild.getNodeName().equalsIgnoreCase("root")){
                firstChild = node.getLastChild();
            }
            Handler handler = handlerRegistry.getHandler(firstChild);
            handler.handle(firstChild,buff);
        });
        return buff;
    }

    public StringBuffer handle(Node element, StringBuffer buffer) {
        Stream<Node> nodeStream = Stream.of(element);
        handleAll(nodeStream,buffer);
        return buffer;
    }
    public String toAscii(String mathML){
        Document doc = null;
        try {
            doc = MathMLParserSupport.parseString(mathML);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StringBuffer buffer = new StringBuffer();
        buffer = handle(doc,buffer);

        return buffer.toString().trim();
    }
}
