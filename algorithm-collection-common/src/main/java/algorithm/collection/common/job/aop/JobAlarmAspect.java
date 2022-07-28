package algorithm.collection.common.job.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 任务切面告警
 *
 * @author shadow
 * @date 2022/7/23 11:23
 * @since 1.0
 */

@Slf4j
public class JobAlarmAspect {

    @AfterReturning(pointcut = "algorithm.collection.common.job.todo.ToDoEvent")
    public void doAfter(JoinPoint point){

    }

    @Pointcut("@annotation(void)")
    public void trigger(){

    }

}
