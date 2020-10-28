import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 *
 *解决方法：统计数字的不同与出现次数的不同，如果出现次数和数字个数相同则返回true，否则返回false
 *
 */

public class UniqueNumberOccurrences {

    /**
     * 利用两个hash统计不同的出现次数，如果都相同则返回true，否则返回false
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer>  occur = new HashMap<>();
        for(int element : arr){
            occur.put(element,occur.getOrDefault(element,0)+1);
        }
        Set<Integer> set = new HashSet<>(occur.values());
        return occur.size() == set.size();
    }

}
