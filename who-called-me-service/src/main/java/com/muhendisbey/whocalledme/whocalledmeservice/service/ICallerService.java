/*
 * ICallerService.java
 Author: Onur GURSOY (onurgursoygyte@gmail.com)
*/
package com.muhendisbey.whocalledme.whocalledmeservice.service;

import com.muhendisbey.whocalledme.whocalledmeservice.dto.UserDTO;
import com.muhendisbey.whocalledme.whocalledmeservice.model.LoginModel;

public interface ICallerService
{
    LoginModel login(UserDTO dto);
    void call(String caller, String user);
}
