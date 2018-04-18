package com.liweile.news.controlller;


import com.liweile.news.handler.CmdHandler;
import com.liweile.news.model.Notification;
import com.liweile.news.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/notify")
public class NotificationController {


    @Autowired
    NotificationService notificationService;


    @RequestMapping("/add")
    public ResponseEntity addNotification(@RequestParam String username, @RequestParam String content) {
        CmdHandler.sendMassage(content);
        return notificationService.addNotification(new Notification(username, new Date(), content));


    }

    @RequestMapping("/all")
    public ResponseEntity<List<Notification>> addCollect() {
        return notificationService.getNotificationList();

    }
    @RequestMapping("/delete")
    public ResponseEntity deleteNotify(@RequestParam int id){
        return notificationService.delete(id);
    }

}
