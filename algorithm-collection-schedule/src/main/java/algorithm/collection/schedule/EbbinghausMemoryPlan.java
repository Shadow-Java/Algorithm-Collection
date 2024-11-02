package algorithm.collection.schedule;

import java.util.List;

public interface EbbinghausMemoryPlan {

    /**
     * 生成当前的学习计划
     * @return
     */
    List<String> generateDailyStudyPlan();
}
