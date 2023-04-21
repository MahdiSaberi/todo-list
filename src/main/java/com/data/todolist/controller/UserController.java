package com.data.todolist.controller;

import com.data.todolist.domain.User;
import com.data.todolist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final HttpSession session;
    private final UserService userService;

    @GetMapping("/test")
    public String test(){
        return "Test!";
    }

    @PutMapping("/update")
    public ResponseEntity<String> editProfile(@RequestBody User user){
        try{
            if(session.getAttribute("userId") == null){
                return ResponseEntity.ok("You must login first!");
            }
            user.setId((Long) session.getAttribute("userId"));
            userService.update(user);
            return ResponseEntity.ok("Your profile has been updated.");
        } catch (Exception e){
            return ResponseEntity.ok(e.getMessage());
        }
    }
}
