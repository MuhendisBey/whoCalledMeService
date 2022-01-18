/*
 * ICallerService.java
 Author: Onur GURSOY (onurgursoygyte@gmail.com)
*/
package com.muhendisbey.whocalledme.whocalledmeservice.service;

import org.springframework.stereotype.Service;

@Service
public interface ICallerService
{
    String login();
    void call();
}
