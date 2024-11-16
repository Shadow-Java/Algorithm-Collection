package algorithm.collection.schedule;

import algorithm.collection.schedule.ebbinghaus.Configuration;
import algorithm.collection.schedule.ebbinghaus.CustomPolicy;
import algorithm.collection.schedule.ebbinghaus.ReviewPolicy;
import algorithm.collection.schedule.entity.Question;

import java.util.List;

/**
 * @author shadow
 * @create 2024-11-16 14:36
 **/
public class EbbinghausMemoryPlanImpl implements EbbinghausMemoryPlan {

    /**
     * 持有一个系统配置，或者参数
     */
    private Configuration configuration;

    EbbinghausMemoryPlanImpl(Configuration configuration) {
        this.configuration = configuration;
    }


    @Override
    public List<Question> generateDailyStudyPlan(ReviewPolicy reviewPolicy) {
        //优先middle和hard
        //优先未提交的算法
        //可以期望这次能够偏那种题型多一点
        return List.of();
    }

    @Override
    public List<Question> generateDailyStudyPlan(CustomPolicy customPolicy) {
        return List.of();
    }

    @Override
    public List<Question> load() {
        return List.of();
    }

    @Override
    public boolean shutdown() {
        return false;
    }
}
