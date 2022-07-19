package src;

public class LongestTurbulentSubarray {
    //最长湍流子数组就是只看该数组元素的后一位，数组下标的顺序为偶奇偶奇。。
    //对于当前的数字我需要考虑之前的一位数字，如果是大小，那么后面的就应该是小大，这样组成的数组
    public int maxTurbulenceSize(int[] A) {
        //up为f(k)的最后上升段，down为g(k)的最后下降段
        int up = 1,down = 1;
        int ans = 1;
        for(int i=1;i<A.length;i++){
            if(A[i-1] < A[i]){//最后为上升段
                up = down + 1;down = 1;
            }else if(A[i-1] > A[i]){//最后为下降段
                down = up + 1;up = 1;
            }else{
                up = 1;down =1;
            }
            ans = Math.max(ans,Math.max(up,down));
        }
        return ans;
    }
}
