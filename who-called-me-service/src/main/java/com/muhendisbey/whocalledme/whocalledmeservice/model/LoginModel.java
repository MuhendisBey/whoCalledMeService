package com.muhendisbey.whocalledme.whocalledmeservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class LoginModel
{
    private String endpoint;
    private String notificationChannel;
}
