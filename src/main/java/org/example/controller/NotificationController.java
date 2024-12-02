package org.example.controller;

import org.example.model.Notification;
import org.example.service.NotificationCreateService;
import org.example.service.NotificationDeleteService;
import org.example.service.NotificationUpdateService;
import org.example.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "http://localhost:63342")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private NotificationCreateService notificationCreateService;

    @Autowired
    private NotificationUpdateService notificationUpdateService;

    @Autowired
    private NotificationDeleteService notificationDeleteService;

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotification(@PathVariable Long id) {
        Notification notification = notificationService.getNotificationById(id);
        return notification != null ? ResponseEntity.ok(notification) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationCreateService.createNotification(notification);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable Long id, @RequestBody Notification notification) {
        Notification updatedNotification = notificationUpdateService.updateNotification(id, notification);
        return ResponseEntity.ok(updatedNotification);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationDeleteService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }
}