package com.registry.estates.repository;

import com.registry.estates.entity.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Short> {
    Owner findByEmail(String email);
}
