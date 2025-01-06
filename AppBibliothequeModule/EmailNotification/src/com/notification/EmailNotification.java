package com.notification;

import com.service.NotificationService;

public class EmailNotification {
    private NotificationService service;

    public EmailNotification() {
        service = new NotificationService();
    }

    public void notify(String title, String message) {
        System.out.println("Email Notification");
        service.notify(title, message);
    }
}