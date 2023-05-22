package com.data.todolist.controller;

import com.data.todolist.domain.User;
import com.data.todolist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.event.KeyEvent;

@RestController
@RequestMapping("/page")
@RequiredArgsConstructor
public class PageController {

    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {

        try{
            User user = userService.findByUsernameAndPassword(username,password);
            if (user != null) {
                session.setAttribute("userId",user.getId());
                return ResponseEntity.ok("login was successfully.");
            }
        }catch (Exception e){
            return ResponseEntity.ok(HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
        try{
            userService.save(user.getUsername(), user.getPassword());
            return ResponseEntity.ok("You registered successfully.");
        }catch (Exception e){
           return ResponseEntity.ok(e.getMessage());
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(){
        session.setAttribute("userId",null);
        return ResponseEntity.ok("You logged out!");
    }

    @GetMapping("/exit")
    public void exit() throws AWTException {
        System.setProperty("java.awt.headless", "false");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);
    }
}
