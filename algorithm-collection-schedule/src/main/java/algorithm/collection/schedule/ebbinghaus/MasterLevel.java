package algorithm.collection.schedule.ebbinghaus;

public enum MasterLevel {
    /**
     * 未开始
     */
    NOT_STARTED,
    /**
     * 完全未掌握
     */
    NONE,
    /**
     * 有一点想法
     */
    SOME_IMPRESSION,
    /**
     * 在计划中
     */
    IN_PROGRESS,
    /**
     * 半掌握
     */
    PARTIALLY_MASTERED,
    /**
     * 完全掌握
     */
    FULLY_MASTERED;
}
