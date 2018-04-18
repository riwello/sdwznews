package com.liweile.news.service;

import com.liweile.news.model.Notification;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NotificationService {

    ResponseEntity addNotification(Notification notification);

    ResponseEntity<List<Notification>> getNotificationList();

    ResponseEntity delete(int id);
}
