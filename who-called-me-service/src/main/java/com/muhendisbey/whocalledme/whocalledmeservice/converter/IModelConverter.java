/*
 * IModelConverter.java
 Author: Onur GURSOY (onurgursoygyte@gmail.com)
 Created: 10/1/21 3:56 PM
*/
package com.muhendisbey.whocalledme.whocalledmeservice.converter;

import com.muhendisbey.whocalledme.whocalledmeservice.dto.AvailableNowDTO;
import com.muhendisbey.whocalledme.whocalledmeservice.dto.LoginDTO;
import com.muhendisbey.whocalledme.whocalledmeservice.dto.MissedCallDTO;
import com.muhendisbey.whocalledme.whocalledmeservice.model.LoginModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "ModelConverter")
public interface IModelConverter
{
    LoginModel toModel(LoginDTO dto);
    LoginDTO toDto(LoginModel model);

    default String toString(MissedCallDTO dto)
    {
        return "messagePrefix: " +  + ' ' +
                dto.getWho() + ' ' +
                dto.getWhen() + ' ' +
                dto.getHowMany();
    }

    default String toString(AvailableNowDTO dto)
    {
        return "messagePrefix" + ' ' +
                dto.getCalledNumber() + ' ' +
                dto.getCalledDate() + ' ' +
                "messageSuffix";
    }
}
