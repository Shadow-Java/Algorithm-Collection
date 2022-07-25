package Intermittent.lying.continuous.progress.job.todo;

/**
 * TODO注解
 * <ul>
 *     <li>添加todo注解后通过短信或邮件通知</li>
 *     <li>添加todo注解后加入github issue,解决后关闭</li>
 * </ul>
 *
 *
 * @author shadow
 * @date 2022-07-23 10:20
 * @since 1.0
 */
public @interface ToDoEvent {

    /**
     * 默认生成当前时间
     *
     * @return
     */
    long startTime() default 0;

    /**
     * 事件deadline,通过邮件或短信通知
     *
     * @return
     */
    long deadLine();

    /**
     * 重要程度
     */
    EventLevelType importantLevel();

    /**
     * 通知方式
     */
    NoticeMode noticeMode();

    /**
     * 是否生成issue
     */
    boolean generateIssue() default false;

}
