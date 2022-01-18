/*
 * MissedCallDTO.java
 Author: Onur GURSOY (onurgursoygyte@gmail.com)
*/
package com.muhendisbey.whocalledme.whocalledmeservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MissedCallDTO
{
    private String who;
    private String when;
    private String howMany;
}
