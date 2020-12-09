package SourceCode.src;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class CountPrimes {
    public int countPrimes(int n) {//枚举2 -（n-1）
        int count = 0;
        for(int i = 2;i<n;i++){
            if(isPrime(i)) count++;
        }
        return count;
    }

    /**
     * 枚举：判断一个数是否为质数，只需要枚举2-√N，如果x是n的因数，那么n/x也是n的因数
     * @param n
     * @return
     */
    public boolean isPrime(int n){
        for(int i=2;i*i <= n;i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}
