package com.system.design.lld.parkinglot.service;
/**
 * @author nayanava
 */

import com.system.design.lld.parkinglot.models.Slot;
import com.system.design.lld.parkinglot.models.Vehicle;
import com.system.design.lld.parkinglot.repository.ISlotRepository;
import com.system.design.lld.parkinglot.service.strategy.parking.ParkingStrategy;

import java.io.InvalidObjectException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class SlotService {
    ParkingStrategy parkingStrategy;
    ISlotRepository slotRepository;

    public SlotService(ParkingStrategy parkingStrategy,
                       ISlotRepository slotRepository) {
        this.parkingStrategy = parkingStrategy;
        this.slotRepository = slotRepository;
    }

    public List<Slot> createSlots(int totalSlots) throws InvalidObjectException {
        List<Slot> slots = new LinkedList<>();
        for(int slotNumber = 1; slotNumber <= totalSlots; slotNumber++) {
            Slot slot = new Slot(slotNumber);
            slotRepository.save(slot);
            slots.add(slot);
        }
        return slots;
    }

    public Slot allotNextAvailableSlot(Vehicle vehicle) {
        Slot slot = parkingStrategy.fetchVacantSlot(vehicle);
        slot.assignCarToSlot(vehicle.getRegistrationNumber());
        slotRepository.update(slot);
        return slot;
    }

    public Slot releaseSlot(int slotNumber) {
        Slot slot = slotRepository.get(slotNumber);
        slot.isSlotEmpty();
        return slot;
    }
}
