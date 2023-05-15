package com.sjia.poc;
import org.apache.commons.lang3.StringUtils;

public class EncodeJapanese {

    private static final String PREFIX = "&#";
    private static final String SUFFIX = ";";

    private static String encodeString(String val) {
        if (StringUtils.isNotBlank(val)) {
            final StringBuilder encodedValue = new StringBuilder();
            for (int i = 0; i < val.length(); i++) {
                final char ch = val.charAt(i);
                encodedValue.append(PREFIX).append((int) ch).append(SUFFIX);
            }
            return encodedValue.toString();
        }
        return val;
    }





    public static void main(String[] args) {
        String testData_01 = "辻\uDB40\uDD00井";
        String testData_01b = "辻井";


        String testData_02 = "大阪府";
        String testData_02b = "大阪府";

        // db40: 56128
        // dd00: 56576
        // 65536 + ((56128 - 55,296) * 1,024) + (56576 - 56320)=917760
        String testData_03  = "辻\uDB40\uDD00井"; // customerOrderConsumeFinalAudit


        System.out.println( "encodeString testData_01  is:  " + encodeString(testData_01));
        System.out.println( "encodeString testData_01 length is:  " + testData_01.length());
        System.out.println( "encodeString testData_01b  is:  " + encodeString(testData_01b));

        System.out.println( "encodeString testData_02  is:  " + encodeString(testData_02));

    }
}
