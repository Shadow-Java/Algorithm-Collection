package algorithm.collection.leetcode.november.secondweek.november_17st;

/**
 * 2320. 统计放置房子的方式数
 * 一条街道上共有 n * 2 个 地块 ，街道的两侧各有 n 个地块。每一边的地块都按从 1 到 n 编号。每个地块上都可以放置一所房子。
 *
 * 现要求街道同一侧不能存在两所房子相邻的情况，请你计算并返回放置房屋的方式数目。由于答案可能很大，需要对 109 + 7 取余后再返回。
 *
 * 注意，如果一所房子放置在这条街某一侧上的第 i 个地块，不影响在另一侧的第 i 个地块放置房子。
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：4
 * 解释：
 * 可能的放置方式：
 * 1. 所有地块都不放置房子。
 * 2. 一所房子放在街道的某一侧。
 * 3. 一所房子放在街道的另一侧。
 * 4. 放置两所房子，街道两侧各放置一所。
 *
 * 输入：n = 2
 * 输出：9
 * 解释：如上图所示，共有 9 种可能的放置方式。
 *
 * @author shadow
 * @create 2025-02-14 16:46
 **/
public class CountHousePlacements {

    int mod = (int) (Math.pow(10, 9) + 7);

    public int countHousePlacements(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 2;
        //一维数组定义多大
        for (int i = 2; i < n + 1; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % mod;
        }
        //当计算f[n] * f[n]时，如果f[n]接近1e9，相乘会导致int溢出，所以应该转换为long再进行取模
        return (int) ((long) f[n] * f[n] % mod);
    }

}
