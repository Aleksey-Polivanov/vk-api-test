package alex.pol.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private StringBuilder add = null;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView home() {

        ModelAndView modelAndView = new ModelAndView("home_page");
//        if(access_token != null){
//            System.out.println(access_token);
//            modelAndView.addObject("token",access_token);
//        }
        return modelAndView;
    }

}






//
//    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
//    public String addNewUser(@ModelAttribute("dto") RegAndLogDto dto,
//                             HttpServletRequest request) throws SQLException, MessagingException {
//
//        HttpSession session = request.getSession();
//
////
////        if (user.getEmail().equals("admin@admin.com")) {
////            session.setAttribute("admin", user);
////            session.setAttribute("email", user.getEmail());
////        } else {
//            dto.setRole(Role.USER);
//            User user = User.newBuilder().setEmail(dto.getEmail()).setPassword(dto.getPassword()).setRole(dto.getRole()).build();
//            session.setAttribute("user", user);
//            userService.insert(user);
//            UserData userData = UserData.newBuilder().setUser(user).setFirstName(dto.getFirstName()).setSecondName(dto.getSecondName()).build();
//            userDataService.insert(userData);
//            add = new StringBuilder("add");
//
//
////        }
//
//        return "redirect:/";
//    }
//
//    @PostConstruct
//    public void addNewAdmin() throws SQLException {
//        if (userService.getByEmail("admin@admin.com") == null) {
//            RegAndLogDto dto = new RegAndLogDto();
//            dto.setEmail("admin@admin.com");
//            dto.setPassword("12345678");
//            dto.setRole(Role.ADMIN);
//            User admin = User.newBuilder().setEmail(dto.getEmail()).setPassword(dto.getPassword()).setRole(dto.getRole()).build();
//            userService.insert(admin);
//            UserData userData = UserData.newBuilder().setUser(admin).setFirstName("Admin").setSecondName("Admin").build();
//            userDataService.insert(userData);
//            add = new StringBuilder("add");
//
//        }
//
////        HttpServletRequest request = ServletActionContext.getRequest();
////        HttpSession session = request.getSession();
////        session.setAttribute("admin",admin);
//
//
////        HomeController.this.addNewUser(regAndLogDto,session);
//        //userValid.validate(user, result);
////        if(result.hasErrors()){
////            return "users/registration";
////        }else{
////        HttpSession session = request.getSession();
////        User admin = User.newBuilder().setEmail("admin@admin.com").setPassword("123456").build();
////        session.setAttribute("admin", admin);
////        userService.insert(admin);
////        UserData userData = UserData.newBuilder().setUser(admin).build();
////        userDataService.insert(userData);
////        add = new StringBuilder("add");
////        }
////        return true;
//    }
//
//
//    @RequestMapping(value = "/success", method = RequestMethod.GET)
//    public ModelAndView showSuccess() {
//        ModelAndView modelAndView = new ModelAndView("/utils/success");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/accountLogout", method = RequestMethod.GET)
//    public String logOut() {
//        add = new StringBuilder("logout");
//        return "redirect:/";
//    }
//
//    @Autowired
//    private MessageSource messageSource;
//
//    @RequestMapping("/msg")
//    public String msg(@RequestHeader("Accept-Language") Locale locale) {
//        return messageSource.getMessage("msg", null, locale);
//    }
//
//
////    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
////    public String updateOne(@RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest request) throws SQLException {
////        HttpSession session = request.getSession();
////        User user = userService.getByEmail(email);
////        if(user!=null && user.getPassword().equals(password/*Integer.toString(password.hashCode())*/)) {
////            session.setAttribute("user", user);
////            return "redirect:/";
////        }else {
////            add = new StringBuilder("errorLogin");
////            return "redirect:/";
////        }
////    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public ModelAndView getLoginPage() {
////        log.debug("Getting login page, error={}", error);
//        return new ModelAndView("login");
//    }
//
//
//    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
//    public String updateOne(@RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest request) throws SQLException {
//        HttpSession session = request.getSession();
//        User user = userService.getByEmail(email);
//        if (user != null && user.getPassword().equals(password/*Integer.toString(password.hashCode())*/)) {
////                session.setAttribute("user", user);
////                return "redirect:/";
////            }else return "redirect:/loginProblems";
//            if (user.getEmail().equals("admin@admin.com")) {
//                User admin = userService.getByEmail(email);
//                session.setAttribute("admin", admin);
//                session.setAttribute("email", user.getEmail());
//                return "redirect:/";
//
//            } else if ((!(user.getEmail().equals("admin@admin.com")) && (user.getEmail() != null))) {
//                session.setAttribute("user", user);
//                return "redirect:/";
//
//            }
//        }
//        add = new StringBuilder("errorLogin");
//        return "redirect:/";
//
//    }
//
//
//
//
//}
//
