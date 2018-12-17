package com.example.egemenOpetclinic.services;

import com.example.egemenOpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);

   /* Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();*/
}
