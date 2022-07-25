package intermittent.lying.continuous.progress.deprecated;
/*
* 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

输入:
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

输出: 3

解释:
从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
因此，3 可为起始索引。

 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int minSpare = Integer.MAX_VALUE;
        //数组当成圆形的思想
        int res = 0;int index = 0 ;
        for(int i=0;i<gas.length;i++){
            res += gas[i]-cost[i];
            if (res < minSpare) {
                minSpare = res;
                index = i;
            }
        }

        return res < 0 ? -1 : (index + 1) % gas.length;
    }


    /**
     * 暴力解法：尝试从每一个点出发，看是否能够走到原点
     * 数组当成圆形的思想，j = (j + 1) % n;可以循环转动
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit_2(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {//考虑从每一个点出发
            int j = i;
            int remain = gas[i];
            //当前剩余的油能否到达下一个点
            while (remain - cost[j] >= 0) {//whle循环，一个走到原点
                //减去花费的加上新的点的补给
                remain = remain - cost[j] + gas[(j + 1) % n];
                j = (j + 1) % n;//一直转圈走
                //j 回到了 i
                if (j == i) {
                    return i;
                }
            }
        }
        //任何点都不可以
        return -1;
    }

}
