package co.kr.mono.aop.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilLib {
    public static String lpad(String str, int len, String addStr) {
        StringBuilder result = new StringBuilder(str);
        int templen = len - result.length();

        for (int i = 0; i < templen; i++) {
            result.append(addStr);
        }
        return result.toString();
    }

    public static String currentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:MM:SS"));
    }

}
