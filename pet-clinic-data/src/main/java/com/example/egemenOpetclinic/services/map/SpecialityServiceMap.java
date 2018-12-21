package com.example.egemenOpetclinic.services.map;

import com.example.egemenOpetclinic.model.Speciality;
import com.example.egemenOpetclinic.services.SpecialitesService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality,Long> implements SpecialitesService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }



    @Override
    public void delete(Speciality object) {
         super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
         super.deleteById(id);
    }
}
