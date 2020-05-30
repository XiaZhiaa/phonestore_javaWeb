package cn.mrzhang.phonestore.util;

import cn.mrzhang.phonestore.entity.User;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 邮箱工具类
 * @date 2020.05.30
 * @author mrzhang
 */
public class MailUtil extends Thread{
    private User user;

    public MailUtil(User user) {
        this.user = user;
    }

    //通过线程发送邮件
    public void run(){
        InputStream is = MailUtil.class.getClassLoader().getResourceAsStream("mail.properties");
        Properties p = new Properties();
        try {
            p.load(is);

            Session session = Session.getInstance(p);
            // 获取MimeMessage对象，通过该对象设置邮件内容
            MimeMessage message = new MimeMessage(session);

            String mailAddress = p.getProperty("mailAddress");


//            String mailContent = p.getProperty("mailContent");
            String username = p.getProperty("username");
            String password = p.getProperty("password");
            // 设置发件邮箱地址
            message.setFrom(new InternetAddress(mailAddress));
            // 设置发送方式  与  客户邮箱地址
            message.setRecipients(Message.RecipientType.TO,user.getEmail());
            // 邮件主题
            message.setSubject("一封来自爱尚手机商城的邮件");
            // 邮件内容
            message.setContent("<a href='http://localhost:8080/phonestore/userServlet?method=userActive&code="+user.getCode()+"'>点我去激活账号,不必回复我了</a>","text/html;charset=utf-8");
            // 设置邮箱用户名和密码
            Transport transport = session.getTransport();
            transport.connect(username,password);
            // 发送，传入信息与收件人
            transport.sendMessage(message,message.getAllRecipients());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
//        User user = new User();
//        user.setEmail("1412545222@qq.com");
//        MailUtil mailUtil = new MailUtil(user);
//        mailUtil.start();
    }
}
