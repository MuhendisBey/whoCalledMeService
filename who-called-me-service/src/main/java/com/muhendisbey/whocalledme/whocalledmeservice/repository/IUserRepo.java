/*
 * IUserRepo.java
 Author: Onur GURSOY (onurgursoygyte@gmail.com)
 Created: 10/1/21 3:15 PM
*/
package com.muhendisbey.whocalledme.whocalledmeservice.repository;

import com.muhendisbey.whocalledme.whocalledmeservice.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepo extends JpaRepository<UserEntity, Long>
{
    Optional<UserEntity> findByName(String name);
}
