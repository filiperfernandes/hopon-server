package cmu.hopon.controller;

import cmu.hopon.domain.User;
import cmu.hopon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;


@Controller
@RequestMapping("/")
class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(path = "/user/list", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody Iterable<User> list(@RequestParam String token) {
        return userService.getUsers(token);
    }

/*    @RequestMapping(value = "signUp", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody String addUser (@RequestParam Integer code,
                                            @RequestParam String username) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        return userService.signUp(username, code);
    }*/

    @RequestMapping(value = "login", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody User loginUser (@RequestParam Integer code,
                                         @RequestParam String username,
                                         @RequestParam String pubk) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        return userService.login(username, code, pubk);
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody String logoutUser (@RequestParam String token) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        return userService.logout(token);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody User getUser (@RequestParam String username) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        return userService.getUser(username);
    }

    @RequestMapping(value = "updateScore", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody String updateScore (@RequestParam String token,
                                         @RequestParam int ans, @RequestParam int right) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        return userService.updateScore(token, ans, right);
    }

    @RequestMapping(value = "signUp", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody String addUser (@RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        return userService.signUp(user);
    }

    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody String updateScore (@RequestBody User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/getPubKey", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody String getPubk (@RequestParam String username) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        return userService.getPubk(username);
    }
}
