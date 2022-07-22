package intermittent.lying.continuous.progress.deprecated;

public class OnesAndZeroes {
    /** 0-1背包问题
     * 输入: strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
     * 输出: 4
     * 解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];//表示m个0 n个1能组成的字符串
        for(String str : strs){
            int zero =0; int one = 0;
            for(char c : str.toCharArray()){
                if(c == '0'){
                    zero++;
                } else one++;
            }

            for(int i=m;i >= zero;i-- ){
                for(int j=n;j >= one;j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i-zero][j-one]+1);
                }
            }
        }
        return dp[m][n];
    }
}
