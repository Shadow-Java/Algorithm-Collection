package algorithm.collection.primary.recursive;

/**
 * @author shadow
 * @create 2023-05-14 14:25
 **/
public class RecuriveExample {

    /**
     * 给一块土地，想划分为正方形，但不确定什么是最大的正方形
     */
    public static void findMaxSquare(int longth,int width) {
        if(longth == width){
            System.out.println("最大的宽度为："+width);
            return;
        }
        if(longth > width){
            findMaxSquare(longth-width,width);
        }else{
            findMaxSquare(longth,width-longth);
        }
    }

    /**
     * 使用递归求和num数组
     * sum表示求的是0-n-1的和
     * @param n
     */
    public static int sum(int[] num,int n,int sum,int cur) {
        if(n == cur){
            return sum;
        }
        return num[cur]+sum(num,n,sum,++cur);
    }

    /**
     * 表明计算(0,n-1)的数组的最大值
     * @param num
     * @param n
     * @param cur
     */
    public static int findMaxValue(int[] num,int n,int cur){
        if(n == cur){
            return num[n-1];
        }
        return Math.max(num[cur],findMaxValue(num,n,++cur));
    }

    public static void main(String[] args) {
        int longth = 1680,width = 640;
        findMaxSquare(longth,width);

        int[] num = {4,5,2,6};
        int res = 0;
        for (int x: num) {
            res += x;
        }
        System.out.println("总和为："+res);
        int sum = 0;
        System.out.println("总和为："+sum(num,4,sum,0));
        int[] num_max = {-1,-3,-6,-4};
        System.out.println("最大值为："+findMaxValue(num_max,4,0));
    }

}
