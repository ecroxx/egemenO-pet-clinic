package com.example.egemenOpetclinic.services.springdatajpa;

import com.example.egemenOpetclinic.model.Vet;
import com.example.egemenOpetclinic.repositories.SpecialityRepository;
import com.example.egemenOpetclinic.repositories.VetRepository;
import com.example.egemenOpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {
    private final VetRepository vetRepository;
    private final SpecialityRepository specialityRepository;

    public VetSDJpaService(VetRepository vetRepository, SpecialityRepository specialityRepository) {
        this.vetRepository = vetRepository;
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Vet> findAll() {
         Set<Vet> vets=new HashSet<>();
         vetRepository.findAll().forEach(vets::add);
         return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }



    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);

    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
