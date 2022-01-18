/*
 * CallerService.java
 Author: Onur GURSOY (onurgursoygyte@gmail.com)
*/
package com.muhendisbey.whocalledme.whocalledmeservice.service;

import com.muhendisbey.whocalledme.whocalledmeservice.config.WebSocketEndpointConfig;
import com.muhendisbey.whocalledme.whocalledmeservice.model.LoginModel;
import org.springframework.stereotype.Service;

@Service
public class CallerService implements ICallerService
{
    /* NOTE:  Think about tht, service couldn't depend on another service */
    private final INotificationService notificationService;

    public CallerService(INotificationService notificationService)
    {
        this.notificationService = notificationService;
    }

    @Override
    public LoginModel login()
    {
        return new LoginModel()
                .setEndpoint(WebSocketEndpointConfig.STOMP_ENDPOINT)
                .setNotificationChannel(WebSocketEndpointConfig.NOTIFICATION_CHANNEL);
    }

    /* NOTE: by default, this sends notification to user X */
    @Override
    public void call()
    {
        notificationService.sendMissedCallNotification();
    }
}
