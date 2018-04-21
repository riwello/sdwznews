package com.liweile.news.controlller;


import com.liweile.news.handler.CmdHandler;
import com.liweile.news.model.Notification;
import com.liweile.news.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/notify")
public class NotificationController {


    @Autowired
    NotificationService notificationService;


    @RequestMapping("/add")
    public ResponseEntity addNotification(@RequestParam String username, @RequestParam String content) {
        Notification notification = new Notification(username, new Date(), content);
        HashMap<String , String> map = new HashMap<>();
        map.put("username",username);
        map.put("content",content);
        JSONObject jsonObject = new JSONObject(map);
        CmdHandler.sendMassage(jsonObject.toString());
        return notificationService.addNotification(notification);


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
