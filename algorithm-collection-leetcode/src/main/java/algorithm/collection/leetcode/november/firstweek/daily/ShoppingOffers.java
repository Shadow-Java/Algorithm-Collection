package algorithm.collection.leetcode.november.firstweek.daily;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/shopping-offers/solutions/1063610/gong-shui-san-xie-yi-ti-shuang-jie-zhuan-qgk1/
 * https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247486649&idx=1&sn=ba09ee2d78377c2ddbb9e43622880133
 * 背包问题
 * @author shadow
 * @create 2024-11-03 17:46
 **/
public class ShoppingOffers {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        int[] g = new int[n + 1];
        g[0] = 1;
        for (int i = 1; i <= n; i++) {
            g[i] = g[i - 1] * (needs.get(i - 1) + 1);
        }
        int mask = g[n];
        int[] f = new int[mask];
        int[] cnt = new int[n];
        for (int state = 1; state < mask; state++) {
            f[state] = 0x3f3f3f3f;
            Arrays.fill(cnt, 0);
            for (int i = 0; i < n; i++) {
                cnt[i] = state % g[i + 1] / g[i];
            }
            for (int i = 0; i < n; i++) {
                if (cnt[i] > 0) f[state] = Math.min(f[state], f[state - g[i]] + price.get(i));
            }
            out:for (List<Integer> x : special) {
                int cur = state;
                for (int i = 0; i < n; i++) {
                    if (cnt[i] < x.get(i)) continue out;
                    cur -= x.get(i) * g[i];
                }
                f[state] = Math.min(f[state], f[cur] + x.get(n));
            }
        }
        return f[mask - 1];
    }

}
