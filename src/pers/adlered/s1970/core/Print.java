package pers.adlered.s1970.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author https://github.com/AdlerED
 * @version 1.0
 * <p>按要求打印</p>
 * @date 2020/1/16 17:55
 */
public class Print {
    // 空白处默认打印字符
    private char defaultChar = '#';
    // 如每行最后一个字符串后仍有空行，是否删除剩余空行
    private boolean deleteRemaining = true;

    private int width;
    private int height;

    public Print(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // 调用 line() 方法逐行打印
    public void submit(Map<Integer, Map<Integer, Character>> map) {
        for (int i = 0; i < height; i++) {
            Map<Integer,Character> aLine = map.get(i);
            if (aLine == null) {
                aLine = new TreeMap<>();
            }
            boolean noNewLine = (i == (height - 1));
            line(aLine, noNewLine);
        }
    }

    // 按行打印，超出宽度则忽略
    public void line(Map<Integer, Character> chr, boolean noNewLine) {
        char[] output = new char[width];
        // 填充 output 数组中整行
        for (int i = 0; i < width; i++) {
            output[i] = defaultChar;
        }
        // 替换 chr 中提供的文字
        Iterator<Map.Entry<Integer, Character>> iterator = chr.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Character> integerCharacterEntry = iterator.next();
            int index = integerCharacterEntry.getKey();
            Character character = integerCharacterEntry.getValue();
            try {
                output[index] = character;
            } catch (ArrayIndexOutOfBoundsException AIOOBE) {
                continue;
            }
        }
        // 删除空字符
        if (deleteRemaining) {
            boolean emB = false;
            int emC = -1;
            for (int i = (output.length - 1); i >= 0; i--) {
                if (output[i] != defaultChar) {
                    emB = true;
                    emC = i + 1;
                    break;
                }
            }
            if (emB) {
                char[] tempNewOutput = new char[emC];
                for (int i = 0; i < emC; i++) {
                    tempNewOutput[i] = output[i];
                }
                output = tempNewOutput;
            } else {
                output = new char[0];
            }
        }
        for (char c : output) {
            System.out.print(c);
        }
        if (!noNewLine) {
            System.out.println();
        }
    }
}
