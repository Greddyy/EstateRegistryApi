package com.registry.estates.services;


import com.registry.estates.entity.Building;
import com.registry.estates.entity.Owner;
import com.registry.estates.entity.PropertyType;
import com.registry.estates.repository.BuildingRepository;
import com.registry.estates.repository.OwnerRepository;
import com.registry.estates.repository.PropertyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstateService {

    private BuildingRepository buildingRepository;
    private OwnerRepository ownerRepository;
    private PropertyTypeRepository propertyTypeRepository;

    @Autowired
    public EstateService(BuildingRepository buildingRepository, OwnerRepository ownerRepository, PropertyTypeRepository propertyTypeRepository) {
        this.buildingRepository = buildingRepository;
        this.ownerRepository = ownerRepository;
        this.propertyTypeRepository = propertyTypeRepository;

    }

    public List<Building> getBuildings() {
        return (List<Building>) buildingRepository.findAll();
    }

    public List<Building> getBuildingById(short id) {
        return buildingRepository.findByOwnerId(id);
    }

    public void saveBuilding(Building building) {

        PropertyType type = propertyTypeRepository.findByPropertyType(building.getPropertyType().getPropertyType());
        if (type == null) {
            propertyTypeRepository.save(building.getPropertyType());
        } else {
            building.setPropertyType(type);
        }
        Owner owner = ownerRepository.findByEmail(building.getPropertyType().getPropertyType());
        if (owner == null) {
            ownerRepository.save(building.getOwner());
        } else {
            building.setOwner(owner);
        }
        buildingRepository.save(building);
    }

    public void updateBuilding(Building building) {
        PropertyType update = propertyTypeRepository.findByPropertyType(building.getPropertyType().getPropertyType());
        if (update == null) {
            propertyTypeRepository.save(building.getPropertyType());
        } else {
            building.setPropertyType(update);
        }
        Owner owner = ownerRepository.findByEmail(building.getPropertyType().getPropertyType());
        if (owner == null) {
            ownerRepository.save(building.getOwner());
        } else {
            building.setOwner(owner);
        }
        buildingRepository.save(building);
    }

    public double getEstateTax(short ownerId) {
        List<Building> buildings = buildingRepository.findByOwnerId(ownerId);

        double result = 0;
        for (Building building : buildings) {
            result = result + building.getMarketValue() + building.getPropertyType().getTaxRate();
        }
        return result;
    }

    public void deleteBuilding(short id) {
        buildingRepository.deleteById(id);
    }
}

