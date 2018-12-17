package com.example.egemenOpetclinic.services.map;

import com.example.egemenOpetclinic.model.Owner;
import com.example.egemenOpetclinic.services.OwnerService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService<Owner,Long> {

    @Override  // This will be implemented
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }



    @Override
    public void deleteById(Long id) {
          super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
           super.delete(object);
    }


}
