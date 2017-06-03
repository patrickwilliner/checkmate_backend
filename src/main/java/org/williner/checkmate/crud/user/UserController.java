package org.williner.checkmate.crud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.williner.checkmate.core.SessionService;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/api/users", method = RequestMethod.GET)
    public String getUsers() {
        return "test_xxx";
    }

    @RequestMapping(path = "/api/users", method = RequestMethod.POST)
    public UserDO createUser(@RequestBody UserDO user) {
        return userService.createUser(user);
    }

    @RequestMapping(path = "/api/users/{id}", method = RequestMethod.GET)
    public UserDO getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
