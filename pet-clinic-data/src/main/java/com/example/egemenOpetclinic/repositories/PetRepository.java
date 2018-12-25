package com.example.egemenOpetclinic.repositories;

import com.example.egemenOpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
