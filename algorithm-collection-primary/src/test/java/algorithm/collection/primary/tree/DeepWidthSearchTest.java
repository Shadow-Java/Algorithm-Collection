package algorithm.collection.primary.tree;


import java.util.ArrayList;
import java.util.List;

public class DeepWidthSearchTest {


    /**
     * 计算[1,2,3,4,5,6]的全排列
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        //1,2,3
        //1,3,2
        //2,1,3
        //2,3,1
        //3,1,2
        //3,2,1
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums,0,path,ans);
        ans.forEach(lis ->{
            lis.forEach(i->{
                System.out.print(i+" ");
            });
            System.out.println();
        });
    }

    /**
     * 深度遍历数组的
     * @param nums    提供的数组
     * @param depth   树的枝叶深度(注：叶子深度必须要和path的长度一致)
     * @param path    实时的叶子路径
     * @param ans     结果集
     */
    public static void dfs(int[] nums,int depth,List<Integer> path,List<List<Integer>> ans){
        if(depth == nums.length){
            //添加结果集时需要使用拷贝
            ans.add(new ArrayList<>(path));
            return;
        }else if(depth > nums.length){
            //必须提供一个返回值，不然会一直递归，即叶子深度一直递增导致栈溢出
            return;
        }

        for(int i=0;i<nums.length;i++){
            //路径的添加也需要过滤
            if(path != null && !path.contains(nums[i])){
                //path添加一个，那么对应path删除一个，必须在同一判断里
                path.add(nums[i]);
                dfs(nums,++depth,path,ans);
                path.remove(path.size()-1);
                depth--;
            }
        }
    }

}