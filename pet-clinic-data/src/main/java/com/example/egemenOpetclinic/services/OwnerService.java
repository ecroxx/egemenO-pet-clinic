package com.example.egemenOpetclinic.services;

public interface OwnerService<Owner,Long> extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);

   /* Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();*/
}
