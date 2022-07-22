package intermittent.lying.continuous.progress.deprecated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
 *
 * 返回森林中兔子的最少数量。
 *
 * 示例:
 * 输入: answers = [1, 1, 2]
 * 输出: 5
 * 解释:
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
 *
 * 输入: answers = [10, 10, 10]
 * 输出: 11
 *
 * 输入: answers = []
 * 输出: 0
 *
 */
public class RabbitsinForest {

    /**
     * 思路：该题类似于脑筋急转弯，不太利于学习，找规律能解
     * @param answers
     * @return
     */
    public static int numRabbits(int[] answers) {
        if(answers.length == 0){
            return 0;
        }
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<answers.length;i++){
            hashMap.put(answers[i],hashMap.getOrDefault(answers[i],0)+1);
        }
        int result = 0;
        /**
         * 如果出现次数和当前的key+1不等，则不是
         * 那就是 出现次数 == key+1的为一种颜色，其他的则
         * 数字不相等的那肯定是不同颜色的
         */
        for(Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
            int re = entry.getValue()%(entry.getKey()+1);
            int ser = entry.getValue()/(entry.getKey()+1);
            if(re > 0){
                result += (entry.getValue()/(entry.getKey()+1))*(entry.getKey()+1) +entry.getKey()+1 ;
            }else if(re == 0){
                result += (entry.getValue()/(entry.getKey()+1))*(entry.getKey()+1);
            }else if(ser == 0 && (entry.getKey()+1 >= entry.getValue())){
                result += entry.getKey()+1;
            }
        }
        return result;
    }


}
