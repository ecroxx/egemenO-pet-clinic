package com.example.egemenOpetclinic.services.map;

import com.example.egemenOpetclinic.model.Speciality;
import com.example.egemenOpetclinic.model.Vet;
import com.example.egemenOpetclinic.services.SpecialityService;
import com.example.egemenOpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","VetMapService"})

public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {

    SpecialityService specialtyService;

    public VetMapService(SpecialityService specialtyService) {
        this.specialtyService = specialtyService;
    }


    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpecialty = specialtyService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }

        return super.save(object);

    }
    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }
}