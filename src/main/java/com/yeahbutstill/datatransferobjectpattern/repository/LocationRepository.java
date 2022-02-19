package com.yeahbutstill.datatransferobjectpattern.repository;

import com.yeahbutstill.datatransferobjectpattern.domain.dao.LocationDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<LocationDAO, Long> {
}
