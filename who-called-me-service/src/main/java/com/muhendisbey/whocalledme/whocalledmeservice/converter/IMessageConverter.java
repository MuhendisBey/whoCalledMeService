/*
 * IModelConverter.java
 Author: Onur GURSOY (onurgursoygyte@gmail.com)
 Created: 10/1/21 3:56 PM
*/
package com.muhendisbey.whocalledme.whocalledmeservice.converter;

import com.muhendisbey.whocalledme.whocalledmeservice.dto.AvailableNowDTO;
import com.muhendisbey.whocalledme.whocalledmeservice.dto.MissedCallDTO;

public interface IMessageConverter
{
    String toString(MissedCallDTO dto);
    String toString(AvailableNowDTO dto);
}
