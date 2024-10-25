package algorithm.collection.schedule.schedulejob;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public interface StudyPlanService {

    /**
     * 生成对应的学习计划
     * @return
     */
    List<String> generateStudyPlan();

    /**
     * 注册学习计划
     * @return
     */
    void registerStudyPlan();

    /**
     * 注册特定的时间维度的学习计划
     * @param items
     * @param timeDimension
     * @return
     */
    List<String> pushSpecifiedStudyPlan(List<String> items, TimeUnit timeDimension);

    List<String>
}
