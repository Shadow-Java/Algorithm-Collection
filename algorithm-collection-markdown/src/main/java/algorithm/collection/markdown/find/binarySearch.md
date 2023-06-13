# 二分查找

应用：给你一个数，通过二分找到数组中的对应位置。

复杂度：O(Nlog(N))

## 通用三种算法模板：

> 入参：左端点；右端点，目标值

### 中间值选择

端点值选择 left=0，right=length-1，两个端点从数组两边开始

中间值的选择：
1.mid=（left+right）/2
0 1 2 3 4 5 6 7  left=0 right=7 mid =4,奇数则是中间偏右 偶数则是中间值
2.mid=left+(right-l)/2
0 1 2 3 4 5 6 7  left=0 righ  t=7 mid =3,奇数则是中间偏左 偶数则是中间值偏左

### while判断的选择

1.while (left <= right)

2.while (left <= right)

### 递归二分：

### 

## 二分搜索边界值
