/*
 * CallerController.java
 Author: Onur GURSOY (onurgursoygyte@gmail.com)
*/
package com.muhendisbey.whocalledme.whocalledmeservice.controller;

import com.muhendisbey.whocalledme.whocalledmeservice.converter.IModelConverter;
import com.muhendisbey.whocalledme.whocalledmeservice.service.ICallerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Caller WebSocket Controller")
@RestController
@RequestMapping("api/v1/caller")
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
    String login()
    {
        return service.login();
    }

    @PostMapping("/call")
    @ApiOperation("Call another user over websocket")
    void call()
    {
        service.call();
    }
}
