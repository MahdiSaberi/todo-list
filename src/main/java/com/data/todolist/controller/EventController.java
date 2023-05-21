package com.data.todolist.controller;

import com.data.todolist.domain.Event;
import com.data.todolist.domain.User;
import com.data.todolist.service.EventService;
import com.data.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/event")
public class EventController {

    private final HttpSession httpSession;
    private final UserService userService;
    private final EventService eventService;

    @Autowired
    public EventController(HttpSession httpSession, UserService userService, EventService eventService) {
        this.httpSession = httpSession;
        this.userService = userService;
        this.eventService = eventService;
    }

    User getUser() {
        return userService.findById((Long) httpSession.getAttribute("userId"));
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createEvent(@RequestBody Event event) {
        try {
            event.setUser(getUser());
            eventService.save(event);
            return ResponseEntity.ok(event);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad request.");
        }
    }
}
