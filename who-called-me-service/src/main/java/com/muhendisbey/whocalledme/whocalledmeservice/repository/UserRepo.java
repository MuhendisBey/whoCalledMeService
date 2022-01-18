/*
 * UserRepo.java
 Author: Onur GURSOY (onurgursoygyte@gmail.com)
 Created: 10/1/21 3:21 PM
*/
package com.muhendisbey.whocalledme.whocalledmeservice.repository;

import com.muhendisbey.whocalledme.whocalledmeservice.model.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo implements IUserRepo
{
    @Override
    public UserEntity findById(long id)
    {
        return new UserEntity()
                .setId(id)
                .setName("Onur")
                .setSurname("GURSOY")
                .setMobile("+905..XXXyyZZ");
    }
}
