package com.registry.estates;

import com.registry.estates.entity.Building;
import com.registry.estates.entity.Owner;
import com.registry.estates.entity.PropertyType;
import com.registry.estates.repository.BuildingRepository;
import com.registry.estates.repository.OwnerRepository;
import com.registry.estates.repository.PropertyTypeRepository;
import com.registry.estates.services.EstateService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class EstatesApplicationTests {
    @Autowired
    EstateService estateService;
    @MockBean
    private BuildingRepository buildingRepository;
    @MockBean
    private OwnerRepository ownerRepository;
    @MockBean
    private PropertyTypeRepository propertyTypeRepository;

    @MockBean
    PropertyType propertyType;
    @MockBean
    Owner owner;
    @MockBean
    Building building;


    @Test
    public void returnAllBuildingsTest() {
        Mockito.when(buildingRepository.findAll()).thenReturn(Stream.of(new Building("Acquasparta", "Quis Avenue", (short) 1, 250, 52000.25, propertyType, owner),
                new Building("Langollen", "Mollestie St.", (short) 6, 320, 165000, propertyType, owner), new Building("Anghiari", "Sed Ave", (short) 10, 62, 85000, propertyType, owner))
                .collect(Collectors.toList()));
        Assert.assertEquals(3, estateService.getBuildings().size());
    }

    @Test
    public void BuildingByOwnerIdTest() {
        short id = 5;

        Mockito.when(buildingRepository.findByOwnerId(id)).thenReturn(Stream.of(new Building("Anghiari", "Sed Ave", (short) 10, 62, 85000, propertyType, owner))
                .collect(Collectors.toList()));
        Assert.assertEquals(1, estateService.getBuildingById(id).size());

    }


    @Test
    public void DeleteBuildingByIdTest() {
        short id = 5;
        buildingRepository.deleteById(id);
        Mockito.verify(buildingRepository, Mockito.times(1)).deleteById(id);
    }

    @Test
    public void SaveBuildingTest() {
        Building building = new Building("Vottem", "Consectetuer Road", (short) 2, 125.75, 78000.47, propertyType, owner);
        estateService.saveBuilding(building);
        Mockito.verify(buildingRepository, Mockito.times(1)).save(building);

    }

    @Test
    public void UpdateBuildingTest() {
        Building building = new Building("Poederlee", "Sit Avenue", (short) 7, 245.74, 83000, propertyType, owner);
        estateService.updateBuilding(building);
        Mockito.verify(buildingRepository, Mockito.times(1)).save(building);

    }

}
