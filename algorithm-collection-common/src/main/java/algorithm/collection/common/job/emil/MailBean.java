package algorithm.collection.common.job.emil;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 邮件 使用hutool工具实现邮件发送
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
     * 邮件地址,例如232@qq.com
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

    /**
     * 接收者
     */
    private List<User> receivers;

    /**
     * 抄送
     */
    private List<User> carbonCopy;

    /**
     * 抄送
     */
    private List<User> blindCarbonCopy;

    /**
     * 发送者
     */
    private User sender;

    /**
     * 邮件信息
     */
    private String msgContent;

    /**
     * 邮件主题
     */
    private String title;

}
