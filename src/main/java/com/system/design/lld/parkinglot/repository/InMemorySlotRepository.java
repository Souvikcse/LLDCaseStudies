package com.system.design.lld.parkinglot.repository;
/**
 * @author nayanava
 */

import com.system.design.lld.parkinglot.models.Slot;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InMemorySlotRepository implements ISlotRepository {

    Map<String, Slot> slots = new HashMap<>();
    @Override
    public void save(Slot entity) throws InvalidObjectException {
        if(slots.containsKey(entity.getSlotId())) {
            throw new InvalidObjectException("Duplicate slot Id already present");
        }
        slots.put(entity.getSlotId(), entity);
    }

    @Override
    public Slot get(Integer id) {
//        if(!slots.containsKey(id)) {
//            throw new MissingResourceException(String.format("%d is missing in repository", id));
//        }
        return slots.get(id);
    }

    @Override
    public boolean update(Slot entity) {
        slots.put(entity.getSlotId(), entity);
        return true;
    }

    @Override
    public void delete(Integer id) {
        slots.remove(id);
    }

    @Override
    public List<Slot> fetch(Function<Slot, Boolean> func) {
        return slots.values()
                .stream()
                .filter(slot -> func.apply(slot))
                .collect(Collectors.toList());
    }
}
