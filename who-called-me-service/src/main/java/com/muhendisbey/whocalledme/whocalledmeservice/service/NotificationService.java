package com.muhendisbey.whocalledme.whocalledmeservice.service;

import com.muhendisbey.whocalledme.whocalledmeservice.config.WebSocketEndpointConfig;
import com.muhendisbey.whocalledme.whocalledmeservice.converter.IMessageConverter;
import com.muhendisbey.whocalledme.whocalledmeservice.dto.MissedCallDTO;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService implements INotificationService
{
    private final SimpMessageSendingOperations messageSendingOperations;
    private final IMessageConverter messageConverter;

    public NotificationService(SimpMessageSendingOperations messageSendingOperations, IMessageConverter messageConverter)
    {
        this.messageSendingOperations = messageSendingOperations;
        this.messageConverter = messageConverter;
    }

    @Override
    public void sendMissedCallNotification(String caller, String user)
    {
        /* TODO: you can keep calling history in a database, it can be time series database,
            and you can search by datetime, and you can get result, count of result means  total missing call */
        var dto = new MissedCallDTO()
                .setWho(caller)
                .setWhen(LocalDateTime.now())
                .setHowMany(1);

        messageSendingOperations.convertAndSendToUser(user, WebSocketEndpointConfig.NOTIFICATION_CHANNEL,
                messageConverter.toString(dto));
    }

    @Override
    public void markAsRead()
    {

    }
}
