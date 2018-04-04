package com.liweile.news.controlller;


import com.liweile.news.handler.CmdHandler;
import com.liweile.news.model.Collect;
import com.liweile.news.model.Notification;
import com.liweile.news.service.CollectionService;
import com.liweile.news.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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
    public void addNotification(@RequestParam String username, @RequestParam String   content){
        notificationService.addNotification(new Notification(username,new Date(),content));

        CmdHandler.sendMassage(content);
    }

    @RequestMapping("/all")
    public ResponseEntity<List<Notification>> addCollect(){
        return notificationService.getNotificationList();

    }


}
