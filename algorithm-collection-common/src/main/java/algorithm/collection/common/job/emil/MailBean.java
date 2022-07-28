package algorithm.collection.common.job.emil;

import lombok.Data;

import java.io.Serializable;

/**
 * 邮件
 *
 * @author shadow
 * @date 2022/7/28 19:30
 * @since 1.0
 */
@Data
public class MailBean implements Serializable {

    /**
     * smtp服务地址
     */
    private String smtp;

    /**
     * 端口号
     */
    private String port;

    /**
     * 邮件地址
     */
    private String address;

    /**
     * 密码
     */
    private String password;

    /**
     * 协议
     */
    private String protocol;

    private String receiver;

    /**
     * 邮件信息
     */
    private String msgContent;

    /**
     * 邮件主题
     */
    private String title;

}
