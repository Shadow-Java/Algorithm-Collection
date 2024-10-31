package algorithm.collection.leetcode.bitManipulation;

/**
 * 给一个整数n，请转为2-16进制的数
 * @author shadow
 * @create 2024-10-27 22:39
 **/
public class NumberConverter {

    public static void main(String[] args) {
        int number = 10; // Example number
        for (int base = 2; base <= 16; base++) {
            String result = convertToBase(number, base);
            System.out.println("Base " + base + ": " + result);
        }
    }

    public static String convertToBase(int number, int base) {
        if (base < 2 || base > 16) {
            throw new IllegalArgumentException("Base must be between 2 and 16.");
        }

        StringBuilder result = new StringBuilder();
        /**
         * 用于表示不同进制中的数字字符。对于2到16进制的转换，我们需要使用从0到9的字符以及A到F的字符来表示数字
         * 例如：
         *
         * 十进制 (Base 10): 使用 0-9
         * 十六进制 (Base 16): 使用 0-9 和 A-F
         * digits 字符串 "0123456789ABCDEF" 包含了这些字符。使用它可以方便地获取任意余数对应的字符
         */
        String digits = "0123456789ABCDEF";

        while (number > 0) {
            int remainder = number % base;
            result.insert(0, digits.charAt(remainder));
            number /= base;
        }

        return result.toString();
    }

}
