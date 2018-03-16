package cmu.hopon.controller;

import cmu.hopon.domain.User;
import cmu.hopon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(path = "/user/list", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    Iterable<User> list() {
        return userService.getUsers();
    }

    @RequestMapping(value = "signUp", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody String addUser (@RequestParam Integer code,
                                            @RequestParam String username) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User user = new User();
        user.setCode(code);
        user.setUserName(username);
        userService.signUp(user);
        return "Saved";
    }
}
