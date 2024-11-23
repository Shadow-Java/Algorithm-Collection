package algorithm.collection.leetcode.bitManipulation;

/**
 * 给一个整数n，请转为2-16进制的数
 * 67. 二进制求和
 *
 * 一个数求进制的本质：
 *    1.在任意进制中，每个位置上的数字表示的是该位置权重的倍数
 *    2.例如，在十进制中，数字 123 可以表示为：123=1×10^2+2×10^1+3×10^0
 *    3.类似地，在二进制中，数字 1101 可以表示为1101 =1×2^3  +1×2^2  +0×2^1  +1×2^0
 *    计算 num % base 可以得到 num 在当前进制下的最低位数字。
 *       例如，对于 num = 100 和 base = 16：
 *       1.第一次计算 100 % 16 得到 4，这是 100 在十六进制下的最低位数字。
 *       2.接下来，将 num 更新为 100 / 16，即 6，继续计算 6%16 得到 6，这是 100 在十六进制下的第二位数字。
 *       3.最终，100 在十六进制下表示为 64。
 *    构建最终结果：
 *      1.每次计算出的余数是当前位的数字，我们需要将这些数字按顺序插入到结果字符串中。
 *      2.由于我们是从最低位开始计算的，所以每次将余数插入到结果字符串的开头，以确保最终结果是正确的顺序
 * @author shadow
 * @create 2024-10-27 22:39
 **/
public class NumberConverter {

    public static void main(String[] args) {
        NumberConverter numberConverter = new NumberConverter();
        System.out.println(numberConverter.covert2(11,2));
    }

    /**
     * 适用于任何小于或等于10的进制；
     * 大于10的进制，你需要使用字母字符（'A'-'Z'）来表示10及以上的数值
     * @param num
     * @return
     */
    public String covert2(int num,int base) {
        StringBuilder ans = new StringBuilder();
        while (num!=0) {
            //因为取的是1所以求余，得出的数倒着排序
            ans.insert(0,num%base);
            num = num/base;
        }
        return ans.toString();
    }

    /**
     * 405. 数字转换为十六进制数
     * 1837. K 进制表示下的各位数字总和
     * 504. 七进制数
     * @param number
     * @param base
     * @return
     */
    public static String convertToBase(int number, int base) {
        if (base < 2 || base > 16) {
            throw new IllegalArgumentException("Base must be between 2 and 16.");
        }
        if(number == 0) {
            return "0";
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


    /**
     * 兼容负数场景：当求负数时，通过该数的补码再进行进制转换
     * 对于负数的 num，我们需要先在 num 基础上加上 2^32的偏移量，再进行进制转换。
     *
     * @param number
     * @param base
     * @return
     */
    public static String convertToBaseV2(int number, int base) {
        if(number == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        long num = number;
        /**
         * 用于表示不同进制中的数字字符。对于2到16进制的转换，我们需要使用从0到9的字符以及A到F的字符来表示数字
         * 例如：
         *
         * 十进制 (Base 10): 使用 0-9
         * 十六进制 (Base 16): 使用 0-9 和 A-F
         * digits 字符串 "0123456789ABCDEF" 包含了这些字符。使用它可以方便地获取任意余数对应的字符
         */
        String digits = "0123456789abcdef";
        //32位整数的补码表示中，负数的最高位（符号位）是1，加上2^32可以使其变为正数
        if(num < 0) num = (long)(Math.pow(2, 32) + num);
        while (num > 0) {
            int remainder = (int)(num % base);
            result.insert(0, digits.charAt(remainder));
            num /= base;
        }

        return result.toString();
    }

    /**
     * 将负数转换为补码形式的方式:
     *    1.取反加一（反码加一）:整数的表示是以补码形式存储的，因此直接对负数进行按位取反并加一的操作并不会得到负数的补码表示。这是因为 Java 中整数是有符号的，而按位取反并加一的结果可能不会得到正确的负数补码表示
     *    2.先将负数转换为长整型（long 类型），然后进行位操作，以确保负数被正确地转换为补码形式 numLong = (long) (Math.pow(2, 32) + numLong);
     * @param num
     * @return
     */
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        //在java中，0xFFFFFFFFL代表的是一个长整型（long）的十六进制字面值。它的十进制值是4294967295，即无符号整数的最大值，对应十六进制表示为0xFFFFFFFF
        long numLong = num & 0xFFFFFFFFL; // 将负数转换为补码形式
        while (numLong > 0) {
            int digit = (int)(numLong % 16);
            sb.insert(0, hexChars[digit]);
            numLong /= 16;
        }

        return sb.toString();
    }

}
