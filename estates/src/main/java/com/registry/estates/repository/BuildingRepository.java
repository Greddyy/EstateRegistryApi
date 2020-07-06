package com.registry.estates.repository;

import com.registry.estates.entity.Building;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuildingRepository extends CrudRepository<Building, Short> {

    List<Building> findByOwnerId(short id);

}
