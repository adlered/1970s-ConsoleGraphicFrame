package pers.adlered.s1970;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author https://github.com/AdlerED
 * @version 1.0
 * <p>简化数据交互</p>
 * @date 2020/1/17 10:01
 */
public class DataCGF {
    /**
     * Map<String, String> 泛型定义：
     * 第一个 String：范围
     * 第二个 String：内容
     * 例如从第2个字符开始，打印 hello
     * 可传 custom.put("2", "hello");
     * 或 custom.put("2-6", "hello"); 有容错机制。
     * 返回结果列数以 width 为准。
     * 因为大家都是程序员，所以按照习惯，范围从 0 开始，到 (length - 1) 结束。
     * @return
     */
    public static Map<Integer, Character> convertToLine(Map<String, String> custom, int width) {
        Map<Integer, Character> chr = new TreeMap<>();
        // 枚举并写入
        Iterator<Map.Entry<String, String>> itr = custom.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, String> map = itr.next();
            String range = map.getKey();
            String str = map.getValue();
            char[] convertCharArr = str.toCharArray();
            if (range.indexOf("-") != -1) {
                String[] rangeRes = range.split("-");
                int startAt = Integer.parseInt(rangeRes[0]);
                int endAt = Integer.parseInt(rangeRes[1]);
                if ((convertCharArr.length - 1) == (endAt - startAt)) {
                    // 设定范围符合
                    int charCur = 0;
                    for (int i = startAt; i <= endAt; i++) {
                        chr.put(i, convertCharArr[charCur]);
                        ++charCur;
                    }
                } else {
                    //设定范围不符合
                    break;
                }
            } else {
                int startAt = Integer.parseInt(range);
                int charCur = 0;
                for (int i = startAt; i < (startAt + convertCharArr.length); i++) {
                    chr.put(i, convertCharArr[charCur]);
                    ++charCur;
                }
            }
        }
        // 返回转化后 Print.line() 方法可接受的类
        return chr;
    }
}
