package alex.pol.controllers;

import alex.pol.domain.RegisteredUser;
import alex.pol.service.RegisteredUserService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Controller
public class SendController {

    @Autowired
    RegisteredUserService registeredUserService;

    String saturday = "Добрый день,\n" +
            "\n" +
            "Напоминаем, что Вы зарегистрированы на пробное занятие IT Climb Node.JS+React.JS, " +
            "которое состоится в субботу 25 февраля 11:00-15:00.\n" +
            "\n" +
            "- Вам нужно будет зайти в БЦ Нобель по адресу ул. Новгородская, 3Б, " +
            "не со стороны входа в  компанию Global Logic (по Новгородской), " +
            "а пройти его и повернуть за угол здания. (см. Приложение)\n" +
            "\n" +
            "- на ресепшене сказать, что на тренинг в Интетикс и подняться " +
            "на лифте на 9 этаж.\n" +
            "\n" +
            "- набрать номер: +38 (066) 924-11-75 или +38 (095) 903-10-32 и " +
            "Вас встретят и проведут внутрь.\n" +
            "\n" +
            "Администрация IT Climb";

    String sunday = "Добрый день,\n" +
            "\n" +
            "Напоминаем, что Вы зарегистрированы на пробное занятие IT Climb Node.JS+React.JS, " +
            "которое состоится в воскресенье 26 февраля 11:00-15:00.\n" +
            "\n" +
            "- Вам нужно будет зайти в БЦ Нобель по адресу ул. Новгородская, 3Б, " +
            "не со стороны входа в  компанию Global Logic (по Новгородской), " +
            "а пройти его и повернуть за угол здания. (см. Приложение)\n" +
            "\n" +
            "- на ресепшене сказать, что на тренинг в Интетикс и подняться " +
            "на лифте на 9 этаж.\n" +
            "\n" +
            "- набрать номер: +38 (066) 924-11-75 или +38 (095) 903-10-32 и " +
            "Вас встретят и проведут внутрь.\n" +
            "\n" +
            "Администрация IT Climb";

    String m = "Всем привет!\n" +
            "\n" +
            "     Тем, кто не смог быть на пробном занятии делятся на два типа: «не очень-то " +
            "и надо было» и «те, кто не смог прийти» и мы верим, что последних было большинство. Уже на первом этапе наших курсов (настройка и запуск проекта) Вы могли убедится, что IT-Climb предлагает практически полное погружение в процесс разработки - Вам дали проект на GitHub, написанный кем-то другим с кратким описанием как запустить его. У многих без танцев с бубном не обошлось даже на этом этапе – это реалии разработки. Да, курсы предполагают, что Вы имеете запас знаний по JS или переключились с другого языка. Вы можете подключится на курс и в том случае если до нас не программировали, но работать придется вдвойне чтобы наверстать. Поэтому для тех, у кого: клубы, танцы, он-лайн игры, - курс не подойдет, смеритесь, что на «расслабоне» заплатив за курс знания Вам в голову не загрузят (это не матрица) и работу Вы не найдете. Чтобы было еще интересней и мотивировало работать IT-Climb оставляет за собой право за систематическое невыполнение задач, конфликты с другими участниками курсов использовать свою систему наказаний, вплоть до увольнения с проекта.\n" +
            "Понравилось? Нет, тогда закрывай это письмо. Для тех, кто решил остаться с нами " +
            "на реальном проекте получат:\n" +
            "\n" +
            "- опыт работы в команде,\n" +
            "- знание современного стэка технологий, актуальных на данный момент. " +
            "Преимущество нашей программы обучения состоит в том, что мы рассматриваем " +
            "различные WEB технологии как взаимосвязанные элементы одного WEB приложения: " +
            "базы данных, бэкенд, фронтенд. Кроме того, люди, которые будут Вас обучать " +
            "работают на реальных проектах. Итого, на курсах Вы изучите:\n" +
            "\n" +
            "Layered architecture vs mvc architecture vs flux architecture\n" +
            "Cистемы контроля версий (VCS) Git. (GitHub vs BitBucket)\n" +
            "Системы сборки проекта на примере NodeJS, NPM, Gulp, Webpack\n" +
            "Apache vs Nginx.JWT vs Auth0\n" +
            "React компоненты и жизненный цикл\n" +
            "Redux vs Reflux\n" +
            "Promises, ES6, Babel\n" +
            "SQL vs NoSQL\n" +
            "REST API and Routes. Postman\n" +
            "Sequalize ORM, Mongoose, Contentful\n" +
            "Cloud Services: AWS, EC2, S3, Heroku\n" +
            "Stripe vs PayPal \n" +
            "+ Бонус (Лекция по SCRUM)\n" +
            "\n" +
            "Все это круто, но это теория и это лишь малая часть, - остальное практика и " +
            "только практика!\n" +
            "- приятным бонусом после курсов станет прокаченный профиль на GitHub, а уровень " +
            "прокачки зависит только от Вас.\n" +
            "\n" +
            "Записывайтесь на курс т.к. 60% наших выпускников находит работу в первый месяц " +
            "после окончания курсов!\n" +
            "\n" +
            "Остались вопросы? Звони/пиши: \n" +
            "skype bessonov.evgeniy, \n" +
            "тел. +38(066)924-11-75\n" +
            "\n" +
            "Хочешь попасть на курс? \n" +
            "https://docs.google.com/forms/d/e/1FAIpQLSfeZ_sDgQHSMhVf70dGeS_tRhFUNwFw4ulGYzzg3ahV27J33A/viewform";

