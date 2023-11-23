package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class HTMLEntityParser {
    // #1410. HTML Entity Parser    https://leetcode.com/problems/html-entity-parser/
    /*
    HTML entity parser is the parser that takes HTML code as input and replace all the entities of the special characters by the characters itself.

    The special characters and their entities for HTML are:

    Quotation Mark: the entity is &quot; and symbol character is ".
    Single Quote Mark: the entity is &apos; and symbol character is '.
    Ampersand: the entity is &amp; and symbol character is &.
    Greater Than Sign: the entity is &gt; and symbol character is >.
    Less Than Sign: the entity is &lt; and symbol character is <.
    Slash: the entity is &frasl; and symbol character is /.

    Input: text = "&amp; is an HTML entity but &ambassador; is not."
    Output: "& is an HTML entity but &ambassador; is not."

    Input: text = "and I quote: &quot;...&quot;"
    Output: "and I quote: \"...\""
     */



    // 18 ms, 98.72%; 44.7 MB, 35.90%
    public String entityParser(String text) {
        Map<String, String> entities = new HashMap<>();
        entities.put("&quot;", "\"");
        entities.put("&apos;", "'");
        entities.put("&amp;", "&");
        entities.put("&gt;", ">");
        entities.put("&lt;", "<");
        entities.put("&frasl;", "/");

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            char current = text.charAt(i);
            if (current == '&') {
                int endIndex = text.indexOf(';', i);
                if (endIndex != -1) {
                    String potentialEntity = text.substring(i, endIndex + 1);
                    if (entities.containsKey(potentialEntity)) {
                        sb.append(entities.get(potentialEntity));
                        i = endIndex + 1;
                        continue;
                    }
                }
            }
            sb.append(current);
            i++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        HTMLEntityParser solution = new HTMLEntityParser();
        String text = "&amp; is an HTML entity but &ambassador; is not.";

        String parsedText = solution.entityParser(text);
        System.out.println("Parsed Text: " + parsedText);
    }
}
