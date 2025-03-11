package algorithm.collection.primary.bitoperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * next()
 *    功能：读取下一个单词（以空白符为分隔）
 *    场景：读取单个非空字符串输入
 *    System.out.print(" 输入姓名：");
 *    String name = in.next();  // 用户输入"John Doe"时返回"John"
 * nextLine()
 *    功能：读取整行文本（包括空格，直到换行符）
 *    场景：读取包含空格的完整句子或多段输入
 * nextInt() / nextDouble()
 *    功能：读取整数或浮点数
 *    场景：数值计算或配置参数输入
 * 输入验证方法
 *      hasNext() / hasNextInt()
 *      功能：检测输入流中是否存在下一个符合类型要求的标记
 *      场景：循环输入验证或避免异常
 * 如果不想有while，则每个输入和输出 用变量
 * @author shadow
 * @create 2025-03-02 21:41
 **/
public class InputTest {

    public static void main(String[] args) {
        InputTest inputTest = new InputTest();
        inputTest.testInput();
    }

    public void testInputV2() {
        Scanner in = new Scanner(System.in);

        /**
         * hasNext()
         * nextInt() 每次读一个int，接收的是一个int
         * hasNextLine()验证是否有下一行，如果是输入的话则in.nextLine()
         *
         */
        while (in.hasNextLine()) {
            int a = in.nextInt();
            System.out.println("第" + a + "组数据");
            for (int i = 1; i <= a; i++) {
                int b = in.nextInt();
                System.out.println("有" + b + "个物品");
                List<Integer> ans = new ArrayList<>();
                for (int j = 1; j <= b; j++) {
                    int x = in.nextInt();
                    ans.add(x);
                }
                ans.forEach(System.out::println);
                ans.clear();
                for (int j = 1; j <= b; j++) {
                    int y = in.nextInt();
                    ans.add(y);
                }
                ans.forEach(System.out::println);
            }
            //这里写业务代码，
        }
        System.out.println("结束");
    }

    public void testInput() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(a);

        while (sc.hasNextLine()) {//输入一行数据
            int b = sc.nextInt();//一行数据里的第一个数字
            int c = sc.nextInt();//一行数据里的第二个数字
            System.out.println(b+"  "+c);
        }
    }


}
