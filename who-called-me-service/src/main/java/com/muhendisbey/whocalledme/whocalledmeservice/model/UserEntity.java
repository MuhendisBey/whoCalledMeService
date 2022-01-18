/*
 * CustomerEntity.java
 Author: Onur GURSOY (onurgursoygyte@gmail.com)
 Created: 10/1/21 3:03 PM
 Copyright (c) - Siemens AG 2021 - 2024. All rights reserved.
*/
package com.muhendisbey.whocalledme.whocalledmeservice.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserEntity
{
    private long id;
    private String name;
    private String surname;
    private String mobile;
    /* There can be some statistics model such as lastlogin attempt, last called number and so on.
    and this service can pull that information from another service.
     */
}
