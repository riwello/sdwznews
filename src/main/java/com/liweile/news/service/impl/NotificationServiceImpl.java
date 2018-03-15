package com.liweile.news.service.impl;

import com.liweile.news.mapper.NotificationMapper;
import com.liweile.news.model.Notification;
import com.liweile.news.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationMapper mapper;

    @Override
    public void addNotification(Notification notification) {

        mapper.insert(notification);
    }

    @Override
    public ResponseEntity<List<Notification>> getNotificationList() {
        List<Notification> notifications = mapper.selectAll();
        return new ResponseEntity(notifications, HttpStatus.OK);
    }
}