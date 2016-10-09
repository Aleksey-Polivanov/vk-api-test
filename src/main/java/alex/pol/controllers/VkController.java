package alex.pol.controllers;

import alex.pol.domain.UserVK;
import alex.pol.domain.VkApi;
import alex.pol.service.UserVKService;
import org.apache.commons.httpclient.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class VkController {

    @Autowired
    UserVKService userVKService;

    VkApi vkApi;
//
//    @RequestMapping(value = "/getToken", method = RequestMethod.GET)
//    public String getToken() throws IOException, URISyntaxException {
//        HttpClient hc =
//        String reqUrl = "https://oauth.vk.com/authorize?" +
//            "client_id=5599674" +
//            "&scope=messages" +
//            "&redirect_uri=https://oauth.vk.com/blank.html" +
//            "&display=page" +
//            "&v=5.21" +
//            "&response_type=token";
//
//        Desktop.getDesktop().browse(new URL(reqUrl).toURI());
//
//        return "/redirect:/";
//    }


    @RequestMapping(value = "/authorization", method = RequestMethod.POST)
    public ModelAndView auth(@RequestParam(required = false) String AppID,
                             @RequestParam(required = false) String accessToken) throws IOException {
        //String AppID = "5599674";
        vkApi = new VkApi(AppID, accessToken);
        ModelAndView modelAndView = new ModelAndView("methods");
        return modelAndView;
    }


    @RequestMapping(value = "/getMyFriends", method = RequestMethod.POST)
    public ModelAndView getMyFriend() throws IOException, SQLException {

        String str = vkApi.getFriends();

        System.out.println(str);

        String regex = "\\{([id]+\\W\\d+),(first_name\\W[A-zА-я0-9]+),(last_name\\W[A-zА-я0-9]+),(nickname\\W[.[^,]]*),(online\\W\\d)\\}";
//        String regex = "\\{([id]+\\W\\d+),(first_name\\W[A-zА-я0-9]+),(last_name\\W[A-zА-я0-9]+)\\}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str.replace("\"", ""));

        addNewUsers(m);

        List<UserVK> usersVK = userVKService.getAll();

        ModelAndView modelAndView = new ModelAndView("friends");
        modelAndView.addObject("usersVK", usersVK);
        return modelAndView;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    @RequestMapping(value = "/searchUsers", method = RequestMethod.POST)
    public ModelAndView searchUsers(@RequestParam(required = true) String groupID, @RequestParam(required = true) String offset ) throws IOException, SQLException {

        String str = vkApi.searchUsers(groupID, offset);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(str.replace("\"", ""));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String regex = "\\{([id]+\\W\\d+),(first_name\\W[A-zА-я0-9]+),(last_name\\W[A-zА-я0-9]+)\\}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str.replace("\"", ""));

        addNewUsers(m);

        List<UserVK> usersVK = userVKService.getAll();

        ModelAndView modelAndView = new ModelAndView("friends");
        modelAndView.addObject("usersVK", usersVK);
        return modelAndView;
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public String sendMessage() throws SQLException, IOException {

        List<UserVK> usersVK = userVKService.getAll();
        int count = 0;

            for (UserVK userVK : usersVK) {

            System.out.println(userVK.toString());

                if(!(userVK.getSendMail())) {

                    String str = vkApi.sendMessages(userVK.getVkID(), userVK.getFirstName()).replace("\"", "");

                        userVK.setSendMail(true);
                    userVKService.update(userVK);
                        System.out.println(userVK.getFirstName() + " " + userVK.getSecondName() + " сообщение отправленно");
                    System.out.println(userVK.getSendMail());
                    count++;
                        if(count==20){break;}

                }
            }


        System.out.println(count);
        return "redirect:/home";
    }


    @RequestMapping(value = "/back", method = RequestMethod.POST)
    public ModelAndView back() throws IOException {

        ModelAndView modelAndView = new ModelAndView("methods");
        return modelAndView;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



//    public void addNewUsers(Matcher m) throws SQLException {
//
//    while (m.find()) {
//
//        String vkID[] = m.group(1).split(":");
//        String firstName[] = m.group(2).split(":");
//        String lastName[] = m.group(3).split(":");
//
//        UserVK userVk = new UserVK(vkID[1], firstName[1], lastName[1]);
//        System.out.println(userVk.toString());
//        userVKService.insert(userVk);
//
//    }

    public void addNewUsers(Matcher m) throws SQLException {

        int countadd = 0;

        while (m.find()) {

            String vkID[] = m.group(1).split(":");
            String firstName[] = m.group(2).split(":");
            String lastName[] = m.group(3).split(":");

            List<UserVK> usersVK = userVKService.getAll();

            if (usersVK.size() == 0){
                UserVK userVk = new UserVK(vkID[1], firstName[1], lastName[1]);
                System.out.println(userVk.toString());
                userVKService.insert(userVk);
            } else{

                int count = 0;
                for (UserVK userVK : usersVK) {
                    if(userVK.getVkID().equals(vkID[1])){
                        count++;
                        break;
                    }
                }
                if(count==0){
                    UserVK userVk = new UserVK(vkID[1], firstName[1], lastName[1]);
                    System.out.println(userVk.toString());
                    userVKService.insert(userVk);
                countadd++;
                }
            }




        }

        System.out.println("Было добавленно " + countadd + " юзеров!");

}


}