package com.data.todolist.controller;

import com.data.todolist.domain.Event;
import com.data.todolist.domain.User;
import com.data.todolist.service.BoxService;
import com.data.todolist.service.EventService;
import com.data.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/event")
public class EventController {

    private final HttpSession httpSession;
    private final UserService userService;
    private final EventService eventService;
    private final BoxService boxService;

    @Autowired
    public EventController(HttpSession httpSession, UserService userService, EventService eventService, BoxService boxService) {
        this.httpSession = httpSession;
        this.userService = userService;
        this.eventService = eventService;
        this.boxService = boxService;
    }

    User getUser() {
        return userService.findById((Long) httpSession.getAttribute("userId"));
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createEvent(@RequestParam String title,
                                              @RequestParam String content,
                                              @RequestParam Long boxId) {
        try {
            Event event = new Event();
            event.setUser(getUser());
            event.setTitle(title);
            event.setContent(content);
            event.setBox(boxService.findById(boxId));
            eventService.save(event);
            return ResponseEntity.ok(event);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad request.");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteEvent(@RequestParam Long id) {
        try {
            Event event = eventService.findById(id);
            if (event != null) {
                if (event.getUser().getId() == getUser().getId()) {
                    eventService.deleteById(event.getId());
                    return ResponseEntity.ok("event removed successfully");
                } else return ResponseEntity.ok("cannot remove this event.");
            }
            return ResponseEntity.badRequest().body("event not found");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad request.");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateEvent(@RequestBody Event event) {
        try {
            if (event.getId() != null) {
                if (event.getUser().getId() == getUser().getId()) {
                    eventService.update(event);
                    return ResponseEntity.ok(event);
                } else return ResponseEntity.ok("cannot edit this event");
            } else return ResponseEntity.badRequest().body("Bad request.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found");
        }
    }

    @GetMapping("/getAll")
    public List<Event> getEventsByUser() {
        return eventService.findAllByUserId(getUser().getId());
    }
}
