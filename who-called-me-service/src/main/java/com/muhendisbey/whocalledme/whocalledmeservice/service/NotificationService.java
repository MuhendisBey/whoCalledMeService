package com.muhendisbey.whocalledme.whocalledmeservice.service;

import com.muhendisbey.whocalledme.whocalledmeservice.config.WebSocketEndpointConfig;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements INotificationService
{
    private final SimpMessageSendingOperations messageSendingOperations;

    public NotificationService(SimpMessageSendingOperations messageSendingOperations)
    {
        this.messageSendingOperations = messageSendingOperations;
    }

    @Override
    public void sendMissedCallNotification()
    {
        messageSendingOperations.convertAndSendToUser("user", WebSocketEndpointConfig.NOTIFICATION_CHANNEL,
                "meesage");
    }

    @Override
    public void markAsRead()
    {

    }
}
