package algorithm.collection.common.job.emil;

import lombok.Data;

/**
 * 用户
 *
 * @author shadow
 * @date 2022/8/10 17:31
 * @since 1.0
 */
@Data
public class User {


    private String id;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮件地址
     */
    private String email;

}
