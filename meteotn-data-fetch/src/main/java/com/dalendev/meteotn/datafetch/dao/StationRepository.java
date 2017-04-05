package com.dalendev.meteotn.datafetch.dao;

import com.dalendev.meteotn.model.Station;
import org.springframework.data.repository.CrudRepository;

/**
 * @author daniele.orler
 */
public interface StationRepository extends CrudRepository<Station, Long> {
}
