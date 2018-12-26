package com.example.egemenOpetclinic.services.springdatajpa;

import com.example.egemenOpetclinic.model.Speciality;
import com.example.egemenOpetclinic.repositories.SpecialityRepository;
import com.example.egemenOpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpaspeciality")
public class SpecialitySDJpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        HashSet<Speciality> specialities=new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }



    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);

    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
