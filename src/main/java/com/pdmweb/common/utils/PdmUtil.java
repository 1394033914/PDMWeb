package com.pdmweb.common.utils;

import org.dom4j.Element;

public class PdmUtil {
    public static String getTextFromEle(Element element) {
        if (element == null) {
            return "";
        }
        return element.getText();
    }

    /**
     * @see String#format(String, Object...)
     */
    public static String getPadString(String str, int length) {
        int size = str.length();
        if (size < length) {
            str += getBlank(length - size);
            return str;
        } else return str + "  ";
    }

    public static String getBlank(int length) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < length; i++) {
            s.append(" ");
        }
        return s.toString();
    }
}
