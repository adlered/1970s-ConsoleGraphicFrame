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
        Map<Integer, Character> chr = new TreeMap<>();
        chr.put(2, 'h');
        chr.put(3, 'e');
        chr.put(4, 'l');
        chr.put(5, 'l');
        chr.put(6, 'o');
        Map<Integer, Map<Integer, Character>> map = new HashMap<>();
        map.put(0, chr);
        map.put(2, chr);
        Print print = new Print(9, 3);
        print.submit(map);
    }

    // 控制台校正功能
}
