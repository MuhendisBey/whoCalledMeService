package com.muhendisbey.whocalledme.whocalledmeservice.service;

public interface INotificationService
{
    void markAsRead();
    void sendMissedCallNotification(String caller, String user);
}
