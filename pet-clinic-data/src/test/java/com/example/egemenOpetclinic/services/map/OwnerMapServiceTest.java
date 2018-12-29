package com.example.egemenOpetclinic.services.map;

import com.example.egemenOpetclinic.model.Owner;
import com.example.egemenOpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerService ownerService;

    final Long ownerID=1l;
    final String lastName="Smith";
   /* @Mock
    public PetService petService;
    @Mock
    public PetTypeService petTypeService;  */ // 2nd option to inject mock object by using mockito not by instantiating them
    @BeforeEach
    void setUp() {
        ownerService=new OwnerMapService(new PetTypeMapService(),new PetMapService());  // use above ref obj (petTypeService,petService) as a input parameter
        ownerService.save(Owner.builder().id(ownerID).lastName(lastName).build());
    }


    @Test
    void findAll() {
       assertEquals(1,ownerService.findAll().size());
    }

    @Test
    void findByLastName() {
       // System.out.println(ownerService.findByLastName(lastName).getLastName());
        assertEquals(lastName,ownerService.findByLastName(lastName).getLastName());
    }

    @Test
    void findByNoLastName() {
        assertNull(ownerService.findByLastName("egemen"));
    }

    @Test
    void findById() {
        assertEquals(ownerID,ownerService.findById(ownerID).getId());
    }

    @Test
    void saveExistingId() {
        final Long id = 2l;
        Owner owner2=Owner.builder().id(id).build();
        ownerService.save(owner2);
        assertEquals(id,ownerService.findById(id).getId());
    }

    @Test
    void saveNoID() {
        Owner noID= ownerService.save(Owner.builder().build());
        assertNotNull(noID);
        assertNotNull(noID.getId());
    }

    @Test
    void delete() {
        ownerService.delete(ownerService.findById(ownerID));
        assertEquals(0,ownerService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(ownerID);
        assertEquals(0,ownerService.findAll().size());
    }


}