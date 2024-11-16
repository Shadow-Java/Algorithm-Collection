package algorithm.collection.schedule;

import algorithm.collection.schedule.ebbinghaus.CustomPolicy;
import algorithm.collection.schedule.ebbinghaus.ReviewPolicy;
import algorithm.collection.schedule.entity.Question;

import java.util.List;

public interface EbbinghausMemoryPlan {

    /**
     * 生成当前的学习计划
     * @return
     */
    List<Question> generateDailyStudyPlan(ReviewPolicy reviewPolicy);


    /**
     * 自定义学习计划
     * @return
     */
    List<Question> generateDailyStudyPlan(CustomPolicy customPolicy);

    /**
     * 加载题库
     * @return
     */
    List<Question> load();

    /**
     * 关闭代理
     * @return
     */
    boolean shutdown();
}
