/*
 * ICallerService.java
 Author: Onur GURSOY (onurgursoygyte@gmail.com)
*/
package com.muhendisbey.whocalledme.whocalledmeservice.service;

import com.muhendisbey.whocalledme.whocalledmeservice.model.LoginModel;

public interface ICallerService
{
    LoginModel login();
    void call();
}
