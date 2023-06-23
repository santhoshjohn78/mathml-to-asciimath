package com.example.mathml.ascii;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;

@Component
public class OperatorUtils {

    public HashMap<String,String> moToAscii = new HashMap<>();

    public String[] openOperators = {"(", "[", "{"};

    public String[] closeOperators = {")", "]", "}"};

    @PostConstruct
    public void init(){

        moToAscii.put("+"," + ");
        moToAscii.put("-"," - ");
        moToAscii.put("&sdot;"," * ");
        moToAscii.put("."," * ");
        moToAscii.put("&Star;"," ** ");
        moToAscii.put("⋆"," ** ");
        moToAscii.put("*"," ** ");
        moToAscii.put("&times;"," xx ");
        moToAscii.put("×"," xx ");
        moToAscii.put("/"," // ");
        moToAscii.put("&divide;"," -: ");
        moToAscii.put("÷"," -: ");
        moToAscii.put("="," = ");
        moToAscii.put("&ne;"," != ");
        moToAscii.put("≠"," != ");
        moToAscii.put("<"," < ");
        moToAscii.put(">"," > ");
        moToAscii.put("&le;"," <= ");
        moToAscii.put("≤"," <= ");
        moToAscii.put("&ge;"," >= ");
        moToAscii.put("≥"," >= ");
        moToAscii.put("("," ( ");
        moToAscii.put(")"," ) ");
        moToAscii.put("&asymp;"," ~~ ");
        moToAscii.put("≈"," ~~ ");
        moToAscii.put("["," [ ");
        moToAscii.put("]"," ] ");
        moToAscii.put(","," , ");
        moToAscii.put("{"," { ");
        moToAscii.put("}"," } ");
        moToAscii.put("&macr;"," bar ");
        moToAscii.put("¯"," bar ");
        moToAscii.put("&rarr;","vec ");
        moToAscii.put("→","vec ");
        moToAscii.put("&harr;","line ");
        moToAscii.put("↔","line ");
        moToAscii.put("\u23DC","arc ");
        moToAscii.put("⌒","arc ");
        moToAscii.put("&plusmn;"," +- ");
        moToAscii.put("±"," +- ");
        moToAscii.put("?"," ? ");
        moToAscii.put("&ang;"," /_ ");
        moToAscii.put("∠"," /_ ");
        moToAscii.put("&deg;"," deg ");
        moToAscii.put("°"," deg ");
        moToAscii.put("&Delta;","Delta");
        moToAscii.put("&Gamma;","Gamma");
        moToAscii.put("&Lambda;","Lambda");
        moToAscii.put("&Omega;","Omega");
        moToAscii.put("&Phi;","Phi");
        moToAscii.put("&Pi;","Pi");
        moToAscii.put("&Sigma;","Sigma");
        moToAscii.put("&Theta;","Theta");
        moToAscii.put("&Xi;","Xi");
    }

    public String toAsciiMath(String mo) {
        return moToAscii.get(mo);
    };
    public boolean isOpenOperator(String operator){
        return Arrays.stream(openOperators).anyMatch(c -> c.equalsIgnoreCase(operator));
    }

    public boolean isCloseOperator(String operator){
        return Arrays.stream(closeOperators).anyMatch(c -> c.equalsIgnoreCase(operator));
    }
}
