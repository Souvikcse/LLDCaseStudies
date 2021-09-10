package com.system.design.lld.parkinglot.service.strategy.parking;
/**
 * @author nayanava
 */

import com.system.design.lld.parkinglot.models.Slot;
import com.system.design.lld.parkinglot.models.Vehicle;
import com.system.design.lld.parkinglot.repository.ISlotRepository;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NaturalOrderParkingStrategy implements ParkingStrategy {

    ISlotRepository slotRepository;

    public NaturalOrderParkingStrategy(ISlotRepository repository) {

        this.slotRepository = repository;
    }
    @Override
    public Slot fetchVacantSlot(Vehicle vehicle) {
        List<Slot> slots = this.slotRepository.fetch(slot -> slot.isSlotEmpty())
                .stream()
                .collect(Collectors.toList());
        if(slots.isEmpty()) {
            return null;
        }
        Slot nextSlot = null;
        synchronized (this) {
            nextSlot = slots.stream()
                    .min(Comparator.comparingInt(Slot::getSlotNumber))
                    .get();
        }
        return nextSlot;
    }
}