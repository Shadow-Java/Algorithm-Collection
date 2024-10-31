package algorithm.collection.leetcode.tenmonth.fourtweek.twenty_thirty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author shadow
 * @create 2024-10-30 20:57
 **/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        List<List<Integer>> thirtyList = new ArrayList<>();
        map.put(nums[0],nums[0]);
        for(int i=1;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                Integer third = -nums[i]-nums[j];
                if(map.containsKey(third)) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    ans.add(map.get(third));
                    thirtyList.add(ans);
                    map.remove(third);
                }
            }
            map.put(nums[i],nums[i]);
        }
        List<List<Integer>> res = thirtyList.stream().distinct().collect(Collectors.toList());

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> thirtyList = new ArrayList<>();
        thirtyList.add(List.of(0,0,0));
        thirtyList.add(List.of(0,0,0));
        thirtyList.stream().distinct().forEach(System.out::println);
    }

}
