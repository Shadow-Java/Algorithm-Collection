package intermittent.lying.continuous.progress.deprecated;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisible {
    /**
     *左移相当于乘二，当num=23，那么num <<= 1;就是46
     **/
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();

        int num = 0;
        for (int i = 0;i < A.length;i++) {
            num <<= 1;//对之前的数据左移一位
            num += A[i];//加上现在的数据
            num %= 10;//求余数
            ans.add(num % 5 == 0);
        }

        return ans;
    }
}
