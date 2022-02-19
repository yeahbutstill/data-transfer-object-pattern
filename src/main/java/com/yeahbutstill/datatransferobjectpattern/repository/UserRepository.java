package com.yeahbutstill.datatransferobjectpattern.repository;

import com.yeahbutstill.datatransferobjectpattern.domain.dao.UserDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDAO, Long> {
}
