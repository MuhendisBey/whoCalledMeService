/*
 * NotificationController.java
 Author: Onur GURSOY (onur.gursoy@siemens.com)
 Created: 1/18/22 4:36 PM
 Copyright (c) - Siemens AG 2021 - 2024. All rights reserved.
*/
package com.muhendisbey.whocalledme.whocalledmeservice.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("Caller WebSocket Controller")
@RestController
@RequestMapping("api/v1/notification-center")
public class NotificationController
{
    @PostMapping("/send-read-report")
    public void sendReadReport(@RequestParam int id)
    {

    }
}
