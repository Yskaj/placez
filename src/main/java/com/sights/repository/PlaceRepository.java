package com.sights.repository;

import com.sights.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place,Long> {
    Place findFirstByName(String name);
}
