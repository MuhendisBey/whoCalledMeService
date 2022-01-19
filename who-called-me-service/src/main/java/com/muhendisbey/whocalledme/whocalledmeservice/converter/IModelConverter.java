/*
 * IModelConverter.java
 Author: Onur GURSOY (onurgursoygyte@gmail.com)
 Created: 10/1/21 3:56 PM
*/
package com.muhendisbey.whocalledme.whocalledmeservice.converter;

import com.muhendisbey.whocalledme.whocalledmeservice.dto.LoginDTO;
import com.muhendisbey.whocalledme.whocalledmeservice.dto.UserDTO;
import com.muhendisbey.whocalledme.whocalledmeservice.model.LoginModel;
import com.muhendisbey.whocalledme.whocalledmeservice.model.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "ModelConverter")
public interface IModelConverter
{
    LoginModel toModel(LoginDTO dto);
    LoginDTO toDto(LoginModel model);

    UserEntity toModel(UserDTO dto);
    UserDTO toDto(UserEntity model);
}
