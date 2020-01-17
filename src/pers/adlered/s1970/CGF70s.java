package pers.adlered.s1970;

import pers.adlered.s1970.core.Print;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author https://github.com/AdlerED
 * @version 1.0
 * <p>高性能、精简的 Java 控制台图形框架</p>
 * @date 2020/1/16 17:44
 */
public class CGF70s {
    // 临时方法
    public static void run() {

        Map<String, String> custom = new TreeMap<>();
        custom.put("0", "hello");
        Map<String, String> custom2 = new TreeMap<>();
        custom2.put("4", "world");

        Map<Integer, Map<Integer, Character>> map = new HashMap<>();
        map.put(0, DataCGF.convertToLine(custom, 9));
        map.put(2, DataCGF.convertToLine(custom2, 9));
        Print print = new Print(9, 3);
        print.submit(map);
    }

    // 控制台校正功能
}
