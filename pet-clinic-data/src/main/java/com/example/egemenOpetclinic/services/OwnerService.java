package com.example.egemenOpetclinic.services;

import com.example.egemenOpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner,Long> {

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);

   /* Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();

     @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
    */
}
