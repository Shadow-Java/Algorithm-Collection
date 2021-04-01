# 二叉树

## 一、二叉树的递归思维

**快速排序**就是二叉树的`前序遍历`，**归并排序**就是二叉树的`后序遍历`

快排的逻辑就是，若要对nums[0..n-1]进行排序，那么可以找到一个`分界点p`，交换元素使得nums[0..p-1]都小于nums[p],nums[p+1..n]都大于nums[p];
然后依次递归nums[0..p-1]和nums[p+1..n-1]寻找新的分界点，最后整个数组就排序了。

快速排序框架：

```java
void sort(int[] nums,int start,int end){
    int p = partition(nums,start,end);//找到分界点，使得左边都小于nums[p],右边都大于nums[p]
    sort(start,p-1);//再依次排序剩余节点
    sort(p+1,end);
}
```

归并排序的逻辑就是，若要对nums[0..n-1]进行排序，那么可以对两个子数组进行排序再合并，类似于二叉树的后序遍历

归并排序框架：

```java
void sort(int[] nums,int start,int end){
    int mid = (start+end)/2;
    sort(nums,start,mid);//排序子数组
    sort(nums,mid+1,end);//排序子数组
    merge(nums,start,mid,end);//合并两个子数组
}
```

递归的思路就是需要明确函数的定义是什么，不要纠结递归细节，相信这个定义



## 二、回溯算法（DFS）

其实回溯算法其实就是我们常说的 DFS 算法，本质上就是一种暴力穷举算法。

解决一个回溯问题，实际上就是一个决策树的遍历过程。你只需要思考 3 个问题：

1、路径：也就是已经做出的选择。
2、选择列表：也就是你当前可以做的选择。
3、结束条件：也就是到达决策树底层，无法再做选择的条件。

### 2.1 全排列问题
求n个不重复的数，全排列共有n！个

回溯算法框架：
```java
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return

    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
```

那么如何遍历一棵树呢？

```java
void traverse(TreeNode root) {
    for (TreeNode child : root.childern)
        // 前序遍历需要的操作
        traverse(child);
        // 后序遍历需要的操作
}
```

全排列代码：
```java
List<List<Integer>> res = new LinkedList<>();

/* 主函数，输入一组不重复的数字，返回它们的全排列 */
List<List<Integer>> permute(int[] nums) {
    // 记录「路径」
    LinkedList<Integer> track = new LinkedList<>();
    backtrack(nums, track);
    return res;
}

// 路径：记录在 track 中
// 选择列表：nums 中不存在于 track 的那些元素
// 结束条件：nums 中的元素全都在 track 中出现
void backtrack(int[] nums, LinkedList<Integer> track) {//所有选择nums，track为走过的路径
    // 触发结束条件
    if (track.size() == nums.length) {
        res.add(new LinkedList(track));
        return;
    }

    for (int i = 0; i < nums.length; i++) {
        // 排除不合法的选择
        if (track.contains(nums[i]))//走过的选择不能再走
            continue;
        // 做选择
        track.add(nums[i]);
        // 进入下一层决策树
        backtrack(nums, track);//track下的其他nums选择
        // 取消选择
        track.removeLast();//取消该选择，回溯同级的其他选择
    }
}
```

但是这种穷举整科决策树，时间复杂度不会低于O（N！），这是无法避免的。这也是回溯算法的一个特点，不像动态规划存在重叠子问题可以优化，回溯算法就是纯暴力穷举，复杂度一般都很高。 

### 2.2 组合问题（回溯）

>输入两个数字 n, k，算法输出 [1..n] 中 k 个数字的所有组合。
比如输入 n = 4, k = 2，输出如下结果，顺序无所谓，但是不能包含重复（按照组合的定义，[1,2] 和 [2,1] 也算重复）：

```java
vector<vector<int>>res;

vector<vector<int>> combine(int n, int k) {
    if (k <= 0 || n <= 0) return res;
    vector<int> track;
    backtrack(n, k, 1, track);
    return res;
}

void backtrack(int n, int k, int start, vector<int>& track) {
    // 到达树的底部
    if (k == track.size()) {
        res.push_back(track);
        return;
    }
    // 注意 i 从 start 开始递增
    for (int i = start; i <= n; i++) {
        // 做选择
        track.push_back(i);
        backtrack(n, k, i + 1, track);
        // 撤销选择
        track.pop_back();
    }
}
```

### 2.3 子集问题（回溯）
>输入一个不包含重复数字的数组，要求算法输出这些数字的所有子集。

比如输入 nums = [1,2,3]，你的算法应输出 8 个子集，包含空集和本身，顺序可以不同：

[ [],[1],[2],[3],[1,3],[2,3],[1,2],[1,2,3] ]

```java
vector<vector<int>> res;

vector<vector<int>> subsets(vector<int>& nums) {
    // 记录走过的路径
    vector<int> track;
    backtrack(nums, 0, track);
    return res;
}

void backtrack(vector<int>& nums, int start, vector<int>& track) {
    res.push_back(track);
    // 注意 i 从 start 开始递增
    for (int i = start; i < nums.size(); i++) {
        // 做选择
        track.push_back(nums[i]);
        // 回溯
        backtrack(nums, i + 1, track);
        // 撤销选择
        track.pop_back();
    }
}
```
**总结：**在代码中的体现就是，排列问题每次通过 contains 方法来排除在 track 中已经选择过的数字；而组合问题通过传入一个 start 参数，来排除 start 索引之前的数字。

### 单调栈（DFS）
如果是TreeNode类型，可以利用单调找去维护当前遍历的左节点
题号：173.二叉树搜索树迭代器

```java
public class T173 {
	Deque<TreeNode> stack = new LinkedList<TreeNode>();
	public T173(TreeNode root) {//初始化头结点的所有左节点，入栈
        TreeNode node = root;
        while(node!=null) {
        	stack.push(node);
        	node=node.left;
        }
    }
    
    public int next() {//当前栈顶出栈，出栈的节点如果有右节点，将右节点的所有左节点入栈，依次循环
    	TreeNode node = stack.pop();
    	if(node.right!=null) {
    		TreeNode p = node.right;
    		while(p!=null) {
    			stack.push(p);
    			p=p.left;
    		}
    	}
    	return node.val;
    }
    
    public boolean hasNext() {
    	return !stack.isEmpty();
    }
}
```


思考问题，对于数组类型，去求不重复的数的List；对于TreeNode类型，去求不重复的数List；
