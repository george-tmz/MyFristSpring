package cn.wbomb.www.controller;

import cn.wbomb.www.entity.Result;
import cn.wbomb.www.entity.User;
import cn.wbomb.www.service.UserService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.Map;

@Controller
public class AuthController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    @Inject
    public AuthController(
            UserService userService,
            AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/auth")
    @ResponseBody
    public Result auth() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User loggedInUser = userService.getUserByUsername(authentication == null ? null : authentication.getName());
        if (loggedInUser == null) {
            return new Result("ok", "用户没有登录", false);
        } else {
            return new Result("ok", "", true, loggedInUser);
        }
    }

    @PostMapping("/auth/register")
    @ResponseBody
    public Result register(@RequestBody Map<String, String> usernameAndPassword) {
        String username = usernameAndPassword.get("username");
        String password = usernameAndPassword.get("password");
        if (username == null || password == null) {
            return Result.failure("username/password == null");
        }
        if (username.length() < 1 || username.length() > 15) {
            return Result.failure("invalid username");
        }
        if (password.length() < 1 || password.length() > 15) {
            return Result.failure("invalid password");
        }
        try {
            userService.save(username, password);
            return new Result("ok", "success", false);
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            return Result.failure("username exists");
        }
    }

    @PostMapping("/auth/login")
    @ResponseBody
    public Result login(@RequestBody Map<String, String> usernameAndPassword) {
        String username = usernameAndPassword.get("username");
        String password = usernameAndPassword.get("password");
        UserDetails userDetails;
        try {
            userDetails = userService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            return Result.failure("用户不存在");
        }
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password);
        try {
            authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(token);
            return new Result("ok", "登录成功", true, userService.getUserByUsername(username));
        } catch (BadCredentialsException e) {
            return Result.failure("密码不正确");
        }
    }

    @GetMapping("/auth/logout")
    @ResponseBody
    public Result logout() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User loggedInUser = userService.getUserByUsername(userName);
        if (loggedInUser == null) {
            return Result.failure("not login");
        } else {
            SecurityContextHolder.clearContext();
            return new Result("ok", "logout success", false);
        }
    }
}
