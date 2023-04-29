package com.example.springjpaadvance.repositorys;

import com.example.springjpaadvance.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {
}
