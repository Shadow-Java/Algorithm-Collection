package algorithm.collection.schedule.domain;


import algorithm.collection.schedule.ebbinghaus.MasterLevel;

/**
 * @author shadow
 * @create 2024-11-02 14:22
 **/
public class QuestionDO extends BaseDO {
    /**
     * 题号
     */
    private String number;
    /**
     * link
     */
    private String questionLink;
    /**
     * 题目title
     */
    private String questionTitle;
    /**
     * 题目描述
     */
    private String desc;
    /**
     * 算法分类，很多种解法
     */
    private String algorithmCategorys;
    /**
     * 关联的数据结构类型
     */
    private String dataStructTypes;
    /**
     * 难易程度：easy、hard和medium
     */
    private String difficultyLevel;
    /**
     * 相似的题目
     */
    private String similarQuestionIds;
    /**
     * 上一次提交
     */
    private Long lastSubmissionTime;

    /**
     * 掌握程度
     */
    private String masterLevel;

}
