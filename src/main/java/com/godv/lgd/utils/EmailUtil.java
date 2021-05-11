package com.godv.lgd.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class EmailUtil {

    public static boolean sendEmail(String to, ByteArrayOutputStream baos, String from, String host, String authCode, String subject) {
        // 发件人电子邮箱
//        String from = "1170942621@qq.com";
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器 ->QQ 邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, authCode); //发件人邮件用户名、授权码
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));
            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: 头部头字段
            message.setSubject(subject);
            /*添加附件*/
            Multipart multipart = new MimeMultipart();
            if (baos != null) {
                MimeBodyPart fileBody = new MimeBodyPart();
                DataSource source = new ByteArrayDataSource(baos.toByteArray(), "application/msexcel");
                fileBody.setDataHandler(new DataHandler(source));
                // 中文乱码问题
                fileBody.setFileName(MimeUtility.encodeText(subject + ".xlsx"));
                multipart.addBodyPart(fileBody);
            }
            message.setContent(multipart);
            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....from runoob.com");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * Excel
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ExcelVO {
        //标题数组
        private String[] title;

        //数据实体
        private List<List> data;
    }
}
