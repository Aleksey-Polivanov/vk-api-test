package alex.pol.domain;

import sun.net.www.protocol.http.HttpURLConnection;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;

public class VkApi {

    private static final String AUTH_URL = "https://oauth.vk.com/authorize?" +
            "client_id={APP_ID}" +  // ID приложения
            "&scope={PERMISSIONS}" + // права доступа
            "&redirect_uri={REDIRECT_URI}" + // куда будет перенаправлен после авторизации
            "&display={DISPLAY}" +
            "&v={API_VERSION}" +
            "&response_type=token";

    private static final String API_REQUEST = "https://api.vk.com/method/{METHOD}?{PARAMS}&access_token={TOKEN}&v=5.37";

    public VkApi with(String appId, String accessToken) throws IOException {
        return new VkApi(appId, accessToken);
    }

    private final String accessToken;


    public VkApi(String appId, String accessToken) throws IOException {
        this.accessToken = accessToken;
        if (accessToken == null || accessToken.isEmpty()) {
            auth(appId);

            throw new Error("Need access token");
        }
    }

    private static void auth(String appId) throws IOException {
        String reqUrl = AUTH_URL
                .replace("{APP_ID}", appId)
                .replace("{PERMISSIONS}", "4096")
                .replace("{REDIRECT_URI}", "blank.html")
                .replace("{DISPLAY}", "page")
                .replace("{API_VERSION}", "5.21");
        try {
            Desktop.getDesktop().browse(new URL(reqUrl).toURI());
        } catch (URISyntaxException ex) {
            throw new IOException(ex);
        }
    }

    public String getHistory(String userId, int offset, int count, boolean rev) throws IOException {
        return invokeApi("messages.getHistory", Params.create()
                .add("user_id", userId)
                .add("offset", String.valueOf(offset))
                .add("count", String.valueOf(count))
                .add("rev", rev ? "1" : "0"));
    }

