package com.example.egemenOpetclinic.services.map;

import com.example.egemenOpetclinic.model.Visit;
import com.example.egemenOpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","VisitMapService"})

public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet()==null || visit.getPet().getOwner()==null ||
                visit.getPet().getId()==null || visit.getPet().getOwner().getId()==null)
        {throw new RuntimeException("Visit is Invalid. Please check it");}
        else{
        return super.save(visit);}
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
         super.deleteById(id);
    }
}
