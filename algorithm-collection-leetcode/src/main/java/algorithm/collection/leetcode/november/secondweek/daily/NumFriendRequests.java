package algorithm.collection.leetcode.november.secondweek.daily;

import java.util.Arrays;

/**
 * <block>
 *     //nums数组必须要使用Integer，不能用int
 *     //Collections.reverseOrder()
 *     Arrays.sort(nums, new Comparator<Integer>() {
 *             @Override
 *             public int compare(Integer o1, Integer o2) {
 *                 return o1-o2;
 *             }
 *         });
 * </block>
 *
 * 假设我们使用一台每秒可以执行10^8次简单操作的计算机，来计算不同时间复杂度下的实际耗时，数量级在2*10^4
 * 1、常数时间复杂度 O(1)：
 *    耗时：几微秒（假设每次操作耗时10^-8
 * 2、对数时间复杂度O(logN)
 *    耗时：15×10^−8≈1.5×10^−7秒，即大约 0.15 微秒
 * 3、线性时间复杂度O(N)
 *    耗时：2×10^4×10^−8=2×10^−4秒，即大约 0.2 毫秒
 * 4、线性对数时间复杂度O(nlogn)
 *    耗时：3*10^5*10^(-8)=3*10^(-3)秒，大约3毫秒
 * 5、平方时间复杂度O(N^2)
 *    耗时：4*10^8*10^(-8)=4秒
 * @author shadow
 * @create 2024-11-17 16:36
 **/
public class NumFriendRequests {

    public static void main(String[] args) {
        Integer[] nums = {73,106,39,6,26,15,30,100,71,35,46,112,6,60,110};
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num+",");
        }
    }

    /**
     * 根据题意，x 向 y 发送好友请求，只需满足 x/=y 且1/2⋅ages[x]+7<ages[y]≤ages[x]
     * 注意，只要满足了 ages[y]≤ages[x]，题目的第三个条件一定为假。
     *
     * 由于 n 很大而 ages[i]≤120，我们可以用一个长为 121 的 cnt 数组统计每个年龄的人数。
     *
     * 枚举年龄 ageX，我们需要知道：
     *
     * 可以发送好友请求的最小年龄 ageY 是多少。
     * 年龄在区间 [ageY,ageX] 中的人数。
     * 由于 ageX 越大，ageY 也越大，可以用滑动窗口解决。如果你不了解滑动窗口，可以看视频【基础算法精讲 03】。
     *
     * 窗口内维护年龄在区间 [ageY,ageX] 中的人数 cntWindow。
     *
     * 如果发现 cntWindow>0，说明存在可以发送好友请求的用户：
     *
     * 当前这 cnt[ageX] 个用户可以与 cntWindow 个用户发送好友请求，根据乘法原理，这有 cnt[ageX]⋅cntWindow 个。
     * 其中有 cnt[ageX] 个好友请求是自己发给自己的，不符合题目要求，要减去。
     * 所以把
     *
     * cnt[ageX]⋅cntWindow−cnt[ageX]
     * 加入答案。
     * @param ages
     * @return
     */
    public int numFriendRequestsV2(int[] ages) {
        int[] cnt = new int[121];
        for (int age : ages) {
            cnt[age]++;
        }

        int ans = 0;
        int ageY = 0;
        int cntWindow = 0;
        for (int ageX = 0; ageX < cnt.length; ageX++) {
            cntWindow += cnt[ageX];
            if (ageY * 2 <= ageX + 14) { // 不能发送好友请求
                cntWindow -= cnt[ageY];
                ageY++;
            }
            if (cntWindow > 0) { // 存在可以发送好友请求的用户
                ans += cnt[ageX] * cntWindow - cnt[ageX];
            }
        }
        return ans;
    }


    public int numFriendRequests(int[] ages) {
        int count = 0;
        Arrays.sort(ages);
        for(int i=0;i<ages.length;i++) {
            int x = ages[i];
            for(int j=i-1;j>=0;j--) {
                int y = ages[j];
                if(!isVaild(x,y)) {
                    break;
                }
                if(x == y) {
                    count = count+2;
                } else if(x > y) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isVaild(int ageX,int ageY) {
        boolean isVaild = (ageX/2+7 >= ageY) || (ageY > ageX) || (ageY> 100 && ageX < 100);
        return !isVaild;
    }
}
