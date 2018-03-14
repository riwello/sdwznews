package com.liweile.news.service;

import com.liweile.news.model.Notification;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NotificationService {

    void addNotification(Notification notification);

    ResponseEntity<List<Notification>> getNotificationList();

}
