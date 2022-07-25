package Intermittent.lying.continuous.progress.job.todo;

/**
 * 通知方式
 *
 * @author shadow
 * @date 2022/7/23 10:56
 * @since 1.0
 */
public enum NoticeMode {

    PHONE("PHONE"),
    EMAIL("EMAIL"),
    SMS("SMS");



    private String value;

    NoticeMode(String value) {
        this.value = value;
    }
}
