/*
 * CallerService.java
 Author: Onur GURSOY (onurgursoygyte@gmail.com)
*/
package com.muhendisbey.whocalledme.whocalledmeservice.service;

import com.muhendisbey.whocalledme.whocalledmeservice.config.WebSocketEndpointConfig;
import com.muhendisbey.whocalledme.whocalledmeservice.converter.IModelConverter;
import com.muhendisbey.whocalledme.whocalledmeservice.dto.UserDTO;
import com.muhendisbey.whocalledme.whocalledmeservice.model.LoginModel;
import com.muhendisbey.whocalledme.whocalledmeservice.repository.IUserRepo;
import org.springframework.stereotype.Service;

@Service
public class CallerService implements ICallerService
{
    private final IUserRepo userRepo;
    /* NOTE:  Think about tht, service couldn't depend on another service */
    private final INotificationService notificationService;
    private final IModelConverter modelConverter;

    public CallerService(IUserRepo userRepo, INotificationService notificationService, IModelConverter modelConverter)
    {
        this.userRepo = userRepo;
        this.notificationService = notificationService;
        this.modelConverter = modelConverter;
    }

    @Override
    public LoginModel login(UserDTO dto)
    {
        if(userRepo.findByName(dto.getName()).isEmpty())
        {
            userRepo.save(modelConverter.toModel(dto));
        }

        return new LoginModel()
                .setEndpoint(WebSocketEndpointConfig.STOMP_ENDPOINT)
                .setNotificationChannel(WebSocketEndpointConfig.NOTIFICATION_CHANNEL);
    }

    /* NOTE: by default, this sends notification to user X */
    @Override
    public void call(String caller, String user)
    {
        var entity = userRepo.findByName(caller);
        if(entity.isEmpty())
        {
            /* TODO: You used should own exception and controller advice*/
            throw new InternalError("User(" + caller +") Not Found");
        }

        notificationService.sendMissedCallNotification(entity.get().getMobile(), user);
    }
}
