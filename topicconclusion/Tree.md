# 二叉树

## 二叉树的递归思维

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

