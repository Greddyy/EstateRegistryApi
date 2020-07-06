package com.registry.estates.restController;


import com.registry.estates.entity.Building;
import com.registry.estates.repository.BuildingRepository;
import com.registry.estates.repository.OwnerRepository;
import com.registry.estates.repository.PropertyTypeRepository;
import com.registry.estates.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstateRestController {

    @Autowired
    BuildingRepository buildingRepository;
    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    PropertyTypeRepository propertyTypeRepository;
    @Autowired
    EstateService estateService;

    @GetMapping("/building")
    public List<Building> getAllBuildings() {
        return estateService.getBuildings();
    }

    @GetMapping("/building/{id}")
    public List<Building> getBuildingById(@PathVariable short id) {
        return estateService.getBuildingById(id);
    }

    @PostMapping("/saveBuilding")
    public void saveBuilding(@RequestBody Building building) {
        estateService.saveBuilding(building);
    }

    @PutMapping("/updateBuilding")
    public void updateBuilding(@RequestBody Building building) {
        estateService.updateBuilding(building);
    }

    @DeleteMapping("/deleteBuilding/{id}")
    public void deleteBuilding(@PathVariable short id) {
        estateService.deleteBuilding(id);

    }

    @GetMapping("/owner/tax/{ownerId}")
    public double getAllTax(@PathVariable short ownerId) {
        return estateService.getEstateTax(ownerId);
    }
}
