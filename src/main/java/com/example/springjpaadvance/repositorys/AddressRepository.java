package com.example.springjpaadvance.repositorys;

import com.example.springjpaadvance.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Long> {
}
