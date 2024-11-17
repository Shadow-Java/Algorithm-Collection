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
     * 题目链接
     * @return
     */
    String questionLink() default "https://leetcode.cn/problemset/all/";

    /**
     * 题目描述
     * @return
     */
    String desc() default "";

    /**
     * 难度
     */
    DifficultyLevel difficultyLeve() default DifficultyLevel.EASY;

    /**
     * 时间复杂度
     */
    TimeComplexity timeComplexity() default TimeComplexity.O_N;

    /**
     * 是否是会员题
     * @return
     */
    boolean membershipQuestion() default false;

    /**
     * 关联的题解
     * @return
     */
    Class[] relevateClass() default {};

    /**
     * 题目的记忆周期
     * @return
     */
    MemoryCycle memoryCycle() default MemoryCycle.FIRST;

    /**
     * 根据艾宾浩斯遗忘曲线进行学习的重复记忆<br/>
     * 周期越低证明你越需要重复重复再重复
     */
    SegmentLevel segmentLevel() default SegmentLevel.SENSORY_MEMORY;

    /**
     * 使用的数据结构
     * @return
     */
    DataStructType[] dataStructTypes() default {};

    /**
     * 使用的什么类型的算法
     * @return
     */
    AlgorithmCategory[] algorithmCategory() default {};

    QuestionCategory[] questionCategory() default {};

}
