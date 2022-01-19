/*
 * CallerController.java
 Author: Onur GURSOY (onurgursoygyte@gmail.com)
*/
package com.muhendisbey.whocalledme.whocalledmeservice.controller;

import com.muhendisbey.whocalledme.whocalledmeservice.converter.IModelConverter;
import com.muhendisbey.whocalledme.whocalledmeservice.dto.LoginDTO;
import com.muhendisbey.whocalledme.whocalledmeservice.dto.UserDTO;
import com.muhendisbey.whocalledme.whocalledmeservice.service.ICallerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Api("Caller WebSocket Controller")
@RestController
@RequestMapping("api/v1/caller")
@Slf4j
public class CallerController
{
    private final ICallerService service;
    private final IModelConverter modelConverter;

    public CallerController(ICallerService service, IModelConverter modelConverter)
    {
        this.service = service;
        this.modelConverter = modelConverter;
    }

    @PostMapping("/login")
    @ApiOperation("User can login and get websocket handler")
    LoginDTO login(@RequestParam String mobile, Principal principal)
    {
        log.info(String.valueOf(principal));
        return modelConverter.toDto(service.login(new UserDTO().
                setName(principal.getName())
                .setMobile(mobile)));
    }

    @PostMapping("/call")
    @ApiOperation("Call another user over websocket")
    void call(@RequestParam String user, Principal principal)
    {
        log.info("User: " + principal.getName() + "is trying to call user: " + user);
        service.call(principal.getName(), user);
    }
}
