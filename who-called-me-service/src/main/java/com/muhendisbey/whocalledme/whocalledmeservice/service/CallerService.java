/*
 * CallerService.java
 Author: Onur GURSOY (onurgursoygyte@gmail.com)
*/
package com.muhendisbey.whocalledme.whocalledmeservice.service;

import org.springframework.stereotype.Service;

@Service
public class CallerService implements ICallerService
{
    @Override
    public String login()
    {
        return null;
    }

    /* NOTE: by default, this sends notification to user X */
    @Override
    public void call()
    {

    }
}
