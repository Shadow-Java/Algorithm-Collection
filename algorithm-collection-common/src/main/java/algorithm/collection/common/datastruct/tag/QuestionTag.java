package algorithm.collection.common.datastruct.tag;

/**
 * 题型分类：用于后期算法题拓展，比如算法的类别处理
 *
 * @author shadow
 * @date 2023/5/27 11:03
 * @since 1.0
 */
public @interface QuestionTag {

    /**
     * 题号
     * @return
     */
    String questionNumber();

    /**
     * 题目title
     */
    String questionTitle();

    /**
     * 难度
     */
    DifficultyLevel difficultyLeve() default DifficultyLevel.EASY;

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
