package algorithm.collection.schedule;

import algorithm.collection.schedule.ebbinghaus.Configuration;
import algorithm.collection.schedule.ebbinghaus.ReviewPolicy;
import algorithm.collection.schedule.entity.Question;
import cn.hutool.core.date.DateUtil;

import java.util.Date;
import java.util.List;

/**
 * 学习监督器
 * @author shadow
 * @create 2024-11-16 14:52
 **/
public class SupervisedAgent {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        EbbinghausMemoryPlan ebbinghausMemoryPlan  = new EbbinghausMemoryPlanImpl(configuration);
        ReviewPolicy reviewPolicy = new ReviewPolicy();
        List<Question> questions = ebbinghausMemoryPlan.generateDailyStudyPlan(reviewPolicy);
        Date now = DateUtil.date();
        // 格式化为 "yyyy-MM-dd HH:mm:ss" 格式
        String formattedDate = DateUtil.format(now, "yyyy-MM-dd HH:mm:ss");
        System.out.println("-------------------"+formattedDate+ ":Leetcode 学习内容如下,请当天完成不要拖欠-------------------");
        for (Question question : questions) {

        }
        System.out.println("-------------------"+formattedDate+ ":学习内容已完成-------------------");
    }

}
