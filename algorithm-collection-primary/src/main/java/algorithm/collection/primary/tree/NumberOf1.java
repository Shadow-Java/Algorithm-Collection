package algorithm.collection.primary.tree;

public class NumberOf1 {

    public static void main(String[] args) {
        System.out.println(numberOfRad(10,8));
    }

    /**
     * 给一个num值将翻译为base进制，base范围2-16
     * @param num
     * @param base
     * @return
     */
    public static int numberOfRad(int num,int base) {
        StringBuilder stringBuilder= new StringBuilder();
        while (num > 0) {
            stringBuilder.insert(0,num%base);
            num=num/base;
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
