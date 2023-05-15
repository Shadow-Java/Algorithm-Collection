package algorithm.collection.leetcode.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
 *
 * 请你重新排列这些条形码，使其中任意两个相邻的条形码不能相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 *
 *
 * @author shadow
 * @create 2023-05-14 23:35
 **/
public class RearrangeBarcodes {

    private Map<Integer,Integer> countMap = new HashMap<>();

    public int[] rearrangeBarcodes(int[] barcodes) {
        for (int x : barcodes){
            countMap.put(x,countMap.getOrDefault(x,0)+1);
        }
        int[] res = new int[barcodes.length];
        int lastVal = -1;
        for(int i=0;i<barcodes.length;i++){

        }
        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){

        }
        return null;
    }

    private Map.Entry<Integer,Integer> findMax(int lastVal){
        int maxCount = 0;
        Map.Entry<Integer,Integer> lastEntry = null;
        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){
            if(entry.getValue() > maxCount && entry.getKey() != lastVal){
                maxCount = entry.getValue();
                lastEntry = entry;
            }
        }
        return lastEntry;
    }


    public int[] rearrangeBarcodesTest(int[] barcodes) {
        int n = barcodes.length;
        Integer[] t = new Integer[n];
        int mx = 0;
        for (int i = 0; i < n; ++i) {
            t[i] = barcodes[i];
            mx = Math.max(mx, barcodes[i]);
        }
        int[] cnt = new int[mx + 1];
        for (int x : barcodes) {
            ++cnt[x];
        }
        Arrays.sort(t, (a, b) -> cnt[a] == cnt[b] ? a - b : cnt[b] - cnt[a]);
        int[] ans = new int[n];
        for (int k = 0, j = 0; k < 2; ++k) {
            for (int i = k; i < n; i += 2) {
                ans[i] = t[j++];
            }
        }
        return ans;
    }

}
