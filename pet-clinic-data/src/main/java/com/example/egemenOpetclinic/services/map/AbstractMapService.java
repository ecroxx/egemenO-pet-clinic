package com.example.egemenOpetclinic.services.map;

import com.example.egemenOpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService <T extends BaseEntity,ID extends Long>{
    protected Map<Long,T> map =new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        if (object!=null){
            if((object.getId()) == null){
                object.setId(generateId());
            }
            map.put((object.getId()),object);
        }else throw new RuntimeException();

        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    public Long generateId(){
        Long generatedId;
       try{ generatedId=Collections.max(map.keySet())+1;}
       catch (NoSuchElementException e) {generatedId=1L;}
        return generatedId;
    }
}
