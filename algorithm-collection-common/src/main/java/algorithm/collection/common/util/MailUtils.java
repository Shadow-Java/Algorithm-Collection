package algorithm.collection.common.util;

import algorithm.collection.common.job.emil.MailBean;
import algorithm.collection.common.job.emil.User;
import lombok.SneakyThrows;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Properties;

/**
 * 邮件工具
 *
 * @author shadow
 * @date 2022/7/28 19:42
 * @since 1.0
 */
public class MailUtils {

    @SneakyThrows
    public static void  sendMail(MailBean mailBean){
        // 1. 创建一封邮件
        Properties props = new Properties();
        // 用于连接邮件服务器的参数配置（发送邮件时才需要用到）
        Session session= Session.getInstance(props);        // 根据参数配置，创建会话对象（为了发送邮件准备的）
        MimeMessage message = new MimeMessage(session);     // 创建邮件对象

        /*
         * 也可以根据已有的eml邮件文件创建 MimeMessage 对象
         * MimeMessage message = new MimeMessage(session, new FileInputStream("MyEmail.eml"));
         */

        // 2. From: 发件人
        //    其中 InternetAddress 的三个参数分别为: 邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
        //    真正要发送时, 邮箱必须是真实有效的邮箱。
        message.setFrom(new InternetAddress(mailBean.getAddress(), mailBean.getTitle(),"UTF-8"));

        for(User user : mailBean.getReceivers()){
            // 3. To: 收件人
            //message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(user.getEmail(), user.getName(), "UTF-8"));
            message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(user.getEmail(), user.getName(), "UTF-8"));
        }

        for(User user : mailBean.getCarbonCopy()){
            // 抄送
            //message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(user.getEmail(), user.getName(), "UTF-8"));
            message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress(user.getEmail(), user.getName(), "UTF-8"));
        }
        for(User user : mailBean.getBlindCarbonCopy()){
            //密送
            //message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(user.getEmail(), user.getName(), "UTF-8"));
            message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress(user.getEmail(), user.getName(), "UTF-8"));
        }

        // 4. Subject: 邮件主题
        message.setSubject(mailBean.getTitle(), "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent(mailBean.getMsgContent(), "text/html;charset=UTF-8");

        // 6. 设置显示的发件时间
        message.setSentDate(new Date());

        // 7. 保存前面的设置
        message.saveChanges();

        // 8. 将该邮件保存到本地
        OutputStream out = new FileOutputStream("MyEmail.eml");
        message.writeTo(out);
        out.flush();
        out.close();
    }

}