    String w = "Привет, мы знаем, что ты была у нас пробном занятии, поэтому " +
            "сообщаем тебе, что у нас открылась регистрация на курс React+NodeJS \n" +
            "\n" +
            "https://docs.google.com/forms/d/e/1FAIpQLSfeZ_sDgQHSMhVf70dGeS_tRhFUNwFw4ulGYzzg3ahV27J33A/viewform \n" +
            "\n" +
            "Также мы собирали отзывы и знаем, что не всем понравился наш подход, " +
            "который называется “Накопление долга знаний”." +
            "Долг знаний - это когда Мы пытаемся сделать, а теорию читаем уже потом. Но вначале мы пробуем, " +
            "щупаем, а затем изучаем материал. " +
            "Да, такой подход в обучении является " +
            "экспериментальным, но вот только прошло пару недель после второго кемпинга " +
            "по Java и уже пятеро человек получили предложения о работе. Поэтому такой " +
            "подход результативен, а значит мы не будем его менять. \n" +
            "\n" +
            "Подробно о том что такое долг знаний можно ознакомиться здесь " +
            "https://habrahabr.ru/post/310158/\n" +
            "\n" +
            "Что касательно ребят, которые так и не смогли поднять проект или " +
            "выполнить задания -\n" +
            "свяжитесь с нашей поддержкой. Вам помогут поднять проект, а также " +
            "выполнить первое и второе задания.\n" +
            " \n" +
            "Тел: +38(066)924-11-75 \n" +
            "skype: bessonov.evgeniy \n" +
            "\n" +
            "Наш план лекций и семинаров:\n" +
            "\n" +
            "Layered architecture vs mvc architecture vs flux architecture\n" +
            "Системы контроля версий (VCS) Git. (GitHub vs BitBucket)\n" +
            "Системы сборки проекта на примере NodeJS, NPM, Gulp, Webpack\n" +
            "Apache vs Nginx.JWT vs Auth0\n" +
            "React компоненты и жизненный цикл\n" +
            "Redux vs Reflux\n" +
            "Promises, ES6, Babel\n" +
            "SQL vs NoSQL\n" +
            "REST API and Routes. Postman\n" +
            "Sequalize ORM, Mongoose, FireBase, Contentful\n" +
            "Cloud Services: AWS, EC2, S3, Heroku\n" +
            "Stripe vs PayPal \n" +
            "+  Бонус (Лекция по SCRUM)\n" +
            "\n" +
            "Также прошу тех, кто собирается записаться на курс, " +
            "не медлить: в обоих кемпингах по Java были вынуждены \n" +
            "отказывать людям после того, как группы уже были сформированы. " +
            "В работу над проектом мы берём только 10 человек. ";

    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public String sendEmail(@RequestParam(required = true) String day) throws SQLException, UnsupportedEncodingException, InterruptedException {

        String text;

        if (day.equals("saturday")){

            text = saturday;

        } else {

            if (day.equals("sunday")){

                text = sunday;

            } else{

                if (day.equals("M")) {
                    text = m;

                } else {

                    if (day.equals("W")) {
                        text = w;

                    } else {

                        text = "нет текста";

                    }

                }
            }
        }


//        String msg = URLEncoder.encode(text,"UTF-8");

        List<RegisteredUser> regUserList = registeredUserService.getAll();

        for (RegisteredUser regUser : regUserList) {
            if(!(regUser.getSendMail())) {
                Thread.sleep(1000);
                registeredUserService.sendEmail(regUser, text);
                regUser.setSendMail(true);
                registeredUserService.update(regUser);
            }
        }

        return "redirect:/home";
    }

    @RequestMapping(value = "/sendEmailWithAttachment", method = RequestMethod.POST)
    public String sendEmailWithAttachment(@RequestParam(required = true) String day) throws SQLException, UnsupportedEncodingException, InterruptedException {

        String text;

        if (day.equals("saturday")){

            text = saturday;

        } else {

            if (day.equals("sunday")){

                text = sunday;

            } else {

                text = "нет текста";

            }
        }

//        String msg = URLEncoder.encode(text,"UTF-8");

        List<RegisteredUser> regUserList = registeredUserService.getAll();

        for (RegisteredUser regUser : regUserList) {
            if(!(regUser.getSendMail())) {
                Thread.sleep(1000);
                registeredUserService.sendEmailWithAttachment(regUser, text);
                regUser.setSendMail(true);
                registeredUserService.update(regUser);
            }
        }

        return "redirect:/home";
    }

    @RequestMapping(value = "/readFile", method = RequestMethod.POST)
    public String readXlsx(@RequestParam(required = true) String sheet) throws SQLException, IOException {

        List<RegisteredUser> regUsers = registeredUserService.getAll();
        for ( RegisteredUser regUser : regUsers) {
            registeredUserService.delete(regUser);
        }

        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream("/home/agios/JavaProjects/vk-api-test111/resourse/RegisteredUsers.xlsx"));
//        String sheetsName = myExcelBook.getSheetName(sheet-1);
        XSSFSheet myExcelSheet = myExcelBook.getSheet(sheet);
        int countRows = myExcelSheet.getPhysicalNumberOfRows();

        for(int i=0; i<countRows; i++) {
            XSSFRow row = myExcelSheet.getRow(i);
            String name = row.getCell(0).getStringCellValue();
            String email = row.getCell(1).getStringCellValue();

            System.out.println(name + " " + email);

            RegisteredUser registeredUser = new RegisteredUser();
            registeredUser.setUserName(name);
            registeredUser.setEmail(email);
            registeredUserService.insert(registeredUser);

        }

        myExcelBook.close();

        return "redirect:/home";
    }
}
