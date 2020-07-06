package com.registry.estates.repository;

import com.registry.estates.entity.PropertyType;
import org.springframework.data.repository.CrudRepository;

public interface PropertyTypeRepository extends CrudRepository<PropertyType, Short> {

    PropertyType findByPropertyType(String propertyType);
}
