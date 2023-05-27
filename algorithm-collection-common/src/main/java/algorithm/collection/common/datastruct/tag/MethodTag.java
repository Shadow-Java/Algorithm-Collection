package algorithm.collection.common.datastruct.tag;

/**
 * 所属题号的不同方法实现
 *
 * @author shadow
 * @date 2023/5/27 12:30
 * @since 1.0
 */
public @interface MethodTag {

    /**
     * 题号
     * @return
     */
    String questionNumber();

    /**
     * 时间复杂度
     */
    TimeComplexity timeComplexity() default TimeComplexity.O_N;

    /**
     * 使用的数据结构
     * @return
     */
    DataStructType dataStructType();

    /**
     * 使用的什么类型的算法
     * @return
     */
    AlgorithmCategory algorithmCategory();

}
