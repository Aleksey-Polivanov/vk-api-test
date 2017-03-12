package alex.pol.service.impl;

import alex.pol.NotificationConfig;
import alex.pol.dao.RegisteredUserDao;
import alex.pol.domain.RegisteredUser;
import alex.pol.service.RegisteredUserService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

@Service
public class RegisteredUserServiceImpl extends BaseService<RegisteredUser, RegisteredUserDao> implements RegisteredUserService {

    @Override
    public void sendEmail(RegisteredUser user, String msg) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(NotificationConfig.class);
        ctx.refresh();
        JavaMailSenderImpl mailSender = ctx.getBean(JavaMailSenderImpl.class);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mailMsg = new MimeMessageHelper(mimeMessage);
        try {
            mailMsg.setFrom("it.climb.cours@gmail.com");
            mailMsg.setTo(user.getEmail());
            mailMsg.setSubject("Получи свою первую работу в IT. Приглашение на курсы IT Climb React+NodeJS.");
            mailMsg.setText(msg);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.out.println("WARNING!!!!");
            e.printStackTrace();
        }
        System.out.println("---Done---");
    }

    @Override
    public void sendEmailWithAttachment(RegisteredUser user, String msg) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(NotificationConfig.class);
        ctx.refresh();
        JavaMailSenderImpl mailSender = ctx.getBean(JavaMailSenderImpl.class);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //Pass true flag for multipart message
        MimeMessageHelper mailMsg;
        try {
            mailMsg = new MimeMessageHelper(mimeMessage, true);
            mailMsg.setFrom("it.climb.cours@gmail.com");
            mailMsg.setTo(user.getEmail());
            mailMsg.setSubject("Получи свою первую работу в IT. Приглашение на курсы IT Climb React+NodeJS.");
            mailMsg.setText(msg);
            //FileSystemResource object for Attachment
            FileSystemResource file = new FileSystemResource(new File("/home/agios/JavaProjects/vk-api-test111/resourse/intetics.png"));
            mailMsg.addAttachment("myPic.jpg", file);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.out.println("WARNING!!!!");
            e.printStackTrace();
        }
            System.out.println("---Done---");
    }

}