    public String getFriends() throws IOException {
        String nickname = "nickname";
        String domain = "domain";
        String sex = "sex";
        String country = "country";
        String city = "city";

        return invokeApi("friends.get", Params.create()
                .add("count", String.valueOf(5))
                .add("fields", nickname));
//
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String searchUsers(String groupID, String offset) throws IOException {

        if(groupID.equals("it_climb")){
            groupID = "105592803";
        }

        if(groupID.equals("JavaRush")){
            groupID = "43948962";
        }

        if(groupID.equals("Oracle")){
            groupID = "41660314";
        }

        return invokeApi("users.search", Params.create()
                .add("sort", String.valueOf(1))
                .add("count", String.valueOf(1000))
                .add("offset",offset)
                .add("city", String.valueOf(280))
                .add("country", String.valueOf(2))
//                .add("sex", String.valueOf(2))
                .add("age_from", String.valueOf(22))
                .add("age_to", String.valueOf(36))
                .add("has_photo",String.valueOf(1))
                .add("group_id", groupID));

    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String sendMessages(String userID, String userName) throws IOException {


       String msg =
               "Привет, "+userName+", <br>" +
               "<br>" +
               "Мне показалось ты интересуешься Java, поэтому решил украсть немного твоего времени и рассказать о курсе " +
               "Как пролезть в IT как Junior Java Developer. На курсе помимо теоретических занятий мы будем разрабатывать " +
               "живой проект, который ты сможешь добавить в свое резюме. Условия максимально приближены к рабочим " +
               "(онлайн и офлайн митинги, распределение задач, командная работа). <br> " +
                       "По желанию можем подтянуть твой английский, подготовить к собеседованию, "+
                       "помочь с резюме и трудоустройством. На прошлом потоке треть " +
               "наших студентов устроилась на работу еще ДО окончания курса. <br>" +
               "<br>" +
               "Наша группа: https://vk.com/java_get_first_job. <br>" +
               "<br>" +
               "P.S. а так же запишись на пробное занятие которое пройдёт 23 октября. <br>" +
                       "https://vk.com/java_get_first_job?w=wall-105592803_61.<br>" +
                       "<br>"+
               "Очень ждем тебя в нашу команду!";

                String msg2 =
                "Привет, "+userName+", <br>" +
                "<br>" +
                "Мне показалось ты интересуешься Java, поэтому решил украсть немного твоего времени и рассказать о курсе " +
                "Как пролезть в IT как Junior Java Developer. На курсе помимо теоретических занятий мы будем разрабатывать " +
                "живой проект, который ты сможешь добавить в свое резюме. Условия максимально приближены к рабочим " +
                "(онлайн и офлайн митинги, распределение задач, командная работа). <br> По желанию можем подтянуть твой " +
                "английский, подготовить к собеседованию, помочь с резюме и трудоустройством. На прошлом потоке треть " +
                "наших студентов устроилась на работу еще ДО окончания курса. <br>" +
                "<br>" +
                "Наша группа: https://vk.com/java_get_first_job. <br>" +
                "<br>" +
                "По всем вопросам обращайся сюда : <br>" +
                "Евгений <br>" +
                "skype: id-evg <br>" +
                "тел: 050 95 48 337 <br>" +
                "<br>" +
                "Или оставь свой телефон, мы перезвоним! <br>" +
                "Очень ждем тебя в нашу команду!";


                String msg1 = "Шшшш шшш.. " + "\n" + "Ра..шшш..з! Раз!" + "\n" + "приём!! как меня видно?" + "\n" +
                        "Спите спокойно это просто Test API ;)"  + "\n" +  "Конец связи!!";

                String msg5 =
                "Привет, "+userName+", <br>" +
                        "<br>" +
                        "Мне показалось ты интересуешься JavaScript разработкой, поэтому решил рассказать" +
                        " о наборе курса IT Climb React.js+Node.js. <br>" +
                        "<br>" +
                        "Мы - единственные курсы в Харькове, где помимо теоретических занятий, ты " +
                        "с командой разработаешь проект для реального заказчика, который сможешь " +
                        "добавить в свое резюме. Условия максимально приближены к рабочим (митинги, " +
                        "распределение задач, командная работа).<br>"+
                        "<br>" +
                        "По желанию можем подтянуть Твой английский, подготовить к собеседованию, помочь с резюме " +
                        "и трудоустройством. На прошлом потоке треть наших студентов устроилась на работу еще ДО " +
                        "окончания курса.<br>"+
                        "<br>" +
                        "Наша группа: https://vk.com/itclimb <br>"+
                        "<br>" +
                        "Остались сомнения?" +
                        " Запишись на"+
                        " бесплатное" +
                        " пробное занятие которое пройдёт" +
                        " 25 февраля в 11:00. <br>" +
                        "<br>" +
                        "https://goo.gl/forms/CsPnhkHy3JmK4YkA2 <br>"+
                        "<br>" +
                        "Очень ждем Тебя в нашу команду!";

                String msg4 = URLEncoder.encode(msg5,"UTF-8");
            return invokeApi("messages.send", Params.create()
                    .add("user_id", userID)
//                    .add("title", "IT-climb")
                    .add("message", msg4));
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



    private String invokeApi(String method, Params params) throws IOException {
        final String parameters = (params == null) ? "" : params.build();
        String reqUrl = API_REQUEST
                .replace("{METHOD}", method)
                .replace("{PARAMS}&", parameters)
                .replace("{TOKEN}", accessToken);

        final StringBuilder result = new StringBuilder();
//        reqUrl = URLEncoder.encode(reqUrl,"UTF-8");
        final URL url = new URL(reqUrl);
        System.out.println(url);
        try (InputStream is = url.openStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
          reader.lines().forEach(result::append);
        }


        System.out.println(result.toString());
        return result.toString();
    }

//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//    private String EncoderInvokeApi(String method, Params params) throws IOException {
//        final String parameters = (params == null) ? "" : params.build();
//        String reqUrl = API_REQUEST
//                .replace("{METHOD}", method)
//                .replace("{PARAMS}&", parameters)
//                .replace("{TOKEN}", accessToken);
//
//        final StringBuilder result = new StringBuilder();
//        reqUrl = URLEncoder.encode(reqUrl,"UTF-8");
//        final URL url = new URL(reqUrl);
//        System.out.println(url);
//        try (InputStream is = url.openStream()) {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//            reader.lines().forEach(result::append);
//        }
//
//
//        System.out.println(result.toString());
//        return result.toString();
//    }

//    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    private static class Params {

        public static Params create() {
            return new Params();
        }

        private final HashMap<String, String> params;

        private Params() {
            params = new HashMap<>();
        }

        public Params add(String key, String value) {
            params.put(key, value);
            return this;
        }

        public String build() {
            if (params.isEmpty()) return "";
            final StringBuilder out = new StringBuilder();
            params.keySet().stream().forEach(key -> {
                out.append(key).append('=').append(params.get(key)).append('&');
            });
            return out.toString();
        }
    }

}
