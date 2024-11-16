package algorithm.collection.schedule.ebbinghaus;

/**
 * 复习策略
 * @author shadow
 * @create 2024-10-27 20:52
 **/
public class ReviewPolicy {

    /**
     * 在计划内在能够容忍的学习的数量
     */
    private int ratio;
    /**
     * 在计划内能学习的最多数量
     */
    private int maxDailySize = 4;
    /**
     * 天计划
     */
    private PlanInterval dailyPlan;
}
