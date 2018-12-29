package com.example.egemenOpetclinic.services.springdatajpa;

import com.example.egemenOpetclinic.model.Owner;
import com.example.egemenOpetclinic.repositories.OwnerRepository;
import com.example.egemenOpetclinic.repositories.PetRepository;
import com.example.egemenOpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @BeforeEach
    void setUp() {
        returnOwner=Owner.builder().id(1l).build();

    }
    final String LAST_NAME = "Smith";
    Owner returnOwner;

    @Test
    void findByLastName() {
        Owner owner1=Owner.builder().id(1l).lastName(LAST_NAME).build();
       when(ownerRepository.findByLastName(any())).thenReturn(owner1);
       Owner owner= ownerSDJpaService.findByLastName(LAST_NAME);

       assertEquals(LAST_NAME,owner.getLastName());
       verify(ownerRepository,times(1)).findByLastName(any());
    }

    @Test
    void findAll() {
        Owner owner1=Owner.builder().id(20l).build();
        Owner owner2=Owner.builder().id(30l).build();
        Set<Owner> ownerSet=new HashSet<>();
        ownerSet.add(owner1);
        ownerSet.add(owner2);

        when(ownerRepository.findAll()).thenReturn(ownerSet);
       // ownerSDJpaService.save(owner);
        //System.out.println(ownerSDJpaService.findAll());
       // Set<Owner> owners =ownerSDJpaService.findAll();
        Set<Owner> set=ownerSDJpaService.findAll();
        assertNotNull(set);
        assertEquals(2,ownerSDJpaService.findAll().size());
        verify(ownerRepository,times(2)).findAll();
    }

    @Test
    void findById() {
        System.out.println(returnOwner.getId());
       when(ownerRepository.findById(anyLong())).thenReturn(Optional.ofNullable(returnOwner));
       Owner owner=ownerSDJpaService.findById(1l);
       assertNotNull(owner);
       //assertEquals(1l,owner.getId());
        verify(ownerRepository).findById(1l);
    }
    @Test
    void findByIdNotFound() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner=ownerSDJpaService.findById(1l);
        assertNull(owner);
        //assertEquals(1l,owner.getId());
        verify(ownerRepository).findById(1l);
    }
    @Test
    void save() {
        Owner owner=Owner.builder().id(3l).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
       Owner savedOwner= ownerSDJpaService.save(owner);
       assertNotNull(savedOwner);
       verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(returnOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(4l);
        verify(ownerRepository).deleteById(anyLong());
    }
}