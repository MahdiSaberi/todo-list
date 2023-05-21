package com.data.todolist.controller;

import com.data.todolist.domain.Box;
import com.data.todolist.domain.User;
import com.data.todolist.service.BoxService;
import com.data.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/box")
public class BoardController {

    private final HttpSession httpSession;
    private final UserService userService;
    private final BoxService boxService;


    @Autowired
    public BoardController(HttpSession httpSession, UserService userService, BoxService boxService) {
        this.httpSession = httpSession;
        this.userService = userService;
        this.boxService = boxService;
    }


    User getUser() {
        return userService.findById((Long) httpSession.getAttribute("userId"));
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createBox(@RequestParam String topic) {
        try {
            Box box = new Box(topic);
            box.setUser(getUser());
            boxService.save(box);
            return ResponseEntity.ok(box);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad request.");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteBox(@RequestParam(required = false) String topic,
                                            @RequestParam(required = false) Long boxId) {
        try {
            Box box;
            if(!topic.isEmpty() || topic != null) {
                box = boxService.findByTopicAndUser_Id(topic, getUser().getId());
                if(!ObjectUtils.isEmpty(box)){
                    boxService.deleteById(box.getId());
                    return ResponseEntity.ok("Topic removed successfully");
                }
                else return ResponseEntity.badRequest().body("cannot remove this topic");
            }
            else {
                box = boxService.findById(boxId);
                if(!ObjectUtils.isEmpty(box)){
                    if(box.getUser().getId() == getUser().getId()){
                        boxService.deleteById(boxId);
                        return ResponseEntity.ok("Topic removed successfully");
                    }
                    else return ResponseEntity.badRequest().body("cannot remove this topic");
                }
                else return ResponseEntity.badRequest().body("Bad request.");
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad request.");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateBox(@RequestParam Long id,@RequestParam String topic){
        try{
            Box box = boxService.findById(id);
            if(box.getUser().getId() == getUser().getId()){
                box.setTopic(topic);
                boxService.update(box);
                return ResponseEntity.ok(box);
            }
            return ResponseEntity.ok(box);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Bad request");
        }
    }

    @GetMapping("/getAll")
    public List<Box> getBoxesByUser(){
        return boxService.findAllByUserId(getUser().getId());
    }

}
