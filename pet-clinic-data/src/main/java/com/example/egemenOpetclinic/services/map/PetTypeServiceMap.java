package com.example.egemenOpetclinic.services.map;

import com.example.egemenOpetclinic.model.PetType;
import com.example.egemenOpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class PetTypeServiceMap extends AbstractMapService<PetType,Long> implements PetTypeService<PetType,Long> {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }



    @Override
    public void delete(PetType object) {
      super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
       super.deleteById(id);
    }
}