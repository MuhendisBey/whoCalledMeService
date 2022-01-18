/*
 * WebSocketController.java
 Author: Onur GURSOY (onur.gursoy@siemens.com)
 Created: 1/18/22 6:26 PM
 Copyright (c) - Siemens AG 2021 - 2024. All rights reserved.
*/
package com.muhendisbey.whocalledme.whocalledmeservice.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;

import javax.websocket.OnOpen;
import javax.websocket.Session;

@Api("WebSocket Communication Channel Controller")
@Controller
public class WebSocketController
{
    @OnOpen
    public void onOpen(Session session)
    {

    }
}
