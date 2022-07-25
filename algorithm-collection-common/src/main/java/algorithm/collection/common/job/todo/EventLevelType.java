package algorithm.collection.common.job.todo;

/**
 * 时间重要级别
 *
 * @author shadow
 * @date 2022/7/23 10:47
 * @since 1.0
 */
public enum EventLevelType {

    /**
     * 紧急
     */
    EMERGENCY("EMERGENCY"),

    /**
     * 一般
     */
    GENERAL("GENERAL"),

    /**
     * 较轻
     */
    LIGHTER("LIGHTER");


    private String value;

    EventLevelType(String value) {
        this.value = value;
    }
}
