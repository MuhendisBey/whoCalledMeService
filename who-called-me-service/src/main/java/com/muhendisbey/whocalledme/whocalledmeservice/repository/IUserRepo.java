/*
 * IUserRepo.java
 Author: Onur GURSOY (onurgursoygyte@gmail.com)
 Created: 10/1/21 3:15 PM
*/
package com.muhendisbey.whocalledme.whocalledmeservice.repository;

import com.muhendisbey.whocalledme.whocalledmeservice.model.UserEntity;

/*
* imagine that: you can extend this repo from extends PagingAndSortingRepository<CustomerEntity, Long>
currently we get data as a mock for PoC
*/
public interface IUserRepo
{
    UserEntity findById(long id);
}
