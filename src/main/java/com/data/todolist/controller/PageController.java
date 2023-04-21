package com.data.todolist.controller;

import com.data.todolist.domain.User;
import com.data.todolist.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpSession;

@RestController
public class PageController {

    UserService userService;
    HttpSession session;

    @GetMapping("/login")
    public ResponseEntity<HttpStatus> login(@RequestParam String username, @RequestParam String password) {

        try{
            User user = userService.findByUsernameAndPassword(username,password).block();
            if (user != null) {
                session.setAttribute("userId",user.getId());
                return ResponseEntity.ok(HttpStatus.OK);
            }
        }catch (Exception e){
            return ResponseEntity.ok(HttpStatus.NOT_FOUND);
        }
        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
        try{
            userService.save(user.getUsername(), user.getPassword());
            return ResponseEntity.ok("You registered successfully.");
        }catch (Exception e){
           return ResponseEntity.ok("This username is not available.");
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(){
        session.setAttribute("userId",null);
        return ResponseEntity.ok("You logged out!");
    }
}
