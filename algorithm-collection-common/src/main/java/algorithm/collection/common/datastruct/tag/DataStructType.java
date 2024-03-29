package algorithm.collection.common.datastruct.tag;

/**
 * 使用的什么数据结构
 *
 * @author shadow
 * @date 2023/5/27 11:24
 * @since 1.0
 */
public enum DataStructType {

    /**
     * 树
     */
    UNIVERSAL_TREE("UNIVERSAL_TREE"),
    /**
     * 数组
     */
    ARRAY_LIST("ARRAY_LIST"),

    HASH_MAP("HASH_MAP"),
    /**
     * 一般的栈
     */
    UNIVERSAL_STACK("UNIVERSAL_STACK"),

    SYSTEM_STACK("SYSTEM_STACK"),
    /**
     * 单调栈
     */
    MONOTONIC_STACK("MONOTONIC_STACK"),
    /**
     * 二叉树
     */
    BINARY_TREE("BINARY_TREE"),
    /**
     * 二叉搜索树
     * 特点：
     * 1.左节点总比节点小，右节点总比节点大
     * 2.中序遍历为从小到大排序（由第一个特点得出）
     */
    BINARY_SEARCH_TREE("BINARY_SEARCH_TREE"),
    /**
     * 平衡的二叉搜索树
     */
    BALANCE_BINARY_SEARCH_TREE("BALANCE_BINARY_SEARCH_TREE"),
    /**
     * 队列
     */
    UNIVERSAL_QUEUE("UNIVERSAL_QUEUE"),
    /**
     * 双端队列
     */
    //双端队列
    DEDED_DOUBLE_QUEUE("DEDED_DOUBLE_QUEUE"),

    HEAP("HEAP"),
    /**
     * 链表
     */
    UNIVERSAL_LINKLIST("UNIVERSAL_LINKLIST"),
    /**
     * 单链表
     */
    SINGLE_LINKLIST("SINGLE_LINKLIST");

    private String value;

    DataStructType(String level) {
        this.value = level;
    }

    public String getValue(){
        return value;
    }

    public static DataStructType fromValue(String level){
        for (DataStructType b : DataStructType.values()){
            if(b.value.equals(level)){
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '"+level+"'");
    }

}
