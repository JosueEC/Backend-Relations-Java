package com.example.springjpaadvance.repositorys;

import com.example.springjpaadvance.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
